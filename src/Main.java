import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
            FinanceManager financeManager=new FinanceManager();
            Scanner scanner=new Scanner(System.in);
            while (true){
                System.out.println("1 Add_Income");
                System.out.println("2 Add_Expense");
                System.out.println("3 View_History");
                System.out.println("4 View_Balance");
                System.out.println("5 Delete_Transaction");
                System.out.println("6 Exit");

                int string= scanner.nextInt();
                scanner.nextLine();

                switch (string){
                    case 1:
                        System.out.println("Name of added Income");
                        String s=scanner.nextLine();
                        System.out.println("Amount");
                        String s1=scanner.nextLine();
                        System.out.println("1 Dauerauftrag");
                        System.out.println("2 Einmalig");

                        int dour_einmal=scanner.nextInt();
                        if (dour_einmal==1){financeManager.newTransaction(s,Double.parseDouble(s1),true,true);} else financeManager.newTransaction(s,Double.parseDouble(s1),true,false);
                        break;
                    case 2:
                        System.out.println("Name of added Expense");
                        String s2=scanner.nextLine();
                        System.out.println("Amount");
                        String s3=scanner.nextLine();
                        System.out.println("1 Dauerauftrag");
                        System.out.println("2 Einmalig");
                        int dou=scanner.nextInt();
                        if (dou==1) {
                            financeManager.newTransaction(s2,Double.parseDouble(s3),false,true);
                        }else financeManager.newTransaction(s2,Double.parseDouble(s3),false,false);
                        break;
                    case 3:
                        financeManager.printHistory();
                        break;
                    case 4:
                        System.out.println(financeManager.getBalance()+"€");
                        break;
                    case 5:
                        System.out.println("Select the Transaction Number to be deleted");
                        financeManager.delete(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 6:
                        System.out.println("Great");
                        scanner.close();
                        return;
                }

            }
    }
}