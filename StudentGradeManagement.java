import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            students.add(new Student(name, marks));

            total += marks;

            if (marks > highest) {
                highest = marks;
            }

            if (marks < lowest) {
                lowest = marks;
            }
        }

        double average = total / n;

        ArrayList<String> highestStudents = new ArrayList<>();
        ArrayList<String> lowestStudents = new ArrayList<>();

        for (Student s : students) {

            if (s.marks == highest) {
                highestStudents.add(s.name);
            }

            if (s.marks == lowest) {
                lowestStudents.add(s.name);
            }
        }

        System.out.println("\n===== STUDENT SUMMARY REPORT =====");
        System.out.println("Name\t\tMarks");

        for (Student s : students) {
            System.out.println(s.name + "\t\t" + s.marks);
        }

        System.out.println("\nAverage Marks : " + average);

        System.out.print("Highest Marks : " + highest + " (");
        for (int i = 0; i < highestStudents.size(); i++) {
            System.out.print(highestStudents.get(i));
            if (i < highestStudents.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");

        System.out.print("Lowest Marks  : " + lowest + " (");
        for (int i = 0; i < lowestStudents.size(); i++) {
            System.out.print(lowestStudents.get(i));
            if (i < lowestStudents.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");

        sc.close();
    }
}