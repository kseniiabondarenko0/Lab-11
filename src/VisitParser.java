import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisitParser {

    private static final Pattern AGE_PATTERN =
            Pattern.compile("patient is (\\d{1,3}) years old", Pattern.CASE_INSENSITIVE);

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("(\\+?\\d{9,15})");

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("[\\w.-]+@[\\w.-]+");

    private static final Pattern DOCTOR_PATTERN =
            Pattern.compile("Doctor:\\s*([A-Z][a-zA-Z]+,\\s*[A-Z][a-zA-Z]+)");

    private static final Pattern MEDICATION_PATTERN =
            Pattern.compile("(took|reported taking) ([a-zA-Z,\\s]+)", Pattern.CASE_INSENSITIVE);


    public Visit parse(String dateStr, String description) {

        LocalDate date = LocalDate.parse(dateStr);

        int age = extractAge(description);
        String phone = extractPhone(description);
        String email = extractEmail(description);

        Patient patient = new Patient(age, phone, email);

        String doctor = extractDoctor(description);
        List<String> meds = extractMedications(description);

        return new Visit(date, patient, doctor, meds);
    }

    private int extractAge(String text) {
        Matcher m = AGE_PATTERN.matcher(text);
        return m.find() ? Integer.parseInt(m.group(1)) : null;
    }

    private int extractAge(String text) {
        Matcher m = AGE_PATTERN.matcher(text);
        return m.find() ? Integer.parseInt(m.group(1)) : null;
    }

    private String extractPhone(String text) {
        Matcher m = PHONE_PATTERN.matcher(text);
        return m.find() ? m.group(1) : "not found";
    }

    private String extractEmail(String text) {
        Matcher m = EMAIL_PATTERN.matcher(text);
        return m.find() ? m.group() : "not found";
    }

    private String extractDoctor(String text) {
        Matcher m = DOCTOR_PATTERN.matcher(text);
        return m.find() ? m.group(1) : "not found";
    }

    private List<String> extractMedications(String text) {
        Matcher m = MEDICATION_PATTERN.matcher(text);
        if (!m.find()) return List.of();

        String[] parts = m.group(2).split(",");
        List<String> meds = new ArrayList<>();
        for (String p : parts) {
            meds.add(p.trim());
        }
        return meds;
    }
}
