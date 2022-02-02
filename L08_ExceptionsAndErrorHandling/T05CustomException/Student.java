package M04_JavaOOP.L08_ExceptionsAndErrorHandling.T05CustomException;

import java.util.regex.Pattern;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        boolean isValid = Pattern.matches("^[A-Za-z]+$", name);

        if (!isValid) {
            throw new InvalidPersonNameException("Name should not contain any numbers." +
                    " Please, use letters only.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("My name is %s and my email is %s.",
                this.name, this.email);
    }
}