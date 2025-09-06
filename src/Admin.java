import java.util.*;

class Student {
    int id;
    String name;
    List<String> enrolledCourses = new ArrayList<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Course {
    String code;
    String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}

public class Admin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Student> students = new HashMap<>();
        Map<String, Course> courses = new HashMap<>();

        while (true) {
            System.out.println("\n--- University Admin Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View Student Profile");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    students.put(id, new Student(id, name));
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter course code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    courses.put(code, new Course(code, title));
                    System.out.println("Course added.");
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int studentId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course code: ");
                    String courseCode = sc.nextLine();
                    if (students.containsKey(studentId) && courses.containsKey(courseCode)) {
                        students.get(studentId).enrolledCourses.add(courseCode);
                        System.out.println("Student enrolled in course.");
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    int viewId = sc.nextInt();
                    sc.nextLine();
                    if (students.containsKey(viewId)) {
                        Student s = students.get(viewId);
                        System.out.println("Student Name: " + s.name);
                        System.out.println("Enrolled Courses:");
                        for (String c : s.enrolledCourses) {
                            Course course = courses.get(c);
                            System.out.println("  " + course.code + " - " + course.title);
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

