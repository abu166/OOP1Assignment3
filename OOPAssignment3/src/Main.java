import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.println("Welcome, " + name + "! You are at the University.");

        System.out.println("Do you want to enter the University? (yes/no)");
        String enterChoice = scanner.next();

        if (enterChoice.equalsIgnoreCase("yes")) {
            System.out.println("You entered the University.");

            System.out.println("Choose where you want to go:");
            System.out.println("1. Library");
            System.out.println("2. OpenSpace");
            System.out.println("3. Dining Room");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You are in the Library.");
                    break;
                case 2:
                    System.out.println("You are in the OpenSpace.");
                    break;
                case 3:
                    System.out.println("You are in the Dining Room.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

            System.out.println("Do you want to stay at the University and study? (yes/no)");
            String stayChoice = scanner.next();

            if (stayChoice.equalsIgnoreCase("yes")) {
                System.out.println("You chose to stay and study.");
            } else {
                System.out.println("You left the University.");
            }
        } else {
            System.out.println("You chose not to enter the University.");
            System.out.println("You left the University.");
        }
    }
}
