package parking;

public class FirstFit implements SelectionSlot {
    @Override
    public int selection(Slot[] slot, Vehicle vehicle) {
        for (int i = 0; i < slot.length; i++) {

            if (vehicle.getWidth() <= slot[i].getSlotWidth() && vehicle.getLength() <= slot[i].getSlotDepth() && slot[i].isAvailable()) {
                System.out.println("slot number " + slot[i].getSlotName() + " found ");
                return i;
            }
        }
        return -1;
    }
}
