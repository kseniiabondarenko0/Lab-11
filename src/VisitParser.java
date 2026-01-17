import java.io.*;
import java.util.regex.*;
import java.time.LocalDate;
/**
 * Handles the reading of the input CSV and applies Regex patterns
 * to identify specific patient information.
 */
public class VisitParser {
    private VisitManagment management = new VisitManagment();
    /**
     * Reads the file line by line and applies data quality checks.
     * @param fileName Path to the CSV data file.
     */
    public void parse(String fileName, String trim) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                management.incrementTotalLines();

                //Identify and reject empty lines
                if (line.trim().isEmpty()) {
                    System.out.println("Quality Alert: Empty line ignored.");
                    management.incrementEmptyLines();
                    continue;
                }

                // Split CSV but keep quotes together
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", 2);
                if (parts.length < 2) continue;

                // FIX: Remove quotes from date to prevent DateTimeParseException
                String dateStr = parts[0].replace("\"", "").trim();
                LocalDate date = LocalDate.parse(dateStr);

                String desc = parts[1];
                Visit visit = new Visit(date);

                // Regex Requirements
                visit.setAge(match(desc, "The patient is (\\d+) years old", "not found"));
                visit.setPhone(match(desc, "(\\d{3}-\\d{3}-\\d{3})", "not found"));
                visit.setEmail(match(desc, "([\\w.-]+@[\\w.-]+\\.[a-z]{2,})", "not found"));
                visit.setDoctor(match(desc, "Doctor: ([^,]+, [^.]+)", "not found"));

                // Medication check (comma-separated list)
                String meds = match(desc, "(?:took|reported taking), ([^.]+)", null);
                if (meds != null) {
                    visit.setMedications(meds);
                    visit.setHasMeds(true);
                }

                management.addVisit(visit);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    /**
     * Helper method to find regex matches and return a default if not found
     */
    private String match(String text, String regex, String fallback) {
        Matcher m = Pattern.compile(regex).matcher(text);
        return m.find() ? m.group(1) : fallback;
    }

    public void report() { management.printReport(); }

}