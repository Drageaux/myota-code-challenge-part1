import system.DirectorySystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DirectorySystem dirSystem = new DirectorySystem();
        boolean exit = false;

        while (!exit) {
            Scanner sc = new Scanner(System.in);
            int choice = -1;
            while (choice < 0 || choice > 4) {
                try {
                    System.out.println("1. Get root directory");
                    System.out.println("2. Add child");
                    System.out.println("3. Detect cycle");
                    System.out.println("4. Print complete path of all nodes");
                    System.out.print("Enter your command: ");
                    choice = Integer.parseInt(sc.nextLine()); // already throws
                } catch (NumberFormatException e) {
                    System.out.println("Invalid command. Please try again (0-4).");
                }
            }
            if (choice == 0) {
                System.out.println("Thank you for using the Multi-Parent Directory System!");
                System.out.println("See you again!");
                exit = true;
            }
            dirSystem.execute(choice);
            System.out.println("\n===================================================\n");
        }
    }
}
