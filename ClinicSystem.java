import java.util.Scanner;

class Patient{
    int id;
    String name;
    int age;
    int severity;

    public Patient(int id, String name, int age, int severity){
        this.id = id;
        this.name = name;
        this.age = age;
        this.severity = severity;
    }
}

class Doctor {
    String name;

    public Doctor(String name){
        this.name = name;
    }
}

class NodeForSLL {
    Patient patient;
    NodeForSLL next;

    public NodeForSLL(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
    }

class WaitingList {
    NodeForSLL head;
    NodeForSLL tail;

    void addPatient(Patient patient){
        NodeForSLL current = head;
        NodeForSLL newNode = new NodeForSLL(patient);
          while(current != null){
            if (current.patient.id == patient.id){
                System.out.println("This Patient ID already exists. Patient not added.");
                return;
            }
            current = current.next;
        }
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void sortBySeverity(){
        boolean swapped = true;
        while (swapped){
            swapped = false;
            NodeForSLL current = head;

            while (current != null && current.next != null) {
                if (current.patient.severity <        current.next.patient.severity) {
                    Patient temp = current.patient;
                    current.patient = current.next.patient;
                    current.next.patient = temp;
                    swapped = true;
            }
            current = current.next;
        }

        }
    }

    Patient removeFirst() {
    if (head == null) {
        return null;
    }

    Patient treatedPatient = head.patient;
    head = head.next;

    if (head == null) {
        tail = null;
    }

    return treatedPatient;
}

    void displaylist(){
        NodeForSLL current = head;
        if(head == null){
            System.out.println("Waiting list is empty.");
            return;
        }

        while (current!=null){
            System.out.println("ID: " + current.patient.id + " | Name: " + current.patient.name + " | Age: " + current.patient.age + " | Severity: " + current.patient.severity);

            current = current.next;
        }
    }

    void removePatient(int id){
        NodeForSLL current = head;
        if (head == null){
            System.out.println("List is empty. No Patients to remove");
            return;
        }

        if (head.patient.id == id){
            head = head.next;

            if (head == null){
                tail = null;
            }
            System.out.println("Patient with ID (" + id + ") has been removed.");
            return;
        }

        while (current.next != null && current.next.patient.id != id){
            current = current.next;
        }

        if (current.next == null){
            System.out.println("Patient with ID (" + id + ") does not exist.");
            return;
        }

        current.next = current.next.next;
        
        if (current.next == null){
            tail = current;
        }

        System.out.println("Patient with ID (" + id + ") has been removed.");
    }
}

class NodeForCLL {
    Doctor doctor;
    NodeForCLL next;

    public NodeForCLL(Doctor doctor) {
        this.doctor = doctor;
        this.next = null;
    }
}

class DoctorRing {
    NodeForCLL head;
    NodeForCLL tail;
    NodeForCLL turn = head;

    void addDoctor(Doctor doctor){
        NodeForCLL newNode = new NodeForCLL(doctor);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            turn = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void displayDoctors(){
        NodeForCLL current = head;
        if (head == null){
            System.out.println("There are no Doctors.");
            return;
        }

        if (head == tail){
            System.out.println("Dr. " + head.doctor.name);
            return;
        }

        do { 
           System.out.println("Dr. " + current.doctor.name + " ---> " + "Dr. " + current.next.doctor.name);
           
           current = current.next;
        } while (current != head);
    }

    String getNextDoctor(){

        if (head == null) {
            System.out.println("No Doctor is currently on duty");
            return null;
        }

        String currentDoctor = turn.doctor.name;
        turn = turn.next;
        return currentDoctor;
    }

    void removeDoctor(String name){
        NodeForCLL current = head;

        if (head == null) {
            System.out.println("No Doctors on duty.");
            return;
        }

        if (head == tail && head.doctor.name.equals(name)){
            System.out.println("Dr. " + head.doctor.name + " has been removed. No Doctors are on active duty.");

            head = null;
            tail = null;
            turn = null;
            return;
        }

        if (head.doctor.name.equals(name)){
            System.out.println("Dr. " + head.doctor.name + " has been removed.");
            if (turn == head){
                turn = turn.next;
            }
            head = head.next;
            tail.next = head;
            return;
        }

        while (current.next != head) {
        if (current.next.doctor.name.equals(name)) {
            System.out.println("Dr. " + current.next.doctor.name + " has been removed.");
            
            if (turn == current.next) {
                turn = turn.next;
            }

            if (current.next == tail) {
                tail = current;
            }

            current.next = current.next.next;
            return;
        }
        current = current.next;
    }


    System.out.println("Dr. " + name + " not found.");

    }
}

class NodeForDLL {
    Patient patient;
    String doctorName;
    NodeForDLL next;
    NodeForDLL prev;

    public NodeForDLL(Patient patient, String doctorName){
        this.patient = patient;
        this.doctorName = doctorName;
        this.next = null;
        this.prev = null;
    }
}

class TreatmentHistory {
    NodeForDLL head;
    NodeForDLL tail;

