import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author Kseniia Bondarenko
 * @version 1.0
 * @since 12.01.2026
 */

public class Main {
    public static void main(String[] args) throws IOException {

// Initialize the parser to handle data extraction
        VisitParser parser = new VisitParser();

        // Start reading the CSV file and extracting patient data
        // Uses the path specified in the project structure
        parser.parse("src/data.csv", "");

        // Output the final statistics and date ranges
        parser.report();
        VisitManagment manager = new VisitManagment();
        //manager.printReport();

    }
}