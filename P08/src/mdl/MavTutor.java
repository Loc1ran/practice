package P08.src.mdl;

import P08.src.menu.Menu;
import P08.src.menu.MenuItem;
import P08.src.people.Student;
import P08.src.people.Tutor;
import P08.src.session.Course;
import P08.src.session.Session;

import java.util.ArrayList;
import java.util.List;

public class MavTutor {
    private final Menu menu;
    private List view;
    private final List<Course> courses;
    private final List<Student> students;
    private final List<Tutor> tutors;
    private final List<Session> sessions;

    public MavTutor(){
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.tutors = new ArrayList<>();
        this.sessions = new ArrayList<>();
        view = courses;
        String clearScreen = "\n".repeat(50);
        String title = "MavTutor - Tutoring Management System";
        title += "\n" + "=".repeat(title.length()) + "\n";

        menu = new Menu(
                new Object[] {clearScreen, title},  // pre
                new Object[] {this, "\nSelection? "}, // post
                new MenuItem("Quit", this::quit),
                new MenuItem("View Courses", () -> selectView(courses)),
                new MenuItem("View Tutors", () -> selectView(tutors)),
                new MenuItem("View Students", () -> selectView(students)),
                new MenuItem("View Sessions", () -> selectView(sessions)),
                new MenuItem("Create Course", this::newCourse),
                new MenuItem("Create Tutor", this::newTutor),
                new MenuItem("Create Student", this::newStudent),
                new MenuItem("Create Session", this::newSession)
        );

        menu.run();
    }

    public static void main (String[] args){
        new MavTutor();
    }

    @Override
    public String toString() {
        String title = "";
        if (view == courses) {
            title = "Courses\n--------\n";
        } else if (view == tutors) {
            title = "Tutors\n------\n";
        } else if (view == students) {
            title = "Students\n--------\n";
        } else if (view == sessions) {
            title = "Sessions\n--------\n";
        }

        return Menu.listToString(title, view, '•');
    }

    private void quit(){
        menu.result = null;
    }

    private void selectView(List list){
        view = list;
    }

    private void newCourse(){
        String department = Menu.getString("Department: ");
        int number = Menu.getInt("Course Number: ");

        Course course = new Course(department, number);

        if (!courses.contains(course)) {
            courses.add(course);
            menu.result.append("\nCourse added successfully!");
        } else {
            menu.result.append("\nCourse already exists!");
        }
    }

    private void newTutor(){
        String name = Menu.getString("Tutor Name: ");
        String email = Menu.getString("Tutor Email: ");
        String ssn = Menu.getString("SSN: ");
        String bio = Menu.getString("Bio: ");

        if (courses.isEmpty()) {
            menu.result.append("\nNo courses available. Please create a course first");
            return;
        }

        Integer choice = Menu.selectItemFromList("Select Course", courses);
        if (choice == null) {
            menu.result.append("\nTutor cancelled");
            return;
        }

        Course course = courses.get(choice);

        Tutor tutor = new Tutor(name, email, ssn, bio, course);
        tutors.add(tutor);
        menu.result.append("\nTutor added successfully!");
    }

    private void newStudent(){
        String name = Menu.getString("Student Name: ");
        String email = Menu.getString("Student Email: ");

        Student student = new Student(name, email);

        if (courses.isEmpty()) {
            menu.result.append("\nNo courses available. Please create courses first");
            students.add(student);
            return;
        }

        menu.result.append("\nSelect courses for tutoring (cancel to stop):");
        while (true) {
            Integer choice = Menu.selectItemFromList("Select Course", courses);
            if (choice == null) {
                break;
            }
            Course course = courses.get(choice);
            student.addCourse(course);
            menu.result.append("\nCourse added");
        }

        students.add(student);
        menu.result.append("\nStudent added successfully!");
    }

    private void newSession(){
        if (courses.isEmpty()) {
            menu.result.append("\nNo courses available. Please create courses first");
            return;
        }
        Integer courseIndex = Menu.selectItemFromList("Select Course", courses);
        if (courseIndex == null) {
            menu.result.append("\nSession cancelled");
            return;
        }
        Course course = courses.get(courseIndex);

        if (tutors.isEmpty()) {
            menu.result.append("\nNo tutors available. Please create tutors first.");
            return;
        }
        Integer tutorIndex = Menu.selectItemFromList("Select Tutor", tutors);
        if (tutorIndex == null) {
            menu.result.append("\nSession cancelled");
            return;
        }
        Tutor tutor = tutors.get(tutorIndex);

        Session session = new Session(course, tutor);

        String date = Menu.getString("Date (MM:DD:YY): ");
        String time = Menu.getString("Time: ");
        int duration = Menu.getInt("Duration (minutes): ");
        session.setSchedule(date, time, duration);

        if (!students.isEmpty()) {
            menu.result.append("\nAdd students to session (cancel to stop):");
            while (true) {
                Integer choice = Menu.selectItemFromList("Select Student", students);
                if (choice == null) {
                    break;
                }
                Student student = students.get(choice);
                session.addStudent(student);
                menu.result.append("\nStudent added to session.");
            }
        }

        sessions.add(session);
        menu.result.append("\nSession created successfully!");
    }



}
