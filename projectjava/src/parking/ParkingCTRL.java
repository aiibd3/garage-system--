package parking;

import parking.message.MessageData;

public class ParkingCTRL {

    private final int size;
    private final Garage garage;
    private Vehicle vehicle;
    private int currentMode;

    public ParkingCTRL(int size) {
        this.size = size;
        this.garage = new Garage(size);
    }

    public void setCurrentMode(int currentMode) {
        this.currentMode = currentMode;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    void display() {
        garage.show();
    }

    public void parkIn() {
        garage.bookSlot(currentMode, vehicle);
    }

    public MessageData parkOut(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= size) {
            return garage.leaveSlot(slotNumber);
        }
        return null;
    }

    public int calculteTotalIncome() {
        return Garage.getTotalIncome();
    }

    public int calculeteVehicleNumber() {
        return garage.calculeteVehicleNumber();
    }

}
