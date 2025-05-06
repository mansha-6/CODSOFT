import java.util.Scanner;

public class task4 {
    static class Question {
        String question;
        String[] options;
        int correctOption; // index starting from 1

        Question(String question, String[] options, int correctOption) {
            this.question = question;
            this.options = options;
            this.correctOption = correctOption;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] questions = new Question[] {
            new Question("What is the capital of France?",
                    new String[] {"1) Berlin", "2) London", "3) Paris", "4) Madrid"},
                    3),
            new Question("Which planet is known as the Red Planet?",
                    new String[] {"1) Earth", "2) Mars", "3) Jupiter", "4) Venus"},
                    2),
            new Question("Who wrote 'Romeo and Juliet'?",
                    new String[] {"1) Charles Dickens", "2) William Shakespeare", "3) Mark Twain", "4) Jane Austen"},
                    2),
            new Question("What is the largest ocean on Earth?",
                    new String[] {"1) Atlantic Ocean", "2) Indian Ocean", "3) Arctic Ocean", "4) Pacific Ocean"},
                    4),
            new Question("Which element has the chemical symbol 'O'?",
                    new String[] {"1) Gold", "2) Oxygen", "3) Silver", "4) Iron"},
                    2)
        };

        int score = 0;
        int timeLimitSeconds = 15; // seconds per question

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("You have " + timeLimitSeconds + " seconds to answer each question.");
        System.out.println("Choose the correct option number and press Enter.\n");

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];
            System.out.println("Question " + (i + 1) + ": " + q.question);
            for (String option : q.options) {
                System.out.println(option);
            }

            long startTime = System.currentTimeMillis();
            int answer = -1;

            // Read answer with time limit
            while ((System.currentTimeMillis() - startTime) / 1000 < timeLimitSeconds) {
                System.out.print("Your answer (1-4): ");
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                    if (answer >= 1 && answer <= 4) {
                        break;
                    } else {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                }
            }

            // Check if time expired before valid input
            if (answer == -1) {
                System.out.println("\nTime's up! Moving to next question.\n");
            } else if (answer == q.correctOption) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was option " + q.correctOption + ".\n");
            }
        }

        // Result summary
        System.out.println("Quiz Over!");
        System.out.println("Your final score: " + score + " out of " + questions.length);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
