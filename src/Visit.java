import java.time.LocalDate;
import java.util.List;

public class Visit extends Patient{
    /**
     * Constructor for a medical visit
     * Each visit is associated with exactly one patient
     */

        private LocalDate date;
        private String age;
        private String phone;
        private String email;
        private String doctor;
        private String medications = "not found";
        private boolean hasMeds = false;

        public Visit(LocalDate date) { this.date = date; }

        // Getters and Setters
        public LocalDate getDate() { return date; }
        public boolean tookMedication() { return hasMeds; }
        public void setHasMeds(boolean hasMeds) { this.hasMeds = hasMeds; }
        public void setAge(String age) { this.age = age; }
        public void setPhone(String phone) { this.phone = phone; }
        public void setEmail(String email) { this.email = email; }
        public void setDoctor(String doctor) { this.doctor = doctor; }
        public void setMedications(String medications) { this.medications = medications; }
    }


