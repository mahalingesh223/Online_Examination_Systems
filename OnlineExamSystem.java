import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

class Question {
    String questionText;
    List<String> options;
    int correctOption;

    Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

class Quiz {
    List<Question> questions;
    int score;

    Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Q" + (i + 1) + ". " + question.questionText);
            for (int j = 0; j < question.options.size(); j++) {
                System.out.println((char) ('A' + j) + ". " + question.options.get(j));
            }
            System.out.print("Your choice: ");
            char userChoice = scanner.next().charAt(0);
            int userOption = userChoice - 'A';
            if (userOption == question.correctOption) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. Correct option: " + (char) ('A' + question.correctOption) + "\n");
            }
        }
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}
public class OnlineExamSystem {
	 static Map<String, User> users = new HashMap<>();
	    static List<Quiz> quizzes = new ArrayList<>();

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // User Registration
	        System.out.println("User Registration");
	        System.out.print("Enter username: ");
	        String username = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();
	        User newUser = new User(username, password);
	        users.put(username, newUser);

	        // Quiz Creation
	        List<Question> questions = new ArrayList<>();
	        questions.add(new Question("Which animal is known as the ship of the Desert?", List.of("Camel", "Dog", "Frog", "Horse"), 0));
	        questions.add(new Question("Name the National bird of India?", List.of("Dove", "Peacock", "Parrot", "Sparrow"), 1));
	        questions.add(new Question("Name the National animal of India?", List.of("Elephant", "Tiger", "Giraffe", "Hippopotamus"), 1));
	        Quiz newQuiz = new Quiz(questions);
	        quizzes.add(newQuiz);

	        // User Login
	        System.out.println("\nUser Login");
	        System.out.print("Enter username: ");
	        String loginUsername = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String loginPassword = scanner.nextLine();

	        // Validate user credentials
	        User loginUser = users.get(loginUsername);
	        if (loginUser != null && loginUser.password.equals(loginPassword)) {
	            System.out.println("\nWelcome, " + loginUsername + "!");
	            System.out.println("Start Quiz");
	            newQuiz.takeQuiz();
	        } else {
	            System.out.println("Invalid username or password.");
	        }
	    }


	}


