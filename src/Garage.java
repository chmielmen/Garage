import classes.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Garage {

    public static void menu() {
        System.out.println("Welcome into awesome garage!");
        System.out.println(" ");
        System.out.println("If you want to add a vehicle, type +");
        System.out.println("If you want to see vehicles in garage, type v");
        System.out.println("If you want to quit, type q");
    }

    public static void printVehicles(List<Vehicle> vehicles) {
        if(vehicles.size() == 0) {
            System.out.println("Garage is empty");
        } else {
            for(Vehicle vehicle : vehicles) {
                System.out.println(vehicle.getName() + " / " +
                        vehicle.getHorsepower() + " HP / " +
                        vehicle.getColor());
            }
        }
    }

    public static void addVehicle(Scanner scanner, List<Vehicle> vehicles) {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Horsepower: ");
        String horsepower = scanner.nextLine();
        System.out.println("Color: ");
        String color = scanner.nextLine();

        Vehicle vehicle = new Vehicle();
        vehicle.setName(name);
        vehicle.setHorsepower(horsepower);
        vehicle.setColor(color);
        vehicles.add(vehicle);
    }

    public static void main(String args[]) {
        List<Vehicle> vehicles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        menu();

        while (run) {
            String command = scanner.nextLine();

            if(command.equals("q")) {
                System.out.println("=== GOOD BYE ===");
                run = false;
            } else if(command.equals("+")) {
                addVehicle(scanner, vehicles);
                System.out.println("Vehicle added!");
            } else if(command.equals("v")) {
                printVehicles(vehicles);
            } else {
                System.out.println("Wrong command");
            }
        }
    }
}