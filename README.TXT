PROJECT TITLE:
Student Database Management System

PURPOSE OF PROJECT:
The purpose of this project is to manage a database of students and their academic records. The program allows the user to add, delete, update, and print student information. Each student record stores the student's ID, first name, last name, total credits, and grade points. The program calculates the student's GPA and determines academic honors such as Cum Laude, Magna Cum Laude, and Summa Cum Laude based on GPA thresholds.

VERSION or DATE:
Version 5.0 – December 2026

HOW TO START THIS PROJECT:

1. Save the two program files as **MyStudent.java** and **Prog5.java**.
2. Open a terminal or command prompt.
3. Compile the files using the command:
   `javac MyStudent.java Prog5.java`
4. Run the program using the command:
   `java Prog5`
5. Follow the menu options displayed on the screen to manage student records.

AUTHORS:
Aaditya Bhandari

USER INSTRUCTIONS:

1. After running the program, a menu will appear with the following options:

   * 1: Add a student
   * 2: Delete a student
   * 3: Update a student
   * 4: Print all students
   * 5: Exit the program

2. **Add Student (Option 1):**

   * Enter a valid 9-digit student ID.
   * Enter the student's first name and last name.
   * Enter the total credits and total grade points for the student.
   * The student will be added to the database if the ID does not already exist.

3. **Delete Student (Option 2):**

   * Enter the student ID of the student you want to remove.
   * If the ID exists, the student record will be deleted.

4. **Update Student (Option 3):**

   * Enter the student ID.
   * Enter the number of credits and the letter grade for a new class.
   * The program will update the student's total credits and grade points and recalculate the GPA.

5. **Print Students (Option 4):**

   * Displays all students sorted by last name, then first name, then ID.
   * The table shows the student ID, name, GPA, and any honors earned.

6. **Exit (Option 5):**

   * Ends the program and displays a termination message.

