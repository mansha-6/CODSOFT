import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       STUDENT GRADE CALCULATOR       ");
        System.out.println("======================================");

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Array to store marks for each subject
        int[] marks = new int[numberOfSubjects];

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            int mark;
            while (true) {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (0 - 100): ");
                mark = scanner.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println("Invalid input! Marks should be between 0 and 100. Please try again.");
                }
            }
        }
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        String grade = calculateGrade(averagePercentage);

        System.out.println("\n---------- RESULT ----------");
        System.out.println("Total Marks Obtained: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------");

        scanner.close();
    }
    private static String calculateGrade(double average) {
        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
