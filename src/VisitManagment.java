import java.time.LocalDate;
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


    public void printReport() {
        //just for formating
        System.out.println("=".repeat(80));
        System.out.println("PATIENT VISIT REPORT");
        System.out.println("=".repeat(80));

        for (Visit visit : visits) {
            LocalDate date = visit.getDate();
            if (date != null) {
                if (min == null || date.isBefore(min)) min = date;
                if (max == null || date.isAfter(max)) max = date;
            }
            // Logic based on lab rule 6: how many patients took drugs
            if (visit.tookMedication()) {
                medsCount++;
            }
        }

        //print stats
        System.out.println("\nDataset Statistics:");
        System.out.println(" Total lines read: " + totalLines);
        System.out.println(" Valid records processed: " + visits.size());
        System.out.println(" Empty lines rejected: " + emptyLines);
    }

    LocalDate min = null, max = null;
    int medsCount = 0;

}



