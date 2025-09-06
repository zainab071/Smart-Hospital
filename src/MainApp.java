import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Welcome to Student Attendance Tracker  ------------");
        System.out.println("Total  number of students in a class ");
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] roll_no = new int[n];
        String[] statuses = new String[n];

        int presentcount = 0;
        int absentcount = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(" students " + (i + 1) + " : ");

            sc.nextLine();
            System.out.println("names :");
            names[i] = sc.nextLine();
            System.out.println("Roll number :");
            roll_no[i] = sc.nextInt();
            sc.nextLine();

            while (true) {
                System.out.println("Mark student Attendance :( present /  absent)");
                String status = sc.nextLine();
                if (status.equalsIgnoreCase("present")) {
                    statuses[i] = "present";
                    presentcount++;
                    break;
                } else if (status.equalsIgnoreCase("absent")) {
                    statuses[i] = "absent";
                    absentcount++;
                    break;
                } else {
                    System.out.println("Invalid .Enter 'present' and 'absent' ");
                }
            }

        }//display Result
        System.out.println("\n-------Attendance Summary-----------");
        System.out.println("Total  Students :" + n);
        System.out.println("Present student :" + presentcount);
        System.out.println("Absent student : " + absentcount);
        // display absent student
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (statuses[i].equals("absent")) {
                System.out.println("Name : " + names[i] + "| Roll number : " + roll_no[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students were absent ");
        }
        // display in  tabular form
        System.out.println("\n--------Display attendance in tabular form ---------------");
        for (int i = 0; i < n; i++) {
            System.out.println("\n Name   :  " + names[i] + " Roll number   : " + roll_no[i] + "attendance status  :" + statuses[i]);
        }
        sc.close();

    }

}


