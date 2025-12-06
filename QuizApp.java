import java.util.Scanner;

public class QuizApp { #testmatch01
                    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Admin Login selected...");
                    // call adminLogin();
                    break;

                case 2:
                    System.out.println("Student Login selected...");
                    // call studentLogin();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
