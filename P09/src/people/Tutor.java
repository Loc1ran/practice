package P09.src.people;

import P09.src.session.Course;

import java.io.PrintStream;
import java.util.Scanner;

public class Tutor extends Person {
    private final String bio;
    private final String ssn;
    private final Course course;

    public Tutor(String name, String email, String ssn, String bio, Course course) {
        super(name, email);
        int ssnNum = Integer.parseInt(ssn.replaceAll("_",""));
        if( ssnNum < 001010001 || ssnNum > 999999999 ){
            throw new IllegalArgumentException("ssn is not valid");
        }
        this.bio = bio;
        this.ssn = ssn;
        this.course = course;
    }

    public Tutor(Scanner in){
        super(in);
        this.bio = in.nextLine();
        this.ssn = in.nextLine();
        this.course = new Course(in);
    }

    @Override
    public void save(PrintStream out){
        super.save(out);

        out.println(bio);
        out.println(ssn);
        course.save(out);

    }

    public int getSSN(){
        return Integer.parseInt(ssn.replaceAll("_",""));
    }

    public String getBio(){
        return bio;
    }

    public Course getCourse(){
        return course;
    }


}
