import java.time.LocalDate;
import java.util.List;

public class Visit {

    private LocalDate date;
    private Patient patient;
    private String doctor;
    private List<String> medications;

    public Visit(LocalDate date, Patient patient, String doctor, List<String> medications) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.medications = medications;
    }

    public LocalDate getDate() {
        return date;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public List<String> getMedications() {
        return medications;
    }

    public boolean tookMedication() {
        return medications != null && !medications.isEmpty();
    }
}
