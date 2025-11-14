package P07.src.session;

public class InvalidCourseException extends IllegalArgumentException{
    public InvalidCourseException(String dept) {
        super("Invalid dept in new Course: " + dept);
    }

    public InvalidCourseException(String dept, int numThreads) {
        super("Invalid course numThreadsber " + num + " in new Course: " + dept);
    }
}
