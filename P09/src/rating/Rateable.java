package P09.src.rating;

public interface Rateable {
    void addRating(Rating rating);
    double getAverageRating();
    Rating[] getRatings();
}