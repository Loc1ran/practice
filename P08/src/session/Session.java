package P08.src.session;

import P08.src.people.Student;
import P08.src.people.Tutor;

import java.util.ArrayList;
import java.util.List;

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
