package Practical_3;

public class A {
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] students = new Student[3];
        students[0] = new PlacementStudent("John Doe", "Male", "Computer Science", 8.5, "ABC Industries", 500000.0, "PLC123");
        students[1] = new HigherStudiesStudent("Jane Smith", "Female", "Electrical Engineering", 9.2, "Masters", "XYZ University", "ADMIT456", "GRE", 320);
        students[2] = new EntrepreneurshipStudent("David Johnson", "Male", "Mechanical Engineering", 7.8, "XYZ Company", "Technology", 50, 1000000.0);

        // Display information of all students
        for (Student student : students) {
            student.displayInformation();
            System.out.println("--------------------");
        }
    }
}

// Parent class: Student
class Student {
    private String name;
    private String gender;
    private String department;
    private double cgpa;

    // Constructor
    public Student(String name, String gender, String department, double cgpa) {
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.cgpa = cgpa;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getCGPA() {
        return cgpa;
    }

    // Method to display student information
    public void displayInformation() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Department: " + department);
        System.out.println("CGPA: " + cgpa);
    }
}

// Child class: PlacementStudent
class PlacementStudent extends Student {
    private String industryName;
    private double annualPackage;
    private String joiningLetterNumber;

    // Constructor
    public PlacementStudent(String name, String gender, String department, double cgpa, String industryName, double annualPackage, String joiningLetterNumber) {
        super(name, gender, department, cgpa);
        this.industryName = industryName;
        this.annualPackage = annualPackage;
        this.joiningLetterNumber = joiningLetterNumber;
    }

    // Method to display student information with placement details
    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Industry Name: " + industryName);
        System.out.println("Annual Package: " + annualPackage);
        System.out.println("Joining Letter Number: " + joiningLetterNumber);
    }
}

// Child class: HigherStudiesStudent
class HigherStudiesStudent extends Student {
    private String degreeName;
    private String collegeName;
    private String admissionLetterNumber;
    private String competitiveExamName;
    private double competitiveExamScore;

    // Constructor
    public HigherStudiesStudent(String name, String gender, String department, double cgpa, String degreeName, String collegeName, String admissionLetterNumber, String competitiveExamName, double competitiveExamScore) {
        super(name, gender, department, cgpa);
        this.degreeName = degreeName;
        this.collegeName = collegeName;
        this.admissionLetterNumber = admissionLetterNumber;
        this.competitiveExamName = competitiveExamName;
        this.competitiveExamScore = competitiveExamScore;
    }

    // Method to display student information with higher studies details
    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Degree Name: " + degreeName);
        System.out.println("College Name: " + collegeName);
        System.out.println("Admission Letter Number: " + admissionLetterNumber);
        System.out.println("Competitive Exam Name: " + competitiveExamName);
        System.out.println("Competitive Exam Score: " + competitiveExamScore);
    }
}

// Child class: EntrepreneurshipStudent
class EntrepreneurshipStudent extends Student {
    private String companyName;
    private String sector;
    private int numberOfEmployees;
    private double annualTurnover;

    // Constructor
    public EntrepreneurshipStudent(String name, String gender, String department, double cgpa, String companyName, String sector, int numberOfEmployees, double annualTurnover) {
        super(name, gender, department, cgpa);
        this.companyName = companyName;
        this.sector = sector;
        this.numberOfEmployees = numberOfEmployees;
        this.annualTurnover = annualTurnover;
    }

    // Method to display student information with entrepreneurship details
    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Company Name: " + companyName);
        System.out.println("Sector: " + sector);
        System.out.println("Number of Employees: " + numberOfEmployees);
        System.out.println("Annual Turnover: " + annualTurnover);
    }
}



