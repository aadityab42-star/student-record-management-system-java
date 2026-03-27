import java.util.Scanner;
import java.util.ArrayList;
/**
 * A program to manage a student database with options to add, delete, update, 
 * and print student information. The program maintains a list of students 
 * and their associated details like GPA and credits.
 * 
 * @author Aaditya Bhandari
 */
public class Prog5 {
    public static final int ADD = 1;
    public static final int DELETE = 2;
    public static final int UPDATE = 3;
    public static final int PRINT = 4;
    public static final int EXIT = 5;
    public static final int ID_LENGTH = 9;
    public static final double SUMMA_CUM_LAUDE_THRESHOLD = 3.75;
    public static final double MAGNA_CUM_LAUDE_THRESHOLD = 3.50;
    public static final double CUM_LAUDE_THRESHOLD = 3.00;

    /**
     * Main method to execute the student management program.
     * 
     * @param args Command-line arguments.
     */
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("!! Welcome to Program 5 !!");

        ArrayList<MyStudent> students = new ArrayList<>();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getValidChoice(in);
            if (choice == EXIT) break;

            if (choice == ADD) {
                handleAdd(in, students);
            } else if (choice == DELETE) {
                handleDelete(in, students);
            } else if (choice == UPDATE) {
                handleUpdate(in, students);
            } else if (choice == PRINT) {
                handlePrint(students);
            }
        }

        System.out.println("\nDone. Normal termination.");
    }

    /**
     * Prints the menu of options available to the user.
     */
    private static void printMenu() {
        System.out.println("\nOPTIONS:");
        System.out.println("1. ADD student.");
        System.out.println("2. DELETE student.");
        System.out.println("3. UPDATE student.");
        System.out.println("4. PRINT all students.");
        System.out.println("5. EXIT.");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    /**
     * Reads and validates the user's menu choice.
     * 
     * @param in The Scanner object to read input.
     * @return The valid menu choice as an integer.
     */
    private static int getValidChoice(Scanner in) {
        int choice = in.nextInt();
        while (choice < ADD || choice > EXIT) {
            System.out.println("ERROR -- invalid menu option.");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
        }
        return choice;
    }

    /**
     * Handles the addition of a new student to the list.
     * 
     * @param in The Scanner object to read input.
     * @param students The list of students.
     */
    private static void handleAdd(Scanner in, ArrayList<MyStudent> students) {
        System.out.print("\nEnter student ID: ");
        String id = in.next();
        if (id.length() != ID_LENGTH) {
            System.out.println("ERROR -- invalid id.");
            return;
        }

        MyStudent dummy = new MyStudent(id);
        if (find(students, dummy) != -1) {
            System.out.println("ERROR -- id=" + id + " already exists.");
            return;
        }

        System.out.print("Enter first name: ");
        String firstName = in.next();
        System.out.print("Enter last name: ");
        String lastName = in.next();
        System.out.print("Enter number of credits: ");
        int credits = in.nextInt();
        System.out.print("Enter number of grade points: ");
        double gradePoints = in.nextDouble();

        MyStudent newStudent = new MyStudent(id, firstName, lastName, credits, gradePoints);
        students.add(newStudent);
        System.out.println("ADD successful.");
    }

    /**
     * Handles the deletion of a student from the list.
     * 
     * @param in The Scanner object to read input.
     * @param students The list of students.
     */
    private static void handleDelete(Scanner in, ArrayList<MyStudent> students) {
        System.out.print("\nEnter student ID: ");
        String id = in.next();

        MyStudent dummy = new MyStudent(id);
        int index = find(students, dummy);

        if (index == -1) {
            System.out.println("DELETE not successful (id=" + id + " DOES NOT exist).");
        } else {
            students.remove(index);
            System.out.println("DELETE successful.");
        }
    }

    /**
     * Handles updating a student's information.
     * 
     * @param in The Scanner object to read input.
     * @param students The list of students.
     */
    private static void handleUpdate(Scanner in, ArrayList<MyStudent> students) {
        System.out.print("\nEnter student ID: ");
        String id = in.next();

        MyStudent dummy = new MyStudent(id);
        int index = find(students, dummy);

        if (index == -1) {
            System.out.println("ERROR -- id=" + id + " DOES NOT exist.");
            return;
        }

        System.out.print("Enter number of credits: ");
        int credits = in.nextInt();
        System.out.print("Enter grade for the class: ");
        String grade = in.next();

        MyStudent student = students.get(index);
        student.takeClass(credits, grade);
        System.out.println("UPDATE successful.");
    }

    /**
     * Handles printing the list of students sorted by last name, first name, and ID.
     * Also prints GPA honors.
     * 
     * @param students The list of students.
     */
    private static void handlePrint(ArrayList<MyStudent> students) {
        if (students.isEmpty()) {
            System.out.println("\nNO students.");
            return;
        }

        // Sort the students before printing
        sort(students);

        System.out.println("\nID        LAST, FIRST                    GPA  HONORS");
        System.out.println("--------- ------------------------------ ---- ---------------");
        for (MyStudent student : students) {
            double gpa = student.getGPA();
            String honors = "";

            if (gpa >= SUMMA_CUM_LAUDE_THRESHOLD) {
                honors = "SUMMA CUM LAUDE";
            } else if (gpa >= MAGNA_CUM_LAUDE_THRESHOLD) {
                honors = "MAGNA CUM LAUDE";
            } else if (gpa >= CUM_LAUDE_THRESHOLD) {
                honors = "CUM LAUDE";
            }

            System.out.printf("%-9s %-30s %-4.2f %s%n",
                             student.getId(),
                             student.getLastName() + ", " + student.getFirstName(),
                             gpa,
                             honors);
        }
    }
    
    /**
     * Sorts a list of students in-place using the Selection Sort algorithm.
     * The students are sorted primarily by last name, then by first name, and finally by ID.
     *
     * @param students an ArrayList of MyStudent objects to be sorted.
     *                 The sorting is done directly on the provided list.
     */
    private static void sort(ArrayList<MyStudent> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < students.size(); j++) {
                if (compareStudents(students.get(j), students.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap the elements
            MyStudent temp = students.get(minIndex);
            students.set(minIndex, students.get(i));
            students.set(i, temp);
        }
    }
    
    /**
     * Finds a student in the list by matching their ID.
     * 
     * @param students The list of students.
     * @param target The student to find.
     * @return The index of the student, or -1 if not found.
     */
    private static int find(ArrayList<MyStudent> students, MyStudent target) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(target.getId())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Compares two students based on last name, first name, and ID.
     * 
     * @param s1 The first student.
     * @param s2 The second student.
     * @return A negative value if s1 comes before s2, a positive value if s1 comes after s2, or 0 if equal.
     */
    private static int compareStudents(MyStudent s1, MyStudent s2) {
        int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
        if (lastNameComparison != 0) return lastNameComparison;

        int firstNameComparison = s1.getFirstName().compareTo(s2.getFirstName());
        if (firstNameComparison != 0) return firstNameComparison;

        return s1.getId().compareTo(s2.getId());
    }
}
