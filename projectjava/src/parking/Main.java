package parking;

import parking.message.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of slots : ");
        int size = scanner.nextInt();
        ParkingCTRL parking = new ParkingCTRL(size);

        while (true) {
            int choice;
            Screen.HomeScreen();
            System.out.print("Enter choice : ");
            choice = scanner.nextInt();

            if (choice == 1) {
                parking.display();

            } else if (choice == 2) {
                int choose;
                Vehicle vehicle = new Vehicle();
                System.out.println("\n == pleas enter vehicle information == ");

                try {
                    System.out.print("Plate Number : ");
                    int plateNumber = scanner.nextInt();
                    vehicle.setPlateNumber(plateNumber);

                } catch (RuntimeException ex) {
                    System.out.println("Invalid id format..please try again.");
                    Screen.HomeScreen();

                }


                try {
                    System.out.print("Phone : ");
                    int Phone = scanner.nextInt();
                    vehicle.setPhoneOwner(Phone);
                    System.out.print("");
                } catch (RuntimeException ex) {
                    System.out.println("Invalid Phone format..please try again.");
                    Screen.HomeScreen();
                }

                scanner.nextLine();

                System.out.print("Email : ");
                String emailOwner = scanner.nextLine();
                vehicle.setEmailOwner(emailOwner);
                System.out.print("");


                System.out.print("Model Name : ");
                String modelName = scanner.nextLine();
                vehicle.setModelName(modelName);
                System.out.print("");


                System.out.print("Model Year : ");
                String modelYear = scanner.nextLine();
                vehicle.setModelYear(modelYear);
                System.out.print("");


                try {
                    System.out.print("Width : ");
                    int width = scanner.nextInt();
                    vehicle.setWidth(width);
                    System.out.print("");
                } catch (RuntimeException ex) {
                    System.out.println("Invalid width format..please try again.");
                    Screen.HomeScreen();
                }


                try {
                    System.out.print("Length : ");
                    int length = scanner.nextInt();
                    vehicle.setLength(length);
                    System.out.print("");
                } catch (RuntimeException ex) {
                    System.out.println("Invalid Length format..please try again.");
                    Screen.HomeScreen();
                }

                parking.setVehicle(vehicle);
                System.out.println("\n== please select parking mood ==\n");
                System.out.println("1# First Fit ");
                System.out.println("2# Best Fit");

                try {
                    choose = scanner.nextInt();

                    if (choose == 1) {
                        parking.setCurrentMode(1);
                        parking.parkIn();

                    } else if (choose == 2) {
                        parking.setCurrentMode(2);
                        parking.parkIn();

                    } else {
                        System.out.println("invalid selected mode!");

                    }

                } catch (RuntimeException ex) {
                    Screen.HomeScreen();
                }

            } else if (choice == 3) {

                System.out.println("Please enter slot number : ");
                int slotNumber = scanner.nextInt();
                MessageData messageData = parking.parkOut(slotNumber);

                if (messageData != null) {

                    System.out.println("Do you want to send notification ?");
                    System.out.println("1. SMS");
                    System.out.println("2. Email");
                    System.out.println("3. Cancel");
                    int ticketChoice= scanner.nextInt();

                    MessageHandler messageHandler = new MessageHandler();
                    if (ticketChoice == 1) {
                        MassageObserver smsObserver = new SmsObserver();
                        messageHandler.subscribe(smsObserver);
                        messageHandler.handleMessageData(messageData);

                    } else if (ticketChoice == 2) {
                        MassageObserver emailObserver = new EmailObserver();
                        messageHandler.subscribe(emailObserver);
                        messageHandler.handleMessageData(messageData);

                    } else {
                        Screen.ticketScreen(messageData.getVehicle(), messageData.getCost(), messageData.getDuration());

                    }

                } else {
                    System.out.println("invalid slot number");

                }

            } else if (choice == 4) {
                System.out.println("Garage total income = " + parking.calculteTotalIncome());

            } else if (choice == 5) {
                System.out.println("Total number of vehicles = " + parking.calculeteVehicleNumber());

            } else if (choice == 6) {
                System.out.println("Bye Bye ^_^");
                break;

            } else {
                System.out.println("Error !!!");
            }

        }
    }
}
