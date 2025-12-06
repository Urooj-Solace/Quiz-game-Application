import java.util.*;
import java.io.*;

public class QuizApp {

    static Scanner input = new Scanner(System.in);

    // ---- SUBJECT FILES ----
    static final String ISLAM_FILE = "islamiyat.txt";
    static final String MATH_FILE = "math.txt";
    static final String ENGLISH_FILE = "english.txt";
    static final String SCIENCE_FILE = "science.txt";
    static final String COMPUTER_FILE = "computer.txt";
    static final String SCORE_FILE = "scores.txt";

    // ---- SUBJECT ARRAYS (30 questions each) ----
    static String[][] islamiyat = new String[30][6];
    static int islamCount = 0;

    static String[][] math = new String[30][6];
    static int mathCount = 0;

    static String[][] english = new String[30][6];
    static int englishCount = 0;

    static String[][] science = new String[30][6];
    static int scienceCount = 0;

    static String[][] computer = new String[30][6];
    static int computerCount = 0;

    // ---- ADMIN LOGIN ----
    static final String ADMIN_USER = "admin";
    static final String ADMIN_PASS = "123";

    public static void main(String[] args) {

        loadSubject(ISLAM_FILE, islamiyat, "Islamiyat");
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
                case "1": adminLogin(); break;
                case "2": studentLogin(); break;
                case "3": System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- ADMIN LOGIN ------------------
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

    // ---------------- ADMIN SUBJECT MENU ------------------
    public static void adminSubjectMenu() {
        while (true) {
            System.out.println("\n--- CHOOSE SUBJECT ---");
            System.out.println("1. Islamiyat");
            System.out.println("2. Math");
            System.out.println("3. English");
            System.out.println("4. Science");
            System.out.println("5. Computer");
            System.out.println("6. Logout");

            System.out.print("Enter choice: ");
            String ch = input.nextLine();

            switch (ch) {
                case "1": adminPanel(islamiyat, "Islamiyat", ISLAM_FILE); break;
                case "2": adminPanel(math, "Math", MATH_FILE); break;
                case "3": adminPanel(english, "English", ENGLISH_FILE); break;
                case "4": adminPanel(science, "Science", SCIENCE_FILE); break;
                case "5": adminPanel(computer, "Computer", COMPUTER_FILE); break;
                case "6": return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- ADMIN PANEL ------------------
    public static void adminPanel(String[][] subjectArray, String subjectName, String fileName) {

        while (true) {
            System.out.println("\n--- ADMIN PANEL (" + subjectName + ") ---");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Update Question");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            String ch = input.nextLine();

            switch (ch) {
                case "1": addQuestion(subjectArray, subjectName, fileName); break;
                case "2": viewQuestions(subjectArray, subjectName); break;
                case "3": updateQuestion(subjectArray, subjectName, fileName); break;
                case "4": return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------- ADD QUESTION ------------------
    public static void addQuestion(String[][] arr, String subjectName, String fileName) {

        int count = getCount(arr);

        if (count >= 30) {
            System.out.println("Maximum 30 questions allowed in " + subjectName + ".");
            return;
        }

        System.out.print("Enter Question: ");
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

    // ---------------- VIEW QUESTIONS ------------------
    public static void viewQuestions(String[][] arr, String subjectName) {
        int count = getCount(arr);

        if (count == 0) {
            System.out.println("No questions in " + subjectName + ".");
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

    // ---------------- UPDATE QUESTION ------------------
    public static void updateQuestion(String[][] arr, String subjectName, String fileName) {
        int count = getCount(arr);

        System.out.print("Enter question number to update: ");
        int qNo = Integer.parseInt(input.nextLine()) - 1;

        if (qNo < 0 || qNo >= count) {
            System.out.println("Invalid question number!");
            return;
        }

        System.out.print("New Question: ");
        arr[qNo][0] = input.nextLine();

        System.out.print("New Option A: ");
        arr[qNo][1] = input.nextLine();

        System.out.print("New Option B: ");
        arr[qNo][2] = input.nextLine();

        System.out.print("New Option C: ");
        arr[qNo][3] = input.nextLine();

        System.out.print("New Option D: ");
        arr[qNo][4] = input.nextLine();

        System.out.print("New Correct Answer (A/B/C/D): ");
        arr[qNo][5] = input.nextLine().toUpperCase();

        saveSubject(arr, fileName);

        System.out.println("Question updated successfully!");
    }

    // ---------------- STUDENT LOGIN ------------------
    public static void studentLogin() {

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.println("\nSelect Subject:");
        System.out.println("1. Islamiyat");
        System.out.println("2. Math");
        System.out.println("3. English");
        System.out.println("4. Science");
        System.out.println("5. Computer");
        System.out.print("Enter choice: ");
        String ch = input.nextLine();

        switch (ch) {
            case "1": takeQuiz(name, islamiyat, "Islamiyat"); break;
            case "2": takeQuiz(name, math, "Math"); break;
            case "3": takeQuiz(name, english, "English"); break;
            case "4": takeQuiz(name, science, "Science"); break;
            case "5": takeQuiz(name, computer, "Computer"); break;
            default: System.out.println("Invalid subject!");
        }
    }

    // ---------------- TAKE QUIZ (TIMER REMOVED) ------------------
    public static void takeQuiz(String studentName, String[][] arr, String subjectName) {

        int count = getCount(arr);

        if (count == 0) {
            System.out.println("No questions available in " + subjectName + ".");
            return;
        }

        int score = 0;

        System.out.println("\nStarting Quiz (" + subjectName + ") for " + studentName + ".");

        for (int i = 0; i < count; i++) {

            System.out.println("\nQ" + (i + 1) + ": " + arr[i][0]);
            System.out.println("A. " + arr[i][1]);
            System.out.println("B. " + arr[i][2]);
            System.out.println("C. " + arr[i][3]);
            System.out.println("D. " + arr[i][4]);
            System.out.print("Your answer: ");

            String ans = input.nextLine().toUpperCase();

            if (ans.equals(arr[i][5])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! Correct answer: " + arr[i][5]);
            }
        }

        System.out.println("\nQuiz Finished! Your score: " + score + "/" + count);
        saveScore(studentName, subjectName, score);
    }

    // ---------------- SAVE SCORE ------------------
    public static void saveScore(String name, String subject, int score) {
        try {
            FileWriter fw = new FileWriter(SCORE_FILE, true);
            fw.write(name + " (" + subject + ") scored " + score + " points.\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving score!");
        }
    }

    // ---------------- LOAD SUBJECT ------------------
    public static void loadSubject(String fileName, String[][] arr, String subjectName) {
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            int index = 0;

            while (sc.hasNextLine() && index < 30) {
                String line = sc.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    arr[index] = parts;
                    index++;
                }
            }

            setCount(arr, index);
            sc.close();

        } catch (Exception e) {
            System.out.println("No file found for " + subjectName + ". Creating empty bank.");
        }
    }

    // ---------------- SAVE SUBJECT ------------------
    public static void saveSubject(String[][] arr, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            int count = getCount(arr);

            for (int i = 0; i < count; i++) {
                fw.write(arr[i][0] + ";" + arr[i][1] + ";" + arr[i][2] + ";" +
                         arr[i][3] + ";" + arr[i][4] + ";" + arr[i][5] + "\n");
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Error saving file: " + fileName);
        }
    }

    // ----------- UTILITY: GET COUNT ------------
    public static int getCount(String[][] arr) {
        if (arr == islamiyat) return islamCount;
        if (arr == math) return mathCount;
        if (arr == english) return englishCount;
        if (arr == science) return scienceCount;
        return computerCount;
    }

    // ----------- UTILITY: SET COUNT ------------
    public static void setCount(String[][] arr, int newCount) {
        if (arr == islamiyat) islamCount = newCount;
        else if (arr == math) mathCount = newCount;
        else if (arr == english) englishCount = newCount;
        else if (arr == science) scienceCount = newCount;
        else computerCount = newCount;
    }

}