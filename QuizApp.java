import java.util.Scanner;
import java.io.*;

public class QuizGame {
    static Scanner input = new Scanner(System.in);
    static final String ISLAM_FILE = "islamiat.txt";
    static final String MATH_FILE = "math.txt";
    static final String ENGLISH_FILE = "english.txt";
    static final String SCIENCE_FILE = "science.txt";
    static final String COMPUTER_FILE = "computer.txt";
    static final String SCORE_FILE = "scores.txt";

    static final String ADMIN1_USER = "Urooj";
    static final String ADMIN1_PASS = "1234";
    static final String ADMIN2_USER = "Aman";
    static final String ADMIN2_PASS = "1234";

    static String[][] islamiat = new String[30][6];
    static int islamcount = 0;
    static String[][] math = new String[30][6];
    static int mathcount = 0;
    static String[][] english = new String[30][6];
    static int englishcount = 0;
    static String[][] science = new String[30][6];
    static int sciencecount = 0;
    static String[][] computer = new String[30][6];
    static int computercount = 0;

    public static void main(String[]args){

        loadSubject(ISLAM_FILE, islamiat , "Islamiat");
        loadSubject(MATH_FILE, math , "Math");
        loadSubject(ENGLISH_FILE, english , "English");
        loadSubject(SCIENCE_FILE, science , "Science");
        loadSubject(COMPUTER_FILE, computer , "Computer");

        while(true){
            System.out.println(\n "Main Menu");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.println("Enter choice");
            String ch = input.nextLine();
        switch (ch){
            case "1":
                adminLogin();
            case "2":
                studentLogin();
            case "3";
                System.out.println("googbye");
                return;
            default:
                System.out.println("invalid choice");
            }
        }
    }

public static void adminLogin(){
    System.out.println("Enter Admin Username");
    String user = input.nextLine();
    System.out.println("Enter Admin Pass");
    String pass = input.nextLine();
    if (user == ADMIN1_USER)&& (pass == ADMIN1_PASS)&& (user == ADMIN2_USER)&&(pass == ADMIN2_PASS){
        adminSubjectMenu();
    }else{
        System.out.println("Incorrect Username or Password");
    }
}

public static void adminSubjectMenu(){
System.out.println(\n "Main Menu");
System.out.println(1. Islamiat);
System.out.println(2. Math);
System.out.println(3. English);
System.out.println(4. Science);
System.out.println(5. Computer);
System.out.println("Enter choice: ");
String ch = input.nextLine();
switch (ch){
case "1":
    adminPanel(islamiat , "Islamiat" , ISLAM_FILE);
break;
case "2":
    adminPanel(math , "Math" , MATH_FILE);
break;
case "3":
    adminPanel(english , "English", ENGLISH_FILE);
break;
case "4":
    adminPanel(science, "Science", SCIENCE_FILE);
break;
case "5":
    admnPanel(computer , "Computer", COMPUTER_FILE);
break;
case "6":
    return;
default:
    System.out.println("Invalid choice!");
  }
 }
}
public static void adminPanel(String[][] subjectArray, String subjectName, String fileName) {

        while (true) {
            System.out.println("\n ADMIN PANEL (" + subjectName + ") ");
            System.out.println("1. Add Question");
            System.out.println("2. View Questions");
            System.out.println("3. Update Question");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            String ch = input.nextLine();

            switch (ch) {
                case "1":
                     addQuestion(subjectArray, subjectName, fileName);
                      break;
                case "2":
                     viewQuestions(subjectArray, subjectName);
                      break;
                case "3":
                     updateQuestion(subjectArray, subjectName, fileName);
                      break;
                case "4":
                     return;
                default:
                     System.out.println("Invalid choice!");
            }
        }
    }
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

