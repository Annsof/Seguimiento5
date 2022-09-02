import java.util.Scanner;
public class Main {
    private final Scanner sc;
    private ABB obj;

    public Main() {
        obj = new ABB();
        sc = new Scanner(System.in);
    }

    public static void main(String[] arg) {
        System.out.println("***************************\n" +
                "DANE Register\n" +
                "***************************\n");
        Main ppl = new Main();
        int option = 0;
        do {
            option = ppl.showMenu();
            ppl.runMenu(option);
        } while (option != 0);
    }

    public int showMenu() {
        System.out.println("Choose one of the following options\n" +
                "(0)Exit\n"+
                "(1)Enroll a citizen\n"+
                "(2)Consult by ID\n"+
                "(3)Delete citizen by ID\n");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void runMenu(int option) {
        switch (option) {
            case 1 :
                System.out.println("Enrolling citizen\n" +
                        "Enter the citizen's ID");
                String id=sc.nextLine();
                System.out.println("Enter the full name of the citizen");
                String fullName=sc.nextLine();
                System.out.println("Enter the date of birth of the citizen");
                String birthDate=sc.nextLine();
                System.out.println("Enter the city of birth of the citizen");
                String birthCity=sc.nextLine();
                obj.insert(id,fullName,birthDate,birthCity);
                break;
            case 2:
                System.out.println("Looking for a citizen by ID:\n" +
                        "Enter the ID of the citizen you are looking for");
                String idd=sc.nextLine();
                obj.search(idd);
                break;
            case 3:
                System.out.println("Deleting a citizen by ID:\n" +
                        "Enter the ID of the citizen you are deleting");
                String iddd=sc.nextLine();
                obj.delete(iddd);
                break;
            case 0:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Choose a valid option");
                break;
        }
    }
}