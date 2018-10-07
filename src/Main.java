import system.DirectorySystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DirectorySystem dirSystem = new DirectorySystem();
        boolean exit = false;

        System.out.println("Welcome to the Multi-Parent Directory System!\n");

        Scanner sc = new Scanner(System.in);
        while (!exit) {
            int choice = -1;
            while (choice < 0 || choice > 4) {
                try {
                    System.out.println("\nMAIN MENU");
                    System.out.println("1. Print complete path of all nodes for initial system");
                    System.out.println("2. Print complete path of all nodes for example 1");
                    System.out.println("3. Print complete path of all nodes for example 2");
                    System.out.println("4. Example 3, which allows cyclical node (for demonstration of detectCycle())");
                    System.out.println("0. Exit");
                    System.out.print("Enter your command: ");
                    choice = Integer.parseInt(sc.nextLine()); // already throws
                } catch (NumberFormatException e) {
                    System.out.println("Invalid command. Please try again (0-3).\n");
                }
            }
            if (choice == 0) {
                System.out.println("Thank you for using the Multi-Parent Directory System!");
                System.out.println("See you again!");
                exit = true;
            }
            dirSystem.execute(choice);

            System.out.print("Press Enter/Return to continue...");
            String input = sc.nextLine();
            System.out.println("===================================================\n");
        }
    }
}
