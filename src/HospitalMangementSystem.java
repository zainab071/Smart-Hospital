import java.util.*;

class Patient {
    int id;
    String name;
    int age;
    String symptoms;
    int assignedDoctorId; // 0 means not assigned

    Patient(int id, String name, int age, String symptoms) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.symptoms = symptoms;
        this.assignedDoctorId = 0;
    }
}

class Doctor {
    int id;
    String name;
    String specialization;
    List<Integer> assignedPatients;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.assignedPatients = new ArrayList<>();
    }
}

public class HospitalMangementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Patient> patients = new HashMap<>();
        Map<Integer, Doctor> doctors = new HashMap<>();

        System.out.println("--------- Welcome to IDC Islamabad ---------");

        while (true) {
            System.out.println("\n----- Hospital Management System Menu -----");
            System.out.println("1. Register Patient");
            System.out.println("2. Register Doctor");
            System.out.println("3. Assign Doctor to Patient");
            System.out.println("4. View Patient Record");
            System.out.println("5. View Doctor Schedule");
            System.out.println("6. Discharge Patient");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("----- Register Patient -----");
                    System.out.print("Enter ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter symptoms: ");
                    String symptoms = sc.nextLine();
                    patients.put(pid, new Patient(pid, pname, age, symptoms));
                    System.out.println(" Patient registered.");
                    break;

                case 2:
                    System.out.println("----- Register Doctor -----");
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = sc.nextLine();
                    doctors.put(did, new Doctor(did, dname, specialization));
                    System.out.println(" Doctor registered.");
                    break;

                case 3:
                    System.out.println("----- Assign Doctor to Patient -----");
                    System.out.print("Enter Patient ID: ");
                    int assignPid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Doctor ID: ");
                    int assignDid = sc.nextInt();
                    sc.nextLine();

                    if (patients.containsKey(assignPid) && doctors.containsKey(assignDid)) {
                        Patient p = patients.get(assignPid);
                        Doctor d = doctors.get(assignDid);
                        p.assignedDoctorId = assignDid;
                        d.assignedPatients.add(assignPid);
                        System.out.println(" Doctor " + d.name + " assigned to patient " + p.name);
                    } else {
                        System.out.println(" Invalid patient or doctor ID.");
                    }
                    break;

                case 4:
                    System.out.println("----- View Patient Record -----");
                    System.out.print("Enter Patient ID: ");
                    int viewPid = sc.nextInt();
                    sc.nextLine();

                    if (patients.containsKey(viewPid)) {
                        Patient p = patients.get(viewPid);
                        System.out.println(" Patient Record:");
                        System.out.println("ID: " + p.id);
                        System.out.println("Name: " + p.name);
                        System.out.println("Age: " + p.age);
                        System.out.println("Symptoms: " + p.symptoms);
                        if (p.assignedDoctorId != 0 && doctors.containsKey(p.assignedDoctorId)) {
                            Doctor d = doctors.get(p.assignedDoctorId);
                            System.out.println("Assigned Doctor: " + d.name + " (Specialization: " + d.specialization + ")");
                        } else {
                            System.out.println("Assigned Doctor: None");
                        }
                    } else {
                        System.out.println(" Patient not found.");
                    }
                    break;

                case 5:
                    System.out.println("----- View Doctor Schedule -----");
                    for (Doctor d : doctors.values()) {
                        System.out.println("\nDoctor ID: " + d.id);
                        System.out.println("Name: " + d.name);
                        System.out.println("Specialization: " + d.specialization);
                        System.out.println("Assigned Patients:");
                        if (d.assignedPatients.isEmpty()) {
                            System.out.println("  No patients assigned.");
                        } else {
                            for (int pidAssigned : d.assignedPatients) {
                                Patient p = patients.get(pidAssigned);
                                System.out.println("  - " + p.name + " (ID: " + p.id + ", Symptoms: " + p.symptoms + ")");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("----- Discharge Patient -----");
                    System.out.print("Enter Patient ID to discharge: ");
                    int dischargeId = sc.nextInt();
                    sc.nextLine();

                    if (patients.containsKey(dischargeId)) {
                        Patient p = patients.get(dischargeId);
                        if (p.assignedDoctorId != 0 && doctors.containsKey(p.assignedDoctorId)) {
                            Doctor d = doctors.get(p.assignedDoctorId);
                            d.assignedPatients.remove(Integer.valueOf(dischargeId));
                        }
                        patients.remove(dischargeId);
                        System.out.println(" Patient " + p.name + " has been discharged.");
                    } else {
                        System.out.println(" Patient ID not found.");
                    }
                    break;

                case 7:
                    System.out.println(" Exiting system. Thank you for visiting IDC Islamabad.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

