import java.time.LocalDate;

public class Transaction {
    /**
     *
     * @param wert
     * @param name
     * @param einnahme_ausgabe true rein false raus
     */
    Transaction(String name, double wert, boolean einnahme_ausgabe,boolean dauerauftrag){
        betrag=wert;
        category=name;
        rein_raus=einnahme_ausgabe;
        datum= String.valueOf(LocalDate.now());
        this.dauerauftrag=dauerauftrag;
    }

    private boolean dauerauftrag;
    private double betrag;
    private String category;
    private boolean rein_raus;
    private String datum;

    public double getBetrag() {
        return betrag;
    }

    public String getCategory() {
        return category;
    }

    public boolean isRein_raus() {
        return rein_raus;
    }

    public String getDatum() {
        return datum;
    }

    public String info(){
        return rein_raus?category+": "+betrag+"€ | "+datum+" | "+(dauerauftrag?",Dauerauftrag":",Einmahlig"):category+": -"+betrag+"€ | "+datum+" | "+(dauerauftrag?",Dauerauftrag":",Einmahlig");
    }

    public String toCSV(){
        return rein_raus?category+","+betrag+",Income,"+datum+(dauerauftrag?",Dauerauftrag":",Einmahlig"):category+","+betrag+",Expense,"+datum+(dauerauftrag?",Dauerauftrag":",Einmahlig");
    }

    public boolean isDauerauftrag() {
        return dauerauftrag;
    }

}
