package P07.src.people;

import P07.src.session.Course;
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private static int nextStudentID = 0;
    private int studentID;
    private List<Course> courses;

    public Student(String name, String email) {
        super(email, name);
        studentID = nextStudentID++;
        courses = new ArrayList<>();
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
