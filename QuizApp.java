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
  
