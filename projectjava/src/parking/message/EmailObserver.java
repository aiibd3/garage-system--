package parking.message;

public class EmailObserver implements MassageObserver {

    @Override
    public void sendMassage(MessageData massageData) {
        System.out.print("__________________________________________\n");
        System.out.print("From : Parking@gmail.com\t");
        System.out.print("To : "+massageData.getVehicle().getEmailOwner()+"\n\n");
        System.out.println(massageData.getDuration().startTime()+"  /  "+massageData.getDuration().endTime());
        System.out.println("\nPlate Number : " + massageData.getVehicle().getPlateNumber()
                +"\nModel Name : " + massageData.getVehicle().getModelName()
                +"               "
                +"Model year : " + massageData.getVehicle().getModelYear()
                +"\nWidth : "+ massageData.getVehicle().getWidth()
                +"               "
                +"Length : "+ massageData.getVehicle().getLength()
                +" \n" );
        System.out.println("Total Hours: " + massageData.getDuration().totalHours());
        System.out.println("Total cost : " + massageData.getCost() + " EGP ");
        System.out.print("__________________________________________\n");

    }
}
