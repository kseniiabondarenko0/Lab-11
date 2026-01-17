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

        File file = new File("src/Introduction to Programming 2025 Data.csv");
        VisitParser parser = null;

        VisitManagment manager = new VisitManagment();
        parser = new VisitParser();


        BufferedReader reader = new BufferedReader(
                new FileReader("Introduction to Programming 2025 Data.csv"));

        String line;
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) {
            manager.incrementTotalLines();

            if (firstLine) {
                firstLine = false;
                continue;
            }

            if (line.trim().isEmpty()) {
                manager.incrementEmptyLines();
                System.out.println("Warning: empty line rejected");
                continue;
            }

            String[] parts = line.split(",", 2);
            if (parts.length != 2) continue;

            Visit visit = parser.parse(parts[0].trim(), parts[1].trim());
            manager.addVisit(visit);
        }

        reader.close();
        manager.printReport();

    }
}