package P05.src;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("Loc", "loc@abc.com");

        if (person.toString().equals("Loc " + "(loc@abc.com)")){
            System.out.println();
        }
        else{
            System.out.println("toString method not return connect format");
        }

        if (person.getName().equals("Loc")){
            System.out.println();
        }else{
            System.out.println("name method not return correctly");
        }

        if( person.equals(person)){
            System.out.println();
        }
        else if (!person.equals(null)){
            System.out.println();
        }
        else{
            System.out.println("equals method not return correctly");
        }
    }
}
