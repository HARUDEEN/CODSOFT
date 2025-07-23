import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take input for number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Step 2: Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();

            // Validate input
            while (mark < 0 || mark > 100) {
                System.out.print("Invalid input! Enter marks between 0 and 100: ");
                mark = scanner.nextInt();
            }

            marks[i] = mark;
            totalMarks += mark;
        }

        // Step 3: Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Step 4: Calculate grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Step 5: Display Results
        System.out.println("\n--- Student Result ---");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
