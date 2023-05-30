package parking;

import parking.message.*;

import java.util.Random;
import java.util.Scanner;

public class Garage {
    private static int totalIncome;
    private final int size;
    private final Slot[] slots;

    public Garage(int s) {
        size = s;
        slots = new Slot[s];
        Random random = new Random();
        String namePrefix = "Slot ";
        for (int i = 0; i < size; i++) {

            int width = random.nextInt(160 - 100) + 100;
            int depth = random.nextInt(250 - 180) + 180;

            Slot slot = new Slot.SlotBuilder()
                    .setSlotName(namePrefix + (i + 1))
                    .setSlotDepth(depth)
                    .setSlotWidth(width)
                    .setSlotCost((width + depth) / 10)
                    .build();

            slots[i] = slot;

        }
    }

    public static int getTotalIncome() {
        return totalIncome;
    }

    void bookSlot(int selectMode, Vehicle vehicle) {

        if (selectMode == 1) {

            SelectionSlot firstFit = new FirstFit();

            int first = firstFit.selection(slots, vehicle);
            if (first != -1) {

                slots[first].setCurrentVehicle(vehicle);
                slots[first].setAvailable(false);

                Duration duration = new Duration();
                duration.setStartTime();
                slots[first].setDuration(duration);

            } else {
                System.out.println("Slot not Available ");
            }


        } else if (selectMode == 2) {

            SelectionSlot bestFit = new BestFit();

            int best = bestFit.selection(slots, vehicle);

            if (best != -1) {
                slots[best].setCurrentVehicle(vehicle);
                slots[best].setAvailable(false);

                Duration duration = new Duration();
                duration.setStartTime();
                slots[best].setDuration(duration);
            } else {

                System.out.println("Slot not Available ");
            }
        }
    }

    MessageData leaveSlot(int slotNumber) {

        MessageData messageData = new MessageData();

        if (slots[slotNumber - 1].isAvailable()) {

            System.out.println("Slot number [" + slotNumber + "] is already available");

        } else {
            slots[slotNumber - 1].setAvailable(true);


            Duration duration = slots[slotNumber - 1].getDuration();
            duration.setEndTime();


            int totalSpentHours = duration.timeSpent();
            int totalCost = totalSpentHours * slots[slotNumber - 1].getSlotCost();
            incrementTotalIncome(totalCost);


            messageData.setVehicle(slots[slotNumber - 1].getCurrentVehicle());
            messageData.setDuration(duration);
            messageData.setCost(totalCost);


            slots[slotNumber - 1].setDuration(null);
        }
        return messageData;
    }

    public int calculeteVehicleNumber() {
        int count = 0;

        for (Slot slot : slots) {
            if (!slot.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    private void incrementTotalIncome(int cost) {
        totalIncome += cost;
    }

    void show() {
        for (int i = 0; i < size; i++) {
            slots[i].print();
        }
    }
}
