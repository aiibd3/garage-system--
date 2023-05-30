package parking;

public class Screen {

    // function to show home screen
    public static void HomeScreen() {
        System.out.println("***************************************");
        System.out.println("\n1- View slots for dimensions.");
        System.out.println("2- Park in.");
        System.out.println("3- Park out.");
        System.out.println("4- Total income.");
        System.out.println("5- Number of vehicles.");
        System.out.println("6- Exit.\n");
        System.out.println("***************************************");

    }

    // Screen to show start date and end date and car info
    public static void ticketScreen(Vehicle car, int cost, Duration Total) {
        System.out.println("\n\t\t\t== Ticket ==\n");
        System.out.print("From: ");
        System.out.println(Total.startTime());
        System.out.print("To  : ");
        System.out.println(Total.endTime());

        System.out.println("\nPlate Number : " + car.getPlateNumber()
                +" \n \n"
                +"Phone : " + car.getPhoneOwner()
                +" \t \t \t"
                +"Email : " + car.getEmailOwner()
                +" \n \n"
                +"Model Name : " + car.getModelName()
                +" \t \t \t"
                +"Model year : " + car.getModelYear()
                +" \n \n"
                +"Width : "+ car.getWidth()
                +" \t \t \t    "
                +"Length : "+ car.getLength()
                +" \n" );
        System.out.println("Total Hours: " + Total.totalHours());
        System.out.println("Total cost : " + cost + " EGP ");
    }
}

