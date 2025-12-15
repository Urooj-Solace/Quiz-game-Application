import java.util.*;
import java.io.*;

public class QuizApp1 {

    static Scanner input = new Scanner(System.in);

    // Question banks
    static String[][] islamiat = new String[30][6];
    static String[][] math = new String[30][6];
    static String[][] english = new String[30][6];
    static String[][] science = new String[30][6];
    static String[][] computer = new String[30][6];

    // Counters
    static int islamCount = 0, mathCount = 0, englishCount = 0, scienceCount = 0, computerCount = 0;

    // Files
    static final String ISLAM_FILE = "islamiat.txt";
    static final String MATH_FILE = "math.txt";
    static final String ENGLISH_FILE = "english.txt";
    static final String SCIENCE_FILE = "science.txt";
    static final String COMPUTER_FILE = "computer.txt";
    static final String SCORE_FILE = "scores.txt";

    static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {

        loadSubject(ISLAM_FILE, islamiat, "Islamiyat");
        loadSubject(MATH_FILE, math, "Math");
        loadSubject(ENGLISH_FILE, english, "English");
        loadSubject(SCIENCE_FILE, science, "Science");
        loadSubject(COMPUTER_FILE, computer, "Computer");

        while (true) {
            try {
                System.out.println("\n===== QUIZ SYSTEM =====");
                System.out.println("1. Admin Panel");
                System.out.println("2. Student Panel");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");

                String choice = input.nextLine().trim();

                if (choice.equals("1")) {
                    if (adminLogin())
                        adminMenu();
                } else if (choice.equals("2")) {
                    studentLogin();
                } else if (choice.equals("3")) {
                    System.out.println("Program exited successfully.");
                    break;
                } else {
                    System.out.println(" Invalid choice. Please enter 1, 2 or 3.");
                }

            } catch (Exception e) {
                System.out.println(" Unexpected error in main menu.");
            }
        }
    }

    static boolean adminLogin() {
        for (int i = 3; i > 0; i--) {
            System.out.print("Enter admin password: ");
            String pass = input.nextLine();

            if (pass.equals(ADMIN_PASSWORD)) {
                System.out.println("✅ Access granted.");
                return true;
            } else {
                System.out.println(" Wrong password. Attempts left: " + (i - 1));
            }
        }
        return false;
    }

    static void adminMenu() {
        while (true) {
            try {
                System.out.println("\n--- ADMIN MENU ---");
                System.out.println("1. Add Question");
                System.out.println("2. View Questions");
                System.out.println("3. Update Question");
                System.out.println("4. Show All Scores");
                System.out.println("5. Back");
                System.out.print("Choose option: ");

                String ch = input.nextLine().trim();

                if (ch.equals("1"))
                    adminAdd();
                else if (ch.equals("2"))
                    adminView();
                else if (ch.equals("3"))
                    adminUpdate();
                else if (ch.equals("4"))
                    showScores();
                else if (ch.equals("5"))
                    break;
                else
                    System.out.println(" Invalid admin option.");

            } catch (Exception e) {
                System.out.println("⚠ Admin menu error.");
            }
        }
    }

