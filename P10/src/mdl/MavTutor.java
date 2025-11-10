package P10.src.mdl;

import P10.src.menu.Menu;
import P10.src.menu.MenuItem;
import P10.src.people.Person;
import P10.src.people.Student;
import P10.src.people.Tutor;
import P10.src.rating.Comment;
import P10.src.rating.Rateable;
import P10.src.rating.Rating;
import P10.src.session.Course;
import P10.src.session.Session;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MavTutor {
    private final Menu menu;
    private List view;
    private File file;
    private final List<Course> courses;
    private final List<Student> students;
    private final List<Tutor> tutors;
    private final List<Session> sessions;

    public MavTutor(){
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.tutors = new ArrayList<>();
        this.sessions = new ArrayList<>();
        file = null;
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
                new MenuItem("Create Session", this::newSession),
                new MenuItem("New Data", this::newz),
                new MenuItem("Saving File", this::save),
                new MenuItem("Saving File As", this::saveAs),
                new MenuItem("Open File", this::open),
                new MenuItem("Review Students", () -> review(students)),
                new MenuItem("Review Tutors", () -> review(tutors)),
                new MenuItem("Review Sessions", () -> review(sessions))
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

    private void newz(){
        courses.clear();
        students.clear();
        tutors.clear();
        sessions.clear();
        file = null;
        menu.result.append("\nNew Data Clear.");
    }

    private void save() {
        if (file == null) {
            Menu.selectFile("Select a file to save", file, null);
        }

        try(PrintStream out = new PrintStream(file)) {

            out.println(courses.size());
            for ( Course c : courses ){
                c.save(out);
            }

            out.println(students.size());
            for ( Student s : students ){
                s.save(out);
            }

            out.println(tutors.size());
            for ( Tutor t : tutors ){
                t.save(out);
            }

            out.println(sessions.size());
            for ( Session s : sessions ){
                s.save(out);
            }

            menu.result.append("\nNew Data Saved.");

        } catch (FileNotFoundException e) {
            menu.result.append("\nError saving file: ").append(e.getMessage());
        }

    }

    private void saveAs(){
        file = null;
        save();
    }

    private void open(){
        File selectedFile = Menu.selectFile("Select a File", file, null);

        if (selectedFile != null) {
            try(Scanner in = new Scanner(selectedFile)) {
                newz();

                int courseS = in.nextInt(); in.nextLine();
                for (int i = 0; i <courseS; i++) {
                    courses.add(new Course(in));
                }

                int studentS = in.nextInt(); in.nextLine();
                for (int i = 0; i <studentS; i++) {
                    students.add(new Student(in));
                }

                int tutorS = in.nextInt(); in.nextLine();
                for (int i = 0; i < tutorS; i++) {
                    tutors.add(new Tutor(in));
                }

                int sessionS = in.nextInt(); in.nextLine();
                for (int i = 0; i < sessionS; i++) {
                    sessions.add(new Session(in));
                }

                menu.result.append("\n File open successfully");
            } catch (FileNotFoundException e) {
                menu.result.append("\nError open file: ").append(e.getMessage());
            }
        }
    }

    private void review(List<? extends Rateable> list){
        Integer i = Menu.selectItemFromList("Select item to check average rating", list);

        Rateable rate = list.get(i);
        menu.result.append("\nAverage Rating: ").append(rate.getAverageRating());

        Person person = login();

        if (person != null) {
            String addRating = Menu.getString("Would you like to add a new rating? (y/n): ");

            if (addRating.equalsIgnoreCase("y")) {
                int stars = Menu.getInt("Add Rating Stars (1 to 5)");
                String text = Menu.getString("Add Comment");
                Comment comment = new Comment(text, person, null);

                Rating rating = new Rating(stars, comment);

                rate.addRating(rating);
                menu.result.append("\nRating added");
            }
        }

        Integer selectRating =  Menu.selectItemFromArray("Select Rating", rate.getRatings());

        Rating selectedRating = rate.getRatings()[selectRating];
        Comment comment = selectedRating.getReview();

    }

    private Person login(){
        String[] login = new String[] {"Login as Tutor", "Login as Student"};
        Integer loginChoice = Menu.selectItemFromArray("Select Login Prefer", login);

        if (loginChoice == null || loginChoice >= login.length ) {
            menu.result.append("\nInvalid Login Prefer");
            return null;
        }

        if (loginChoice == 0){
            if (tutors.isEmpty()) {
                menu.result.append("\nNo tutors available.");
                return null;
            }
            Integer tutor = Menu.selectItemFromList("Select Tutor", tutors);
            if (tutor == null || tutor >= tutors.size()) {
                menu.result.append("\nInvalid Tutor Index");
                return null;
            }
            return tutors.get(tutor);
        } else{
            if (students.isEmpty()) {
                menu.result.append("\nNo students available.");
                return null;
            }
            Integer student = Menu.selectItemFromList("Select Student", students);
            if (student == null ||  student >= students.size()) {
                menu.result.append("\nInvalid Student Index");
                return null;
            }
            return students.get(student);
        }
    }

    private static void printIndented(String multiline, int level) {
        String[] strings = multiline.split("\n");
        for(String s : strings)
            System.out.println("  ".repeat(level) + s);
    }

    private static void printExpandedComments(Comment c, int level) {
        printIndented(c.toString(), level);
        System.out.println("\n");
        for(int i=0; i<c.numReplies(); ++i)
            printExpandedComments(c.getReply(i), level+1);
    }
}
