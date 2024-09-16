import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
 class Student{
   
        
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}


public class StudentGradeSystem {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Pooja", 90));
        students.add(new Student("Dasha", 90));
        students.add(new Student("Ridhi", 85));
        students.add(new Student("Malu", 95));
        students.add(new Student("Sivi", 80));

        calculateGrades(students);
    }

    public static void calculateGrades(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        double average = students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0);

        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();
        for (Student student : students) {
            if (student.getGrade() > highest) {
                highest = student.getGrade();
            }
            if (student.getGrade() < lowest) {
                lowest = student.getGrade();
            }
        }

        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);

        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparing(Student::getGrade))
                .collect(Collectors.toList());

        System.out.println("Grades in ascending order: ");
        for (Student student : sortedStudents) {
            System.out.println(student.getName() + ": " + student.getGrade());
        }
    }
}
