package P05.src;

public class TestRating {
    public static void main(String[] args) {
        Rating rating1 = new Rating(1, null);
        if (rating1.getStars() == 1 && rating1.toString().equals("★☆☆☆☆")) {
            System.out.println();
        } else {
            System.out.println("Test 1 failed");
        }

        Rating rating2 = new Rating(2, null);
        if (rating2.getStars() == 2 && rating2.toString().equals("★★☆☆☆")) {
            System.out.println();
        } else {
            System.out.println("Test 2 failed");
        }

        Rating rating3 = new Rating(3, null);
        if (rating3.getStars() == 3 && rating3.toString().equals("★★★☆☆")) {
            System.out.println();
        } else {
            System.out.println("Test 3 failed");
        }

        Rating rating4 = new Rating(4, null);
        if (rating4.getStars() == 4 && rating4.toString().equals("★★★★☆")) {
            System.out.println();
        } else {
            System.out.println("Test 4 failed");
        }


        Rating rating5 = new Rating(5, null);
        if (rating5.getStars() == 5 && rating5.toString().equals("★★★★★")) {
            System.out.println();
        } else {
            System.out.println("Test 5 failed");
        }

        Comment review = new Comment("Great product!", new Person("Loc", "loc@abc.com"), null);
        Rating ratingWithReview = new Rating(5, review);
        if (ratingWithReview.getReview() == review) {
            System.out.println();
        } else {
            System.out.println("Test 6 failed");
        }
    }
}