    void addRecord(Patient patient, String doctorName) {
        NodeForDLL newNode = new NodeForDLL(patient, doctorName);
        System.out.println("Added Treatment Record ---> Patient: " + newNode.patient.name + " is treated by Doctor: " + newNode.doctorName);

        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void displayHistoryOldToNew(){
        NodeForDLL current = head;
        if (head == null) {
        System.out.println("Treatment history is empty.");
        return;
        }
        while(current != null){
            System.out.println(current.patient.name + " ---> " + current.doctorName);
            current = current.next;
        }
    }

    void displayHistoryNewtoOld(){
        NodeForDLL current = tail;
        if (tail == null) {
            System.out.println("Treatment history is empty.");
            return;
        }
        while(current != null){
            System.out.println(current.patient.name + " ---> " + current.doctorName);
            current = current.prev;
        }
    }

    void sortHistoryAlphabetical() {
    if (head == null) {
        System.out.println("Treatment history is empty.");
        return; 
    }

    NodeForDLL current = head;

    while (current != null && current.next != null) {
        NodeForDLL minNode = current;
        NodeForDLL checker = current.next;

        while (checker != null) {
            if (checker.patient.name.compareToIgnoreCase(minNode.patient.name) < 0) {
                minNode = checker; 
            }
            checker = checker.next;
        }

        if (minNode != current) {
            Patient tempPatient = current.patient;
            current.patient = minNode.patient;
            minNode.patient = tempPatient;

            String tempDoctor = current.doctorName;
            current.doctorName = minNode.doctorName;
            minNode.doctorName = tempDoctor;
        }

        current = current.next;
    }

    NodeForDLL temp = head;
    while (temp != null) {
        System.out.println(temp.patient.name + " ---> " + temp.doctorName);
        temp = temp.next;
    }
}
}

public class ClinicSystem{
    static WaitingList waitingList = new WaitingList();
    static DoctorRing doctorRing = new DoctorRing();
    static TreatmentHistory treatmentHistory = new TreatmentHistory();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while(choice != 0) {
            System.out.println("""
                =====CITY CLINIC SYSTEM=====
                1. Register new patient
                2. Show waiting list
                3. Sort waiting list by severity
                4. Remove patient by ID (left without treatment)
                5. Add Doctor
                6. Remove Doctor
                7. Show Doctors
                8. Treat next patient
                9. Show treatment history (first to last)
                10. Show treatment history (last to first)
                11. Sort treatment history by patient name
                0. Exit
            """);

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    Patient newPatient = createPatient(scanner);
                    waitingList.addPatient(newPatient);
                    break;

                case 2:
                    waitingList.displaylist();
                    break;

                case 3:
                    waitingList.sortBySeverity();
                    System.out.println("Waiting list sorted by Patient severity.");
                    break;
                
                case 4:
                    System.out.println("Enter Patient ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    scanner.nextLine();
                    waitingList.removePatient(idToRemove);
                    break;

                case 5:
                    Doctor newDoctor = createDoctor(scanner);
                    doctorRing.addDoctor(newDoctor);
                    break;

                case 6: 
                    System.out.println("Enter Doctors name to remove: ");
                    String doctorToRemove = scanner.nextLine();
                    doctorRing.removeDoctor(doctorToRemove);
                    break;

                case 7:
                    doctorRing.displayDoctors();
                    break;

                case 8:
                    treatPatient();
                    break;

                case 9:
                    treatmentHistory.displayHistoryOldToNew();
                    break;

                case 10:
                    treatmentHistory.displayHistoryNewtoOld();
                    break;

                case 11:
                    treatmentHistory.sortHistoryAlphabetical();
                    break;

                case 0:
                    System.out.println("Exiting City Clinic System.");
                    break;
                
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    static Patient createPatient(Scanner scanner){
        System.out.println("Enter the Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the Patients name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the Patients age: ");
        int age = scanner.nextInt();

        System.out.println("Enter the Patients severity(1-5): ");
        int severity = scanner.nextInt();

        while (severity < 1 || severity > 5) {
            System.out.println("Invalid severity. Please enter a value between 1 and 5: ");
            severity = scanner.nextInt();
        }
        scanner.nextLine(); 

        Patient patient = new Patient(id, name, age, severity);

        System.out.println("Created new patient| " + "ID: " + patient.id + ", Name: " + patient.name + ", Age: " + patient.age + ", Severity: " + patient.severity);

        return patient;
    }

    static Doctor createDoctor(Scanner scanner){
        System.out.println("Enter the name of the Doctor: ");
        String name = scanner.nextLine();

        Doctor doctor = new Doctor(name);

        System.out.println("Added Doctor: " + doctor.name);

        return doctor;
    }
    
    static void treatPatient() {
        if (waitingList.head == null && doctorRing.head == null) {
            System.out.println("No Patients currently waiting, and no Doctors currently on duty.");
            return;
        }
        if (waitingList.head == null) {
            System.out.println("Waiting list is empty.");
            return;
        }

        if (doctorRing.head == null) {
            System.out.println("No Doctor is currently on duty.");
            return;
        }

        Patient patient = waitingList.removeFirst();
        String doctorName = doctorRing.getNextDoctor();

        treatmentHistory.addRecord(patient, doctorName);
    } 

}