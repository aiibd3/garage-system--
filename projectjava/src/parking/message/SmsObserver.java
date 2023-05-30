package parking.message;

public class SmsObserver implements MassageObserver {
    @Override
    public void sendMassage(MessageData massageData) {
        System.out.print("__________________________________________\n");
        System.out.print("From: ");
        System.out.println(massageData.getDuration().startTime());
        System.out.print("To  : ");
        System.out.println(massageData.getDuration().endTime());

        System.out.println("\nPlate Number : " + massageData.getVehicle().getPlateNumber()
                +"Model Name : " + massageData.getVehicle().getModelName()
                +"Model year : " + massageData.getVehicle().getModelYear()
                +"Width : "+ massageData.getVehicle().getWidth()
                +"Length : "+ massageData.getVehicle().getLength());
        System.out.println("Total Hours: " + massageData.getDuration().totalHours());
        System.out.println("Total cost : " + massageData.getCost() + " EGP ");
        System.out.print("__________________________________________\n");
    }
}
