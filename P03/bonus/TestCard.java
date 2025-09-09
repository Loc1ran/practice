package P03.bonus;

public class TestCard {
    public static void main(String[] args) {
        System.out.println("Test 1");
            String term = "Algorithm";
            String definition = "A procedure for solving a specific problem, expressed as an ordered set of actions";
            Card card = new Card(term, definition);

            if (card.toString().equals(definition)){
                System.out.println("Matched Definition");
            }else{
                System.out.println("Not Matched Definition");
            }
            if (card.attempt(term)){
                System.out.println("Attempt working");
            }else{
                System.out.println("Attempt not working");
            }
            if (card.getTerm().equals(term)){
                System.out.println("getTerm working");
            }else{
                System.out.println("getTerm not working");
            }

        System.out.println("Test 2");
            if (card.attempt("aLgoritHM")){
                System.out.println("Case insensitive working");
            }else {
                System.out.println("Case insensitive not working");
            }


        System.out.println("Test 3");
        try {
            Card card1 = new Card("", "");

        }catch (Exception e){
            System.out.println("Term or Definition cant be empty" + e.getMessage());
        }

        System.out.println("Test 4");
        try {
            Card card2 = new Card(null, "abcdef");

        }catch (Exception e){
            System.out.println("Term or Definition cant be empty" + e.getMessage());
        }
    }
}
