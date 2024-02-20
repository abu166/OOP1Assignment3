import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static StudentDAO dataAO = new StudentDAO();

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter student name: ");
        String name = scanner.next();

        Student student = dataAO.getStudentById(id);

        if (student == null || !student.getName().equals(name)) {
            System.out.println("Invalid student ID or name.");
            System.out.println("You are not allowed to enter the University.");
            return;
        }

        System.out.println("Welcome, " + student.getName() + "! You are at the University.");

        System.out.println("Do you want to enter the University? (yes/no)");
        String enterChoice = scanner.next();

        if (enterChoice.equalsIgnoreCase("yes")) {
            System.out.println("You entered the University.");

            System.out.println("Choose where you want to go:");
            System.out.println("1. Library");
            System.out.println("2. OpenSpace");
            System.out.println("3. Dining Room");
            int universityChoice = scanner.nextInt();

            switch (universityChoice) {
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

    public static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter student name: ");
        String name = scanner.next();

        Student student = new Student(id, name);

        dataAO.addStudent(student);
    }

    public static void updateStudent() {
        System.out.println("List of Students:");
        for (Student student : dataAO.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        Student student = dataAO.getStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new ID: ");
        int newId = scanner.nextInt();

        System.out.print("Enter new name: ");
        String newName = scanner.next();

        student.setId(newId);
        student.setName(newName);

        dataAO.updateStudent(student);

        System.out.println("Student updated successfully.");
    }
    public static void deleteStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        dataAO.deleteStudent(id);
    }
}