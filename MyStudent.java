/**
 * Represents a student with details such as ID, name, credits, and grade points.
 * The class supports calculating GPA and updating student records based on grades.
 * 
 * Grades are mapped to standard grade points to calculate the GPA.
 * 
 * @author Aaditya
 */
public class MyStudent {

    // Grade points mapping for various letter grades
    final double A_PTS       = 4.00;
    final double A_MINUS_PTS = 3.67;
    final double B_PLUS_PTS  = 3.33;
    final double B_PTS       = 3.00;
    final double B_MINUS_PTS = 2.67;
    final double C_PLUS_PTS  = 2.33;
    final double C_PTS       = 2.00;
    final double C_MINUS_PTS = 1.67;
    final double D_PLUS_PTS  = 1.33;
    final double D_PTS       = 1.00;
    final double D_MINUS_PTS = 0.67;
    final double F_PTS       = 0.00;

    private String id;               // The student ID
    private String firstName;        // The student's first name
    private String lastName;         // The student's last name
    private int totalCredits;        // Total credits completed by the student
    private double totalGradePoints; // Total grade points accumulated by the student

    /**
     * Constructor for creating a "dummy" student with just an ID.
     * Used primarily for searching or comparison purposes.
     * 
     * @param id The student ID.
     */
    public MyStudent(String id) {
        this.id = id; // Initialize the student ID
    }

    /**
     * Constructor for creating a student with all details.
     * 
     * @param id               The student ID.
     * @param firstName        The first name of the student.
     * @param lastName         The last name of the student.
     * @param totalCredits     The total credits completed by the student.
     * @param totalGradePoints The total grade points accumulated by the student.
     */
    public MyStudent(String id, String firstName, String lastName, int totalCredits, double totalGradePoints) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalCredits = totalCredits;
        this.totalGradePoints = totalGradePoints;
    }

    /**
     * Gets the student ID.
     * 
     * @return The student ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the first name of the student.
     * 
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the student.
     * 
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the GPA (Grade Point Average) of the student.
     * 
     * @return The GPA, or 0.0 if the student has no completed credits.
     */
    public double getGPA() {
        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }
        return totalGradePoints / totalCredits; // Calculate GPA
    }

    /**
     * Updates the student's records by adding the grade points and credits for a new class.
     * If the grade is invalid, no changes are made.
     * 
     * @param credits The number of credits for the class.
     * @param grade   The letter grade received for the class (e.g., "A", "B+", etc.).
     */
    public void takeClass(int credits, String grade) {
        double gradePoints = 0.0; // Initialize grade points

        // Determine grade points based on the grade
        if (grade.equals("A")) {
            gradePoints = A_PTS;
        } else if (grade.equals("A-")) {
            gradePoints = A_MINUS_PTS;
        } else if (grade.equals("B+")) {
            gradePoints = B_PLUS_PTS;
        } else if (grade.equals("B")) {
            gradePoints = B_PTS;
        } else if (grade.equals("B-")) {
            gradePoints = B_MINUS_PTS;
        } else if (grade.equals("C+")) {
            gradePoints = C_PLUS_PTS;
        } else if (grade.equals("C")) {
            gradePoints = C_PTS;
        } else if (grade.equals("C-")) {
            gradePoints = C_MINUS_PTS;
        } else if (grade.equals("D+")) {
            gradePoints = D_PLUS_PTS;
        } else if (grade.equals("D")) {
            gradePoints = D_PTS;
        } else if (grade.equals("D-")) {
            gradePoints = D_MINUS_PTS;
        } else if (grade.equals("F")) {
            gradePoints = F_PTS;
        } else {
            System.out.println("Invalid grade provided: " + grade); // Log error and skip
            return;
        }

        totalGradePoints += gradePoints * credits; // Add grade points for this class
        totalCredits += credits; // Update total credits
    }
}
