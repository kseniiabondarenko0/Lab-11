import java.io.*;
import java.util.regex.*;
import java.time.LocalDate;

/**
 * Handles the reading of the input CSV and applies Regex patterns
 * to identify specific patient information.
 */
public class VisitParser {
    private VisitManagement management = new VisitManagement();

    /**
     * Reads the file line by line and applies data quality checks.
     * @param fileName Path to the CSV data file.
     * @throws IOException if file cannot be read
     */
    public void parse(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        boolean firstLine = true;

        while ((line = br.readLine()) != null) {
            management.incrementTotalLines();

            // Skip header
            if (firstLine) {
                firstLine = false;
                continue;
            }

            // Identify and reject empty lines
            if (line.trim().isEmpty()) {
                System.out.println("Quality Alert: Empty line ignored.");
                management.incrementEmptyLines();
                continue;
            }

            // Split CSV (date,description)
            String[] parts = line.split(",", 2);
            if (parts.length < 2) continue;

            // Parse date
            String dateStr = parts[0].replace("\"", "").trim();
            LocalDate date = null;
            try {
                date = LocalDate.parse(dateStr);
            } catch (Exception e) {
                System.out.println("Invalid date format: " + dateStr);
                continue;
            }

            String desc = parts[1];
            Visit visit = new Visit(date);

            // Apply regex patterns to extract information
            visit.setAge(match(desc, "(?:patient is|age:?)\\s*(\\d+)\\s*years?\\s*old", "not found"));
            visit.setPhone(match(desc, "\\b(\\d{3}[-.]?\\d{3}[-.]?\\d{4})\\b", "not found"));
            visit.setEmail(match(desc, "([\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,})", "not found"));
            visit.setDoctor(match(desc, "Doctor:\\s*([A-Z][a-z]+,\\s*[A-Z][a-z]+)", "not found"));

            // Medication check (comma-separated list)
            String meds = match(desc, "(?:took|reported taking|taking)\\s*:?\\s*([^.]+)", null);
            if (meds != null) {
                visit.setMedications(meds);
            }

            management.addVisit(visit);
        }

        br.close();
    }

    /**
     * Helper method to find regex matches and return a default if not found.
     * @param text The text to search in
     * @param regex The regex pattern to use
     * @param fallback What to return if no match found
     * @return Matched text or fallback value
     */
    private String match(String text, String regex, String fallback) {
        Matcher m = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text);
        return m.find() ? m.group(1) : fallback;
    }

    /**
     * Generate and print the report.
     */
    public void report() {
        management.printReport();
    }
}
