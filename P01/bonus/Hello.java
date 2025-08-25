package bonus;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for( int i = 0; i < 5; i++) {
            System.out.println("What is your name?");
            String name = sc.nextLine();
            System.out.println("Hello " + name);
        }
    }
}
