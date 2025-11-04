package P09.src.session;

import P09.src.people.Student;
import P09.src.people.Tutor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Tutoring Session
 * @author Loc Tran
 * @version 1.0
 * @since 1.0
 */
public class Session {
    private Course course;
    private DateRange dates;
    private Tutor tutor;
    private List<Student> students;

    /**
     * Constructor
     * @param course the course
     * @param tutor the tutor
     */
    public Session(Course course, Tutor tutor) {
        this.course = course;
        this.tutor = tutor;
        this.students = new ArrayList<>();
    }

    public Session(Scanner in){
        this.course = new Course(in);
        this.dates = new DateRange(in);
        this.tutor = new Tutor(in);
        int size = in.nextInt(); in.nextLine();
        this.students = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            this.students.add(new Student(in));
        }

    }

    public void save(PrintStream out){
        course.save(out);
        dates.save(out);
        tutor.save(out);

        out.println(students.size());

        for (Student student : students) {
            student.save(out);
        }
    }

    /**
     * Set schedule for the session by time
     * @param date YYYY:MM:DD
     * @param startTime HH:MM
     * @param endTime HH:MM
     */
    public void setSchedule(String date, String startTime, String endTime){
        this.dates = new DateRange(date, startTime, endTime);
    }

    /**
     * Set schedule for the session by duration
     * @param date YYYY:MM:DD
     * @param startTime HH:MM
     * @param duration MM
     */
    public void setSchedule(String date, String startTime, long duration){
        this.dates = new DateRange(date, startTime, duration);
    }

    /**
     * add students to the session
     * @param student the student
     */
    public void addStudent(Student student){
        students.add(student);
    }

    /**
     * Return String representation of Session
     * @return return the string formatted of the Session
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Session on ").append(course).append(" at ").append(dates).append("\n");
        sb.append(" Tutor: ").append(tutor).append("\n");
        sb.append(" Students: ");
        for (int i = 0; i < students.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(students.get(i));
        }
        return sb.toString();
    }


}
