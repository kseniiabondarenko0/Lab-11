import java.time.LocalDate;

/**
 * Represents a single patient visit with extracted information.
 */
public class Visit {
    private LocalDate date;
    private String age;
    private String phone;
    private String email;
    private String doctor;
    private String medications;
    private boolean hasMeds;

    /**
     * Constructor for a medical visit.
     * @param date The YYYY-mm-dd date of the visit.
     */
    public Visit(LocalDate date) {
        this.date = date;
        this.age = "not found";
        this.phone = "not found";
        this.email = "not found";
        this.doctor = "not found";
        this.medications = "not found";
        this.hasMeds = false;
    }

    // Getters and Setters (Encapsulation)
    public LocalDate getDate() { return date; }
    public String getAge() { return age; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getDoctor() { return doctor; }
    public String getMedications() { return medications; }
    public boolean tookMedication() { return hasMeds; }

    public void setAge(String age) { this.age = age; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setDoctor(String doctor) { this.doctor = doctor; }
    public void setMedications(String medications) {
        this.medications = medications;
        this.hasMeds = true;
    }
}
