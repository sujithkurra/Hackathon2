import java.util.Scanner;

public class Student {

    String studentName;
    long rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    // Parameterized constructor
    Student(String studentName, long rollNumber, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Calculate course fee
    double calculateFee() {
        return courseCredits * 1500;
    }

    // Check eligibility
    boolean checkEligibility() {
        return marks >= 50;
    }

    // Calculate scholarship percentage
    double calculateScholarship() {
        if (marks >= 85) {
            return 20;
        } else if (marks >= 70) {
            return 10;
        } else {
            return 0;
        }
    }

    // Calculate final fee
    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarship = calculateScholarship();

        return fee - (fee * scholarship / 100);
    }

    // Display details
    void displayDetails() {

        double fee = calculateFee();
        double scholarship = calculateScholarship();
        double scholarshipAmount = fee * scholarship / 100;
        double finalFee = calculateFinalFee();

        System.out.println("\n--- Student Course Registration ---");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility        : Eligible");
        System.out.println("Total Fee          : Rs. " + fee);
        System.out.println("Scholarship        : " + scholarship + "%");
        System.out.println("Scholarship Amount : Rs. " + scholarshipAmount);
        System.out.println("Final Fee          : Rs. " + finalFee);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        long roll = sc.nextLong();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        // Create Student object
        Student s = new Student(name, roll, marks, course, credits);

        // Check eligibility
        if (s.checkEligibility()) {
            s.displayDetails();
        } else {
            System.out.println("\nStudent is NOT eligible for registration.");
            System.out.println("Minimum marks required: 50");
        }

    }
}