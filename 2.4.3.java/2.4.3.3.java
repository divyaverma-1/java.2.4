import java.util.*;

public class StudentView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            StudentDAO dao = new StudentDAO();
            while (true) {
                System.out.println("\n=== Student Management System ===");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();
                        dao.addStudent(new Student(id, name, dept, marks));
                        break;

                    case 2:
                        System.out.println("\nID\tName\tDept\tMarks");
                        dao.getAllStudents().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();
                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();
                        dao.updateStudentMarks(sid, newMarks);
                        break;

                    case 4:
                        System.out.print("Enter Student ID to Delete: ");
                        int did = sc.nextInt();
                        dao.deleteStudent(did);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
