package P05.src;

import java.util.Objects;

public class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
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
}
