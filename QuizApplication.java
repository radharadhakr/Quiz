import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int QUESTION_COUNT = 3;
    private static final int QUESTION_TIME_LIMIT = 10; // Time limit for each question in seconds
    private static int score = 0;
    private static int currentQuestion = 0;
    private static Scanner scanner = new Scanner(System.in);

    private static String[] questions = {
            "What is the capital of France?",
            "What is the largest mammal in the world?",
            "What is the chemical symbol for water?"
    };

    private static String[][] options = {
            {"A. Madrid", "B. Paris", "C. Rome", "D. London"},
            {"A. Elephant", "B. Blue Whale", "C. Giraffe", "D. Lion"},
            {"A. Wa", "B. H2O", "C. O2", "D. CO2"}
    };

    private static String[] answers = {"B", "B", "B"};

    public static void main(String[] args) {
        System.out.println("Welcome to the Quiz Application!");
        startQuiz();
    }

    private static void startQuiz() {
        if (currentQuestion < QUESTION_COUNT) {
            System.out.println("\nQuestion " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
            for (String option : options[currentQuestion]) {
                System.out.println(option);
            }
            startTimer();
            String userAnswer = scanner.nextLine().toUpperCase();
            checkAnswer(userAnswer);
        } else {
            endQuiz();
        }
    }

    private static void startTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                checkAnswer("");
            }
        }, QUESTION_TIME_LIMIT * 1000);
    }

    private static void checkAnswer(String userAnswer) {
        if (userAnswer.equals(answers[currentQuestion])) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
        currentQuestion++;
        startQuiz();
    }

    private static void endQuiz() {
        System.out.println("\nQuiz ended!");
        System.out.println("Your score: " + score + "/" + QUESTION_COUNT);
        scanner.close();
    }
}