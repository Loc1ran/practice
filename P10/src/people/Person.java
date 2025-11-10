package P10.src.people;

import P10.src.rating.Rateable;
import P10.src.rating.Rating;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Person implements Rateable {
    private String name;
    private String email;
    private List<Rating> ratings;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        ratings = new ArrayList<>();
    }

    public Person(Scanner in){
        this.name = in.nextLine();
        this.email = in.nextLine();
    }

    public void save(PrintStream out){
        out.println(name);
        out.println(email);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return this.name + " (" + this.email +")";
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;

        return this.name.equals(person.name) && this.email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    @Override
    public double getAverageRating() {
        double avgRating = 0;
        for (Rating rating : ratings) {
            avgRating += rating.getStars();
        }
        return avgRating/ratings.size();
    }

    @Override
    public Rating[] getRatings() {
        return ratings.toArray(new Rating[0]);
    }
}
