public class Patient {
    private int age;
    private String phoneNumber;
    private String email;

    public Patient(int age, String phoneNumber, String email) {
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
