import java.util.ArrayList;
import java.util.List;
/**
 * Responsible for structuring the data
 */

public class VisitManagment {



    private List<Visit> visits = new ArrayList<>();
    private int emptyLines = 0;
    private int totalLines = 0;

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public void incrementEmptyLines() {
        emptyLines++;
    }

    public void incrementTotalLines() {
        totalLines++;
    }


    public void printReport(){
        //just for formating
        System.out.println("=".repeat(80));
        System.out.println("PATIENT VISIT REPORT");
        System.out.println("=".repeat(80));

        //print stats
        System.out.println("\nDataset Statistics:");
        System.out.println(" Total lines read: " + totalLines);
        System.out.println(" Valid records processed: " + visits.size());
        System.out.println(" Empty lines rejected: " + emptyLines);
    }
}
