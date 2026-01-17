import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

 public class DataParse {
    private List<DataParse> records;
    private int emptyLines;

    private int totalLinesRead;

    /**
     * Constructor initialising the record list and empty line counter.
     */
 /*   public DataParse(String trim, String trimmed) {
        this.records = new ArrayList<>();
        this.emptyLines = 0;
        this.totalLinesRead = 0;
    }


    /**
     * @param filename the CSV file
     * @throws IOException if the file can't be read
     */
    public void readFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Introduction to Programming 2025 Data.csv"));

        String line;
        boolean isFirstline = true;

        while ((line = reader.readLine()) != null) {
            // Skip header line
            if (isFirstline) {
                isFirstline = false;
                continue;
            }

            // Check for empty lines
            if (line.trim().isEmpty()) {
                emptyLines++;
                System.out.println("Warning: Empty line detected and rejected");
                continue;
            }
            // Parse the line (expecting CSV format: date,description)
            String[] parts = line.split(",", 2);
            if (parts.length == 2) {
                DataParse record = new DataParse();
                records.add(record);
            }

        }
        reader.close();
        System.out.println("File reading complete. " + records.size() + " valid records loaded.\n");
    }


    /**
     * Generates nicely printed (formated) report of parsed records
     *
     */
    public void generateReport(){
        System.out.println("=".repeat(80));
        System.out.println("PATIENT VISIT RECORDS ANALYSIS REPORT");
        System.out.println("=".repeat(80));

        printStats();

    }

    private void printStats(){
        System.out.println("\nDataset Statistics:");
        System.out.println("  Total lines read: " + totalLinesRead);
        System.out.println("  Valid records processed: " + records.size());
        System.out.println("  Empty lines rejected: " + emptyLines);



        //Date range

        LocalDate minDate = null, maxDate = null;
        int patientsMedications = 0;
        int recordsWithAge = 0;
        int recordsWithPhone = 0;
        int recordsWithEmail = 0;
        int recordsWithDoctor = 0;


        for (DataParse records : records){

        }
    }


}
