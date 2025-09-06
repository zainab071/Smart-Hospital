
import java.util.*;
public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------Welcome to student Grade System ----------------- ");
        System.out.println("Enter how many students in class ?");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<Map<String, Object>> studentGrades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Map<String, Object> student = new HashMap<>();

            System.out.println("Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine().toUpperCase();
            student.put("name", name);

            System.out.print("Roll number: ");
            int rollNumber = sc.nextInt();
            sc.nextLine(); // consume newline
            student.put("roll_number", rollNumber);

            System.out.print("Enter how many subjects: ");
            int subjectCount = sc.nextInt();
            sc.nextLine(); // consume newline

            Map<String, Integer> subjects = new LinkedHashMap<>();
            int totalMarks = 0;

            for (int j = 0; j < subjectCount; j++) {
                System.out.print("Subject " + (j + 1) + " name: ");
                String subjectName = sc.nextLine();

                System.out.print("Marks for " + subjectName + ": ");
                int marks = sc.nextInt();
                sc.nextLine(); // consume newline

                subjects.put(subjectName, marks);
                totalMarks += marks;
            }

            double average = totalMarks / (double) subjectCount;
            double percentage = (totalMarks / (subjectCount * 100.0)) * 100;

            student.put("subjects", subjects);
            student.put("total", totalMarks);
            student.put("average", average);
            student.put("percentage", percentage);

            studentGrades.add(student);
        }

        System.out.println("--------------- Student Report Card ---------------");
        for (Map<String, Object> student : studentGrades) {
            System.out.println("Name: " + student.get("name"));
            System.out.println("Roll number: " + student.get("roll_number"));

            System.out.println("Subjects and Marks:");
            Map<String, Integer> subjects = (Map<String, Integer>) student.get("subjects");
            for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("Total Marks: " + student.get("total"));
            System.out.println("Average Marks:"+ student.get("average"));
            System.out.println ("Percentage:" + student.get("percentage"));

            double percentage = (double) student.get("percentage");
            double gpa;
            if (percentage >= 90) {
                gpa = 4.0;
            } else if (percentage >= 80) {
                gpa = 3.5;
            } else if (percentage >= 70) {
                gpa = 3.0;
            } else if (percentage >= 60) {
                gpa = 2.5;
            } else if (percentage >= 50) {
                gpa = 2.0;
            } else {
                gpa = 1.0;
            }

            System.out.println("GPA: " + gpa);
        }

        sc.close();
    }
}


