package P06.src;

import P05.src.Rating;

public interface Rateable {
    void addRating(Rating rating);
    double getAverageRating();
    Rating[] getRatings();
}
