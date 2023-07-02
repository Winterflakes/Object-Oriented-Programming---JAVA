package Practical_5;

import java.util.regex.Pattern;

public class A {
      public static void main(String[] args) {
        try {
            // Valid student details
            Student student1 = new Student("Sakshi", 8.4, "BE21CSU105", "Password123!");
            System.out.println("Details of"+ student1.name +"created successfully.");

            // Invalid student details (for demonstration)
            Student student2 = new Student("Soni", 11.2, "BE20ABC123", "weak");
            System.out.println("Details of"+ student2.name +"created successfully.");
        } catch (InvalidStudentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


// Custom exception class for invalid student details
class InvalidStudentException extends Exception {
    public InvalidStudentException(String message) {
        super(message);
    }
}

// Student class
class Student {
    String name;
    private double cgpa;
    private String enrolmentNumber;
    private String password;

    // Constructor
    public Student(String name, double cgpa, String enrolmentNumber, String password) throws InvalidStudentException {
        // Validate CGPA
        if (cgpa < 0 || cgpa > 10) {
            throw new InvalidStudentException("Invalid CGPA! CGPA should be between 0 and 10.");
        }

        // Validate Enrolment Number
        String pattern = "^BE(20|21|22|23)(CSU|ENU|ECU|EEU)([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|250)$";
        if (!Pattern.matches(pattern, enrolmentNumber)) {
            throw new InvalidStudentException("Invalid Enrolment Number! Enrolment number should be in the format BEYY<Branch><RollNumber>.");
        }

        // Validate Password
        if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!$%*&])[A-Za-z\\d!$%*&]{8,}$", password)) {
            throw new InvalidStudentException("Invalid Password! Password should have a minimum of 8 characters and include at least 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special symbol(!,$,%,&,*).");
        }

        this.name = name;
        this.cgpa = cgpa;
        this.enrolmentNumber = enrolmentNumber;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    public String getEnrolmentNumber() {
        return enrolmentNumber;
    }

    public String getPassword() {
        return password;
    }
}


