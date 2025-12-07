import java.util.Scanner;
public class QuizGame {
    static Scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        loginMenu();

    }
    static void loginMenu(){
        while(true){

            System.out.println("======Login Menu======");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Login ");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");
            
            int choice = input.nextInt();

            switch(choice)
            case 1:
                adminSubjectSelection();
                break;
            
            case 2:
                studentSubjectSelection();
                break;

            case 3:
                System.out.println("Exiting...");    
                return;

            default:
                System.out.println("Invalid choice Try again");
           
                   }
    }}

static void adminSubjectSelection(){
    System.out.println("====Select Subjects===="){
        System.out.println("1. Islamiyat");
        System.out.println("2. Math");
        System.out.println("3. English");
        System.out.println("4. Science");
        System.out.println("5. Computer");
        System.out.println("6. Back");
        System.out.println("Choose subject: ");

        int sub = input.nextInt();

        if (sub == 6)
        return;

        System.out.println("Your selected subject" + sub);
        adminMenu();
    }
static void adminMenu() {
        while (true){

        System.out.println("===== ADMIN MENU =====");
        System.out.println("1. Add Questions");
        System.out.println("2. View Question List");
        System.out.println("3. Back to Login Menu");
        System.out.print("Enter choice: ");

        int choice = input.nextInt();

        switch (choice){

           case 1:
                    System.out.println("Add Questions feature coming soon!");
                    break;

            case 2:
                    System.out.println("Question list will show here soon!");
                    break;

            case 3:
                    return;

            default:
                    System.out.println("Invalid choice");
        }
        }
 static void studentSubjectSelection(){

        System.out.println("===== SELECT SUBJECT =====");
        System.out.println("1. Islamiyat");
        System.out.println("2. Math");
        System.out.println("3. English");
        System.out.println("4. Science");
        System.out.println("5. Computer");
        System.out.println("6. Back");
        System.out.print("Choose subject: ");

        int sub = input.nextInt();

        if (sub == 6)
            return;

        System.out.println("You selected subject " + sub);
        studentMenu();
 }
  static void studentMenu() {
        while (true) {

            System.out.println("===== STUDENT MENU =====");
            System.out.println("1. Play Quiz");
            System.out.println("2. View Scores");
            System.out.println("3. Back to Login Menu");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch(choice){

            case 1:
                    System.out.println("Quiz will start soon!");
                    break;

             case 2:
                    System.out.println("Score feature coming soon!");
                    break;

            case 3:
                    return;

            default:
                    System.out.println("Invalid choice");
            }
        }
    }

       


}
