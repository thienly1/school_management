package se.lexicon.teacher;

public class Teacher {
    private int TeacherId;
    private String name;
    private String email;
    private String address;
    private static int IdCountSequencer= 0;

    public Teacher(String name, String email, String address) {
        this();
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Teacher() {
        TeacherId = ++IdCountSequencer;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TeacherId=" + TeacherId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
