package P07.src.session;

import java.util.Objects;

public class Course {
    private String dept;
    private int number;

    public Course(String dept, int number) {
        if ( dept.length() < 3 || dept.length() > 4){
            throw new InvalidCourseException(dept);
        }

        if (number < 1000 || number > 9999){
            throw new InvalidCourseException(dept, number);
        }
        this.dept = dept;
        this.number = number;
    }

    @Override
    public String toString() {
        return dept + " " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ( o == null || this.getClass() != o.getClass()) return false;

        Course course = (Course) o;
        return number == course.number && dept.equals(course.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dept, number);
    }
}
