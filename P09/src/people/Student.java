package P09.src.people;

import P09.src.session.Course;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends Person {
    private static int nextStudentID = 0;
    private int studentID;
    private List<Course> courses;

    public Student(String name, String email) {
        super(email, name);
        studentID = nextStudentID++;
        courses = new ArrayList<>();
    }

    public Student(Scanner in){
        super(in);
        nextStudentID = in.nextInt(); in.nextLine();
        this.studentID = in.nextInt(); in.nextLine();
        int size = in.nextInt(); in.nextLine();
        courses = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            courses.add(new Course(in));
        }
    }

    @Override
    public void save(PrintStream out) {
        super.save(out);
        out.println(nextStudentID);
        out.println(studentID);
        out.println(courses.size());

        for (Course course : courses) {
            course.save(out);
        }
    }

    public void addCourse (Course course) {
        courses.add(course);
    }

    public Course[] getCourses() {
        return courses.toArray(new Course[0]);
    }

    @Override
    public String toString() {
        String superClass = super.toString();

        return superClass.replace(")", ", #" + studentID + ")");
    }
}
