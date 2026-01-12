import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilesManager{
    String filename="FinaceData"+YearMonth.now()+".csv";
    FileWriter fileWriter=null;
    FilesManager(){
        try{
            if (!Files.exists(Paths.get(filename))){
                fileWriter=new FileWriter(filename);
                if (Files.exists(Paths.get("FinaceData"+YearMonth.from(LocalDate.now()).minusMonths(1)+".csv"))){
                    List<Transaction> list=allTransactions("FinaceData"+YearMonth.from(LocalDate.now()).minusMonths(1)+".csv");
                    for (Transaction transaction:list){
                        if (transaction.isDauerauftrag()){toFile(transaction);}
                    }
                }
            }else fileWriter=new FileWriter(filename,true);
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }
    public void toFile(List<Transaction> list){
        try {
            fileWriter=new FileWriter(filename,false);
            for (int i=0;i< list.size();i++){
                fileWriter.write(list.get(i).toCSV());
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
            System.out.println("List saved");
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }
    public void toFile(Transaction list){
        try {
                FileWriter tem=new FileWriter(filename,true);
                tem.write(list.toCSV());
                tem.write(System.lineSeparator());
                tem.close();
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }


    public List<Transaction> allTransactions() throws IOException {
        List<Transaction> all=new ArrayList<>();
        try {
            Scanner scanner=new Scanner(Paths.get(filename));
            scanner.useDelimiter("[,\\s]+");
            while (scanner.hasNext()){
                all.add(new Transaction(scanner.next(),Double.parseDouble(scanner.next()),scanner.next().equals("Income"),scanner.next().equals("Dauerauftrag")));
                scanner.nextLine();
            }
        } catch (IOException e){
            System.out.println("Error IOException");
        }
        return all;
    }

    public List<Transaction> allTransactions(String filepath) throws IOException {
        List<Transaction> all=new ArrayList<>();
        Scanner scanner=new Scanner(Paths.get(filepath));

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if(line.isEmpty()) continue;

            String[] parts = line.split(",");
            if(parts.length >= 5) {
                all.add(new Transaction(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        parts[2].equalsIgnoreCase("Income"),
                        parts[4].equalsIgnoreCase("Dauerauftrag")
                ));
            }
        }

        return all;
    }

}
