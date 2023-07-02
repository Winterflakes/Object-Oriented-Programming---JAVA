package Practical_7;

import java.util.TreeSet;

public class B {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        try {
            // Adding students to the phone directory
            phoneDirectory.addStudent(new Student(101, "Sakshi", 4, "Nagpur", "8799977699"));
            phoneDirectory.addStudent(new Student(102, "Pragati", 4, "Nagpur", "8767500182"));
            phoneDirectory.addStudent(new Student(103, "Divya", 4, "Nagpur", "8788325991"));
            phoneDirectory.addStudent(new Student(104, "Siya", 4, "Nagpur", "9767316880"));
            phoneDirectory.addStudent(new Student(105, "Tanisha", 4, "Nagpur", "9322470646"));

            // Displaying all students
            System.out.println("All Students:");
            phoneDirectory.viewAllStudents();
            System.out.println();

            // Displaying students from Nagpur
            System.out.println("Students from Nagpur:");
            phoneDirectory.viewStudentsByCity("Nagpur");
            System.out.println();

            // Removing a student
            Student studentToRemove = new Student(104, "Siya", 4, "Nagpur", "9767316880");
            phoneDirectory.removeStudent(studentToRemove);

            // Displaying all students after removal
            System.out.println("All Students after removal:");
            phoneDirectory.viewAllStudents();
        } catch (MissingDataException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
class Student implements Comparable<Student> {
    private int roll;
    private String name;
    private int semester;
    private String city;
    private String contact;

    public Student(int roll, String name, int semester, String city, String contact) throws MissingDataException {
        if (name == null || name.isEmpty() || city == null || city.isEmpty() || contact == null || contact.isEmpty()) {
            throw new MissingDataException("Missing data for Student");
        }
        this.roll = roll;
        this.name = name;
        this.semester = semester;
        this.city = city;
        this.contact = contact;
    }

    // Getters and Setters

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCity() {
        return city;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public int compareTo(Student other) {
        if (this.semester != other.semester) {
            return this.semester - other.semester;
        } else {
            return this.roll - other.roll;
        }
    }

    @Override
    public String toString() {
        return "Roll: " + roll + ", Name: " + name + ", Semester: " + semester + ", City: " + city + ", Contact: " + contact;
    }
}
class MissingDataException extends Exception {
    public MissingDataException(String message) {
        super(message);
    }
}

class PhoneDirectory {
    private TreeSet<Student> students;

    public PhoneDirectory() {
        students = new TreeSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void viewAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void viewStudentsByCity(String city) {
        for (Student student : students) {
            if (student.getCity().equalsIgnoreCase(city)) {
                System.out.println(student);
            }
        }
    }
}
