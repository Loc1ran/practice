package P07.src.people;

import P07.src.session.Course;

public class Tutor extends Person {
    private String bio;
    private String ssn;
    private Course course;

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
