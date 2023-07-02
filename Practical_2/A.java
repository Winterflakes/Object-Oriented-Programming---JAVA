package Practical_2;

import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        // Create employee
        Employee employee = new Employee("John Doe", 12345, "Software Engineer", 30, 5000.0);

        // Add attendance
        employee.addAttendance(new Time(9, 0, 0), new Time(17, 0, 0), "2023-07-01");
        employee.addAttendance(new Time(9, 30, 0), new Time(18, 30, 0), "2023-07-02");
        employee.addAttendance(new Time(9, 15, 0), new Time(17, 45, 0), "2023-07-03");

        // Display employee information
        employee.displayEmployeeInfo();

        // Calculate total working hours in a month
        Time totalWorkingHours = employee.calculateTotalWorkingHours();
        System.out.println("Total Working Hours in a Month: " + totalWorkingHours);

        // Get working hours for a given date
        String date = "2023-07-02";
        Time workingHours = employee.getWorkingHoursByDate(date);
        if (workingHours != null) {
            System.out.println("Working Hours for " + date + ": " + workingHours);
        } else {
            System.out.println("No attendance found for " + date);
        }
    }
}

// Class to represent time
class Time {
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Add two time objects
    public Time addTime(Time otherTime) {
        int totalSeconds = this.seconds + otherTime.seconds;
        int seconds = totalSeconds % 60;

        int totalMinutes = this.minutes + otherTime.minutes + (totalSeconds / 60);
        int minutes = totalMinutes % 60;

        int hours = this.hours + otherTime.hours + (totalMinutes / 60);

        return new Time(hours, minutes, seconds);
    }

    // Subtract two time objects
    public Time subtractTime(Time otherTime) {
        int totalSeconds = (this.hours * 3600 + this.minutes * 60 + this.seconds) - (otherTime.hours * 3600 + otherTime.minutes * 60 + otherTime.seconds);
        int seconds = Math.abs(totalSeconds % 60);

        int totalMinutes = Math.abs(totalSeconds / 60);
        int minutes = totalMinutes % 60;

        int hours = totalMinutes / 60;

        return new Time(hours, minutes, seconds);
    }

    // Display time in HH:MM:SS format
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

// Class to store attendance
class Attendance {
    private Time timeIn;
    private Time timeOut;
    private String date;

    // Constructor
    public Attendance(Time timeIn, Time timeOut, String date) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.date = date;
    }

    // Getters
    public Time getTimeIn() {
        return timeIn;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public String getDate() {
        return date;
    }
}

// Class to represent an employee
class Employee {
    private String name;
    private int id;
    private String designation;
    private int age;
    private double salary;
    private List<Attendance> attendanceList;

    // Constructor
    public Employee(String name, int id, String designation, int age, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.age = age;
        this.salary = salary;
        this.attendanceList = new ArrayList<>();
    }

    // Add attendance
    public void addAttendance(Time timeIn, Time timeOut, String date) {
        Attendance attendance = new Attendance(timeIn, timeOut, date);
        attendanceList.add(attendance);
    }

    // Calculate total working hours in a month
    public Time calculateTotalWorkingHours() {
        Time totalWorkingHours = new Time(0, 0, 0);

        for (Attendance attendance : attendanceList) {
            Time workingHours = attendance.getTimeOut().subtractTime(attendance.getTimeIn());
            totalWorkingHours = totalWorkingHours.addTime(workingHours);
        }

        return totalWorkingHours;
    }

    // Get working hours for a given date
    public Time getWorkingHoursByDate(String date) {
        for (Attendance attendance : attendanceList) {
            if (attendance.getDate().equals(date)) {
                return attendance.getTimeOut().subtractTime(attendance.getTimeIn());
            }
        }

        return null;
    }

    // Display employee information
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
        System.out.println("Attendance:");
        for (Attendance attendance : attendanceList) {
            System.out.println("- Date: " + attendance.getDate());
            System.out.println("  Time In: " + attendance.getTimeIn());
            System.out.println("  Time Out: " + attendance.getTimeOut());
        }
        System.out.println();
    }
}

// Main class to demonstrate the EMS
