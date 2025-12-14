import java.io.*;
import java.util.*;

public class Test1 {

    static Scanner input = new Scanner(System.in);

    static final String ISLAM_FILE = "islamiat.txt";
    static final String MATH_FILE = "math.txt";
    static final String ENGLISH_FILE = "english.txt";
    static final String SCIENCE_FILE = "science.txt";
    static final String COMPUTER_FILE = "computer.txt";
    static final String SCORE_FILE = "scores.txt";

    static String[][] islamiat = new String[30][6];
    static int islamCount = 0;

    static String[][] math = new String[30][6];
    static int mathCount = 0;

    static String[][] english = new String[30][6];
    static int englishCount = 0;

    static String[][] science = new String[30][6];
    static int scienceCount = 0;

    static String[][] computer = new String[30][6];
    static int computerCount = 0;

    static final String ADMIN_USER = "Aman";
    static final String ADMIN_PASS = "123";

    public static void main(String[] args) {

        loadSubject(ISLAM_FILE, islamiat, "Islamiyat");
        loadSubject(MATH_FILE, math, "Math");
        loadSubject(ENGLISH_FILE, english, "English");
        loadSubject(SCIENCE_FILE, science, "Science");
        loadSubject(COMPUTER_FILE, computer, "Computer");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            String ch = input.nextLine();

            switch (ch) {
                case "1":
                    adminLogin();
                    break;
                case "2":
                    studentLogin();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
  public static void adminLogin() {
        System.out.print("Enter Admin Username: ");
        String user = input.nextLine();

        System.out.print("Enter Admin Password: ");
        String pass = input.nextLine();

        if (user.equals(ADMIN_USER) && pass.equals(ADMIN_PASS)) {
            adminSubjectMenu();
        } else {
            System.out.println("Incorrect username or password!");
        }
    }

    public static void adminSubjectMenu() {
        while (true) {
            System.out.println("\n--- CHOOSE SUBJECT ---");
            System.out.println("1. Islamiyat");
            System.out.println("2. Math");
            System.out.println("3. English");
            System.out.println("4. Science");
            System.out.println("5. Computer");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");

            String ch = input.nextLine();

            switch (ch) {
                case "1":
                    adminPanel(islamiat, "Islamiyat", ISLAM_FILE);
                    break;
                case "2":
                    adminPanel(math, "Math", MATH_FILE);
                    break;
                case "3":
                    adminPanel(english, "English", ENGLISH_FILE);
                    break;
                case "4":
                    adminPanel(science, "Science", SCIENCE_FILE);
                    break;
                case "5":
                    adminPanel(computer, "Computer", COMPUTER_FILE);
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void adminPanel(String[][] arr, String subjectName, String fileName) {
        while (true) {
            System.out.println("\n--- ADMIN PANEL (" + subjectName + ") ---");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Update Question");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            String ch = input.nextLine();

            switch (ch) {
                case "1":
                    addQuestion(arr, subjectName, fileName);
                    break;
                case "2":
                    viewQuestions(arr, subjectName);
                    break;
                case "3":
                    updateQuestion(arr, subjectName, fileName);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
  public static void addQuestion(String[][] arr, String subject, String fileName) {
        int count = getCount(arr);
        if (count >= 30) {
            System.out.println("Maximum 30 questions allowed.");
            return;
        }

        System.out.print("Question: ");
        arr[count][0] = input.nextLine();
        System.out.print("Option A: ");
        arr[count][1] = input.nextLine();
        System.out.print("Option B: ");
        arr[count][2] = input.nextLine();
        System.out.print("Option C: ");
        arr[count][3] = input.nextLine();
        System.out.print("Option D: ");
        arr[count][4] = input.nextLine();
        System.out.print("Correct Answer (A/B/C/D): ");
        arr[count][5] = input.nextLine().toUpperCase();

        setCount(arr, count + 1);
        saveSubject(arr, fileName);
        System.out.println("Question added successfully!");
    }

    public static void viewQuestions(String[][] arr, String subject) {
        int count = getCount(arr);
        if (count == 0) {
            System.out.println("No questions available.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\nQ" + (i + 1) + ": " + arr[i][0]);
            System.out.println("A. " + arr[i][1]);
            System.out.println("B. " + arr[i][2]);
            System.out.println("C. " + arr[i][3]);
            System.out.println("D. " + arr[i][4]);
            System.out.println("Correct: " + arr[i][5]);
        }
    }
 public static void updateQuestion(String[][] arr, String subject, String fileName) {
        int count = getCount(arr);
        if (count == 0) {
            System.out.println("No questions to update.");
            return;
        }

        System.out.print("Enter question number: ");
        int q = Integer.parseInt(input.nextLine()) - 1;
        if (q < 0 || q >= count) {
            System.out.println("Invalid question number!");
            return;
        }

        System.out.print("New Question: ");
        arr[q][0] = input.nextLine();
        System.out.print("New Option A: ");
        arr[q][1] = input.nextLine();
        System.out.print("New Option B: ");
        arr[q][2] = input.nextLine();
        System.out.print("New Option C: ");
        arr[q][3] = input.nextLine();
        System.out.print("New Option D: ");
        arr[q][4] = input.nextLine();
        System.out.print("New Correct Answer: ");
        arr[q][5] = input.nextLine().toUpperCase();

        saveSubject(arr, fileName);
        System.out.println("Question updated!");
 }
    public static void studentLogin() {
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("\n1. Islamiyat\n2. Math\n3. English\n4. Science\n5. Computer");
        System.out.print("Choose subject: ");
        String ch = input.nextLine();

        switch (ch) {
            case "1":
                takeQuiz(name, islamiat, "Islamiyat");
                break;
            case "2":
                takeQuiz(name, math, "Math");
                break;
            case "3":
                takeQuiz(name, english, "English");
                break;
            case "4":
                takeQuiz(name, science, "Science");
                break;
            case "5":
                takeQuiz(name, computer, "Computer");
                break;
            default:
                System.out.println("Invalid subject!");
        }
    }
