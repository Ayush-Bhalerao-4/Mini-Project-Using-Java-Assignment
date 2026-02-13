import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private int[] marks;

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public double calculateAverage() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total / 5.0;
    }

    public char calculateGrade(double score) {
        if (score >= 75)
            return 'A';
        else if (score >= 60)
            return 'B';
        else
            return 'C';
    }

    public void displayResult() {
        System.out.println("\nStudent Name : " + name);
        System.out.println("Roll Number  : " + rollNo);

        for (int i = 0; i < 5; i++) {
            System.out.println("Subject " + (i + 1) +
                    " Marks: " + marks[i] +
                    " Grade: " + calculateGrade(marks[i]));
        }

        double avg = calculateAverage();
        System.out.println("Overall Average: " + avg);
        System.out.println("Overall Grade  : " + calculateGrade(avg));
    }

    public int[] getMarks() {
        return marks;
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];
        int[][] allMarks = new int[n][5];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();

            int[] marks = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Enter marks for Sub " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
                allMarks[i][j] = marks[j];
            }
            sc.nextLine();

            students[i] = new Student(name, rollNo, marks);
        }

        // Display individual results
        for (Student s : students) {
            s.displayResult();
        }

        // Calculate subject-wise average
        System.out.println("\nSubject-wise Average Marks of All Students:");
        for (int j = 0; j < 5; j++) {
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += allMarks[i][j];
            }
            double subjectAvg = total / (double) n;
            System.out.println("Subject " + (j + 1) + " Average: " + subjectAvg);
        }

        sc.close();
    }
}