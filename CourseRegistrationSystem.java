import java.util.Scanner;

public class CourseRegistrationSystem{
    static final int MAX_COURSES = 10;
    static final int MAX_STUDENTS = 100;

    static String[] courseCodes = new String[MAX_COURSES];
    static String[] courseTitles = new String[MAX_COURSES];
    static int[] courseCapacities = new int[MAX_COURSES];
    static int[] availableSlots = new int[MAX_COURSES];

    static String[] studentIDs = new String[MAX_STUDENTS];
    static String[] studentNames = new String[MAX_STUDENTS];
    static String[][] registeredCourses = new String[MAX_STUDENTS][MAX_COURSES];

    static int numCourses = 0;
    static int numStudents = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Course Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. Register Student");
            System.out.println("3. View Course Listing");
            System.out.println("4. Register for Course");
            System.out.println("5. Drop Course");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    registerStudent(scanner);
                    break;
                case 3:
                    displayCourseListing();
                    break;
                case 4:
                    registerForCourse(scanner);
                    break;
                case 5:
                    dropCourse(scanner);
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    static void addCourse(Scanner scanner) {
        if (numCourses < MAX_COURSES) {
            System.out.print("Enter course code: ");
            courseCodes[numCourses] = scanner.next();
            System.out.print("Enter course title: ");
            courseTitles[numCourses] = scanner.next();
            System.out.print("Enter course capacity: ");
            courseCapacities[numCourses] = scanner.nextInt();
            availableSlots[numCourses] = courseCapacities[numCourses];
            numCourses++;
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Maximum courses reached. Cannot add more courses.");
        }
    }

    static void registerStudent(Scanner scanner) {
        if (numStudents < MAX_STUDENTS) {
            System.out.print("Enter student ID: ");
            studentIDs[numStudents] = scanner.next();
            System.out.print("Enter student name: ");
            studentNames[numStudents] = scanner.next();
            numStudents++;
            System.out.println("Student registered successfully.");
        } else {
            System.out.println("Maximum students reached. Cannot register more students.");
        }
    }

    static void displayCourseListing() {
        if (numCourses == 0) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Course Listing:");
            System.out.println("Course Code\tTitle\tCapacity\tAvailable Slots");
            for (int i = 0; i < numCourses; i++) {
                System.out.println(courseCodes[i] + "\t" + courseTitles[i] + "\t" +
                        courseCapacities[i] + "\t" + availableSlots[i]);
            }
        }
    }

    static void registerForCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.next();
        int studentIndex = -1;
        for (int i = 0; i < numStudents; i++) {
            if (studentIDs[i].equals(studentID)) {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code to register: ");
        String courseCode = scanner.next();
        int courseIndex = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courseCodes[i].equals(courseCode)) {
                courseIndex = i;
                break;
            }
        }
        if (courseIndex == -1) {
            System.out.println("Course not found.");
            return;
        }

        if (availableSlots[courseIndex] > 0) {
            registeredCourses[studentIndex][courseIndex] = courseCode;
            availableSlots[courseIndex]--;
            System.out.println("Course registration successful.");
        } else {
            System.out.println("Course is full. Cannot register.");
        }
    }

    static void dropCourse(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String studentID = scanner.next();
        int studentIndex = -1;
        for (int i = 0; i < numStudents; i++) {
            if (studentIDs[i].equals(studentID)) {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code to drop: ");
        String courseCode = scanner.next();
        int courseIndex = -1;
        for (int i = 0; i < numCourses; i++) {
            if (registeredCourses[studentIndex][i] != null && registeredCourses[studentIndex][i].equals(courseCode)) {
                courseIndex = i;
                break;
            }
        }
        if (courseIndex == -1) {
            System.out.println("Course not found in student's registration.");
            return;
        }

        registeredCourses[studentIndex][courseIndex] = null;
        availableSlots[courseIndex]++;
        System.out.println("Course dropped successfully.");
    }
}