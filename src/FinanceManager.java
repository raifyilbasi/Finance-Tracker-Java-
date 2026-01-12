import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private final FilesManager filesManager;
    private List<Transaction> transactionList;
    FinanceManager() throws IOException {
        filesManager=new FilesManager();
        transactionList=filesManager.allTransactions();
    }
    public void newTransaction(String name, double wert, boolean einnahme_ausgabe, boolean dauer){
        transactionList.add(new Transaction(name,wert,einnahme_ausgabe,dauer));
        filesManager.toFile(transactionList.getLast());
    }

    public double getBalance(){
        double totale=0;
        for (int i=0;i<transactionList.size();i++){
            if (transactionList.get(i).isRein_raus()){
                totale+=transactionList.get(i).getBetrag();
            } else totale-=transactionList.get(i).getBetrag();
        }
        return totale;
    }

    /**
     * add deleat und list of all transaktions
     */
    public void printHistory(){
        int counter=0;
        for (Transaction transactions:transactionList){
            System.out.println(counter+". "+transactions.info());
            counter++;
        }
    }

    public void delete(int a){
        if (a >= 0 && a < transactionList.size()) {
            transactionList.remove(a);
            filesManager.toFile(transactionList);
            System.out.println("Deleted transaction " + a);
        } else {
            System.out.println("Invalid index");
        }
    }
}
