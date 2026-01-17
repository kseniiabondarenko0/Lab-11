import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the collection of visits and generates statistical reports.
 */
public class VisitManagement {
    private List<Visit> visits = new ArrayList<>();
    private int emptyLines = 0;
    private int totalLines = 0;

    /**
     * Add a visit to the collection.
     * @param visit The visit to add
     */
    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    /**
     * Increment the empty lines counter.
     */
    public void incrementEmptyLines() {
        emptyLines++;
    }

    /**
     * Increment the total lines counter.
     */
    public void incrementTotalLines() {
        totalLines++;
    }

    /**
     * Print a formatted report with statistics and individual records.
     */
    public void printReport() {
        System.out.println("=".repeat(80));
        System.out.println("PATIENT VISIT REPORT");
        System.out.println("=".repeat(80));

        // Calculate statistics
        LocalDate min = null, max = null;
        int medsCount = 0;

        for (Visit visit : visits) {
            LocalDate date = visit.getDate();
            if (date != null) {
                if (min == null || date.isBefore(min)) min = date;
                if (max == null || date.isAfter(max)) max = date;
            }

            if (visit.tookMedication()) {
                medsCount++;
            }
        }

        // Print statistics
        System.out.println("\nDataset Statistics:");
        System.out.println("  Total lines read: " + totalLines);
        System.out.println("  Valid records processed: " + visits.size());
        System.out.println("  Empty lines rejected: " + emptyLines);

        if (min != null && max != null) {
            System.out.println("  Date range: " + min + " to " + max);
        }
        System.out.println("  Patients who took drugs: " + medsCount);

        // Print individual records
        System.out.println("\n" + "-".repeat(80));
        System.out.println("INDIVIDUAL RECORDS:");
        System.out.println("-".repeat(80));

        for (int i = 0; i < visits.size(); i++) {
            Visit v = visits.get(i);
            System.out.println("\nRecord #" + (i + 1) + ":");
            System.out.println("  Visit Date: " + v.getDate());
            System.out.println("  Patient Age: " + v.getAge());
            System.out.println("  Phone: " + v.getPhone());
            System.out.println("  Email: " + v.getEmail());
            System.out.println("  Doctor: " + v.getDoctor());
            System.out.println("  Medications: " + v.getMedications());
        }
    }
}