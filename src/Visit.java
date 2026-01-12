import java.time.LocalDate;
import java.util.List;

public class Visit {
    /**
     * Constructor for a medical visit
     * Each visit is associated with exactly one patient
     */
    private Visit visit;
    private LocalDate date;
    private Patient patient;
    private String doctor;
    private List<String> medications;

    /**
     * Constructs a Visit object.
     *
     * @param date date of the visit
     * @param patient patient involved in the visit
     * @param doctor name of the doctor, or "not found"
     * @param medications list of medications taken during the visit
     */

    public Visit(LocalDate date, Patient patient, String doctor, List<String> medications) {
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
        this.medications = medications;
        this.visit = visit;
    }

    public Visit getVisit() {
        return visit;
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
