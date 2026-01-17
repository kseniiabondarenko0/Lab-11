import java.io.IOException;


/**
 * @author Kseniia Bondarenko
 * @version 1.0
 * @since 12.01.2026
 */

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize the parser
            VisitParser parser = new VisitParser();

            // Parse the CSV file
            parser.parse("src/data.csv");

            // Print the report
            parser.report();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}