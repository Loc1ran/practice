package P03.bonus;

public class Card {
    private String term;
    private String definition;

    public Card(String term, String definition) {
        if ( term == null || term.isEmpty() || definition == null || definition.isEmpty()) {
            throw new IllegalArgumentException("Term and definition cant be null or empty");
        }
        this.term = term;
        this.definition = definition;
    }


    public boolean attempt(String response){
        return term.toUpperCase().equals(response.toUpperCase());
    }

    public String getTerm(){
        return this.term;
    }

    @Override
    public String toString() {
        return this.definition;
    }
}
