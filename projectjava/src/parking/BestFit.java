package parking;

import java.util.Arrays;

public class BestFit implements SelectionSlot {
    @Override
    public int selection(Slot[] slot, Vehicle vehicle) {

        Slot[] tempSlot;
        tempSlot = Arrays.copyOf(slot, slot.length);

        bubbleSort(tempSlot);
        for (int i = 0; i < slot.length; i++) {

            if (vehicle.getWidth() <= slot[i].getSlotWidth() && vehicle.getLength() <= slot[i].getSlotDepth() && slot[i].isAvailable()) {
                System.out.println("slot number " + slot[i].getSlotName() + " found ");
                return i;
            }
        }
        return -1;
    }

    private void bubbleSort(Slot[] arr) {
        int n = arr.length;
        Slot temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].getSlotWidth() > arr[j].getSlotWidth()) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}