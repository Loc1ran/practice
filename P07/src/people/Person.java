package P07.src.people;

import P07.src.rating.Rateable;
import P07.src.rating.Rating;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Rateable {
    private String name;
    private String email;
    private List<Rating> ratings;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
        ratings = new ArrayList<>();
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
