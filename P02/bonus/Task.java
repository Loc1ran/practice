package P02.bonus;

import java.util.Scanner;

public class Task {
    public static void main(String args[]){
        int length = args.length < 1 ? 5 : Integer.parseInt(args[0]);

        ItemClass[] list = new ItemClass[length];
        Scanner sc = new Scanner(System.in);

        String task;
        int priority;

        for (int i = 0; i < length; i++) {
            System.out.printf("Task #%d: ", i);
            task = sc.nextLine();
            System.out.print("Priority from 1 (highest) to 5 (lowest): ");
            priority = sc.nextInt();
            sc.nextLine();

            list[i] = new ItemClass(task, priority);
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (list[j].isPriority(i)){
                    System.out.println( list[j].toString());
                }
            }
        }
    }
}
