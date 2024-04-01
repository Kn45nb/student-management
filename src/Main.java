import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Enter student list");
            System.out.println("2. Find students by last name");
            System.out.println("3. Find and edit students by full name");
            System.out.println("4. End");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterStudentInformation(studentList, scanner);
                    break;
                case 2:
                    findStudentByLastName(studentList, scanner);
                    break;
                case 3:
                    findAndEditStudentsByFullName(studentList, scanner);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        } while (choice != 4);
        }
    public static void enterStudentInformation(ArrayList<Student> studentList, Scanner scanner){
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            Student student = new Student(firstName, lastName);
            studentList.add(student);
        }
        System.out.println("Student list updated successfully!");
    }
    public static void findStudentByLastName(ArrayList<Student> studentList, Scanner scanner){
        System.out.print("Enter last name to search: ");
        String search = scanner.nextLine();

        ArrayList<Student> foundStudent = new ArrayList<>();

        for (Student student : studentList){
            if (student.getLastName().equalsIgnoreCase(search)){
                foundStudent.add(student);
            }
        }
        if (foundStudent.isEmpty()){
            System.out.println("No student found with given last name.");
        }else {
            System.out.println("Students with the last name " + search + ":");
            for (Student student : foundStudent){
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
    }
    public static void findAndEditStudentsByFullName(ArrayList<Student> studentList, Scanner scanner){
        System.out.print("Enter full name to search: ");
        String searchFull = scanner.nextLine();

        Student foundStudent = null;

        for (Student student : studentList) {
            String fullName = student.getFirstName() + " " + student.getLastName();
            if (fullName.equalsIgnoreCase(searchFull)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent == null) {
            System.out.println("No student found with the given full name.");
        } else {
            System.out.print("Student found: ");
            System.out.println(foundStudent.getFirstName() + " " + foundStudent.getLastName());

            System.out.println("Enter new details for student:");
            System.out.print("First name: ");
            String newFirstN = scanner.nextLine();
            System.out.print("Last name: ");
            String newLastN = scanner.nextLine();

            foundStudent.setFirstName(newFirstN);
            foundStudent.setLastName(newLastN);

            System.out.println("Student details updated successfully!");
        }
    }
    }


