import java.util.Scanner;

class Course {
    String code;
    String title;
    int capacity;
    int enrolled;

    Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    boolean hasSpace() {
        return enrolled < capacity;
    }
}

class Student {
    String id;
    String name;
    Course[] registeredCourses = new Course[5];
    int count = 0;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void registerCourse(Course course) {
        if (count == registeredCourses.length) {
            System.out.println("You cannot register more courses.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (registeredCourses[i].code.equals(course.code)) {
                System.out.println("Already registered for this course.");
                return;
            }
        }
        if (course.hasSpace()) {
            registeredCourses[count++] = course;
            course.enrolled++;
            System.out.println("Registered for " + course.code);
        } else {
            System.out.println("Course is full.");
        }
    }

    void dropCourse(String code) {
        for (int i = 0; i < count; i++) {
            if (registeredCourses[i].code.equalsIgnoreCase(code)) {
                registeredCourses[i].enrolled--;
                for (int j = i; j < count - 1; j++) {
                    registeredCourses[j] = registeredCourses[j + 1];
                }
                registeredCourses[--count] = null;
                System.out.println("Dropped course " + code);
                return;
            }
        }
        System.out.println("You are not registered in this course.");
    }

    void listCourses() {
        if (count == 0) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Your courses:");
            for (int i = 0; i < count; i++) {
                System.out.println(registeredCourses[i].code + ": " + registeredCourses[i].title);
            }
        }
    }
}

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course[] courses = {
            new Course("CS101", "Intro to CS", 2),
            new Course("MA101", "Calculus I", 3),
            new Course("PH101", "Physics I", 1)
        };

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. List courses");
            System.out.println("2. Register course");
            System.out.println("3. Drop course");
            System.out.println("4. View registered courses");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            if (option == 1) {
                System.out.println("Available courses:");
                for (Course c : courses) {
                    System.out.println(c.code + " - " + c.title + " (Capacity: " + c.capacity + ", Enrolled: " + c.enrolled + ")");
                }
            } else if (option == 2) {
                System.out.print("Enter course code to register: ");
                String code = scanner.nextLine();
                Course c = findCourse(courses, code);
                if (c != null) {
                    student.registerCourse(c);
                } else {
                    System.out.println("Course not found.");
                }
            } else if (option == 3) {
                System.out.print("Enter course code to drop: ");
                String code = scanner.nextLine();
                student.dropCourse(code);
            } else if (option == 4) {
                student.listCourses();
            } else if (option == 5) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    static Course findCourse(Course[] courses, String code) {
        for (Course c : courses) {
            if (c.code.equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }
}
