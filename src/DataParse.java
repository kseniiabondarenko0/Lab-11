import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataParse {
    private List<DataParse> records;
    private int emptyLines;

    /**
     * Constructor initialising the record list and empty line counter.
     */
    public DataParse(String trim, String trimmed) {
        this.records = new ArrayList<>();
        this.emptyLines = 0;
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
                DataParse record = new DataParse(parts[0].trim(), parts[1].trim());
                records.add(record);
            }

        }
        reader.close();
    }
}
