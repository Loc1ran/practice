package P08.src.rating;

public class Rating {
    private int stars;
    private Comment review;

    public Rating(int stars, Comment review) {
        if (stars < 0 || stars > 5) {
            throw new IllegalArgumentException("stars must be between 1 and 5");
        }
        this.stars = stars;
        this.review = review;
    }

    public int getStars() {
        return stars;
    }

    public Comment getReview() {
        return review;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < stars; i++ ){
            sb.append((char) 0x2605);
        }

        for( int j = 0; j < (5 - getStars()); j++ ){
            sb.append((char) 0x2606);
        }

        return sb.toString();
    }
}
