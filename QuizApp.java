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

  