    static void studentLogin() {
        try {
            System.out.print("Enter your name: ");
            String name = input.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println(" Name cannot be empty.");
                return;
            }

            System.out.println("\n1. Islamiyat\n2. Math\n3. English\n4. Science\n5. Computer");
            System.out.print("Choose subject: ");
            String ch = input.nextLine().trim();

            if (ch.equals("1"))
                takeQuiz(name, islamiat, "Islamiyat");
            else if (ch.equals("2"))
                takeQuiz(name, math, "Math");
            else if (ch.equals("3"))
                takeQuiz(name, english, "English");
            else if (ch.equals("4"))
                takeQuiz(name, science, "Science");
            else if (ch.equals("5"))
                takeQuiz(name, computer, "Computer");
            else
                System.out.println("Invalid subject selection.");

        } catch (Exception e) {
            System.out.println("⚠ Student login error.");
        }
    }

    static void takeQuiz(String name, String[][] arr, String subject) {
        int count = getCount(arr);
        if (count == 0) {
            System.out.println(" No questions available.");
            return;
        }

        int score = 0;

        for (int i = 0; i < count; i++) {
            try {
                System.out.println("\n" + arr[i][0]);
                System.out.println("A. " + arr[i][1]);
                System.out.println("B. " + arr[i][2]);
                System.out.println("C. " + arr[i][3]);
                System.out.println("D. " + arr[i][4]);
                System.out.print("Your answer (A/B/C/D): ");

                String ans = input.nextLine().trim().toUpperCase();

                if (!ans.matches("[ABCD]")) {
                    System.out.println(" Invalid answer. Skipped.");
                    continue;
                }

                if (ans.equals(arr[i][5]))
                    score++;

            } catch (Exception e) {
                System.out.println(" Error while answering question.");
            }
        }

        System.out.println("✅ Score: " + score + "/" + count);
        saveScore(name, subject, score);
    }

    static void adminAdd() {
        selectSubject("add");
    }

    static void adminView() {
        selectSubject("view");
    }

    static void adminUpdate() {
        selectSubject("update");
    }

    static void selectSubject(String action) {
        System.out.println("\n1. Islamiyat\n2. Math\n3. English\n4. Science\n5. Computer");
        System.out.print("Choose subject: ");
        String ch = input.nextLine().trim();

        if (!ch.matches("[1-5]")) {
            System.out.println("Invalid subject choice.");
            return;
        }

        if (action.equals("add")) {
            if (ch.equals("1"))
                addQuestion(islamiat, ISLAM_FILE);
            else if (ch.equals("2"))
                addQuestion(math, MATH_FILE);
            else if (ch.equals("3"))
                addQuestion(english, ENGLISH_FILE);
            else if (ch.equals("4"))
                addQuestion(science, SCIENCE_FILE);
            else
                addQuestion(computer, COMPUTER_FILE);
        } else if (action.equals("view")) {
            if (ch.equals("1"))
                viewQuestions(islamiat);
            else if (ch.equals("2"))
                viewQuestions(math);
            else if (ch.equals("3"))
                viewQuestions(english);
            else if (ch.equals("4"))
                viewQuestions(science);
            else
                viewQuestions(computer);
        } else if (action.equals("update")) {
            if (ch.equals("1"))
                updateQuestion(islamiat, ISLAM_FILE);
            else if (ch.equals("2"))
                updateQuestion(math, MATH_FILE);
            else if (ch.equals("3"))
                updateQuestion(english, ENGLISH_FILE);
            else if (ch.equals("4"))
                updateQuestion(science, SCIENCE_FILE);
            else
                updateQuestion(computer, COMPUTER_FILE);
        }
    }

    static void addQuestion(String[][] arr, String file) {
        try {
            int count = getCount(arr);
            if (count >= 30) {
                System.out.println("Question limit reached.");
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
            String ans = input.nextLine().toUpperCase();

            if (!ans.matches("[ABCD]")) {
                System.out.println("Invalid correct answer.");
                return;
            }

            arr[count][5] = ans;
            setCount(arr, count + 1);
            saveSubject(arr, file);

        } catch (Exception e) {
            System.out.println("⚠ Error adding question.");
        }
    }

    static void updateQuestion(String[][] arr, String file) {
        try {
            int count = getCount(arr);
            if (count == 0)
                return;

            System.out.print("Enter question number: ");
            int q = Integer.parseInt(input.nextLine()) - 1;

            if (q < 0 || q >= count) {
                System.out.println(" Invalid question number.");
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
            String ans = input.nextLine().toUpperCase();

            if (!ans.matches("[ABCD]")) {
                System.out.println(" Invalid correct answer.");
                return;
            }

            arr[q][5] = ans;
            saveSubject(arr, file);

        } catch (NumberFormatException e) {
            System.out.println(" Please enter a valid number.");
        } catch (Exception e) {
            System.out.println(" Update error.");
        }
    }

    static void viewQuestions(String[][] arr) {
        int count = getCount(arr);
        if (count == 0)
            return;

        for (int i = 0; i < count; i++) {
            System.out.println("\nQ" + (i + 1) + ": " + arr[i][0]);
            System.out.println("A. " + arr[i][1]);
            System.out.println("B. " + arr[i][2]);
            System.out.println("C. " + arr[i][3]);
            System.out.println("D. " + arr[i][4]);
            System.out.println("Correct: " + arr[i][5]);
        }
    }

    static void saveSubject(String[][] arr, String file) {
        try (FileWriter fw = new FileWriter(file)) {
            for (int i = 0; i < getCount(arr); i++)
                fw.write(String.join(";", arr[i]) + "\n");
        } catch (Exception e) {
        }
    }

    static void loadSubject(String file, String[][] arr, String subject) {
        try (Scanner sc = new Scanner(new File(file))) {
            int i = 0;
            while (sc.hasNextLine() && i < 30)
                arr[i++] = sc.nextLine().split(";");
            setCount(arr, i);
        } catch (Exception e) {
        }
    }

    static void saveScore(String name, String subject, int score) {
        try (FileWriter fw = new FileWriter(SCORE_FILE, true)) {
            fw.write(name + " (" + subject + ") scored " + score + "\n");
        } catch (Exception e) {
        }
    }

    static void showScores() {
        try (Scanner sc = new Scanner(new File(SCORE_FILE))) {
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        } catch (Exception e) {
            System.out.println("No scores found.");
        }
    }

    static int getCount(String[][] arr) {
        if (arr == islamiat)
            return islamCount;
        if (arr == math)
            return mathCount;
        if (arr == english)
            return englishCount;
        if (arr == science)
            return scienceCount;
        return computerCount;
    }

    static void setCount(String[][] arr, int val) {
        if (arr == islamiat)
            islamCount = val;
        else if (arr == math)
            mathCount = val;
        else if (arr == english)
            englishCount = val;
        else if (arr == science)
            scienceCount = val;
        else
            computerCount = val;
    }
}
