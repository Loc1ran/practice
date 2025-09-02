package P02.full_credit;
import java.util.Scanner;

class Item{
    public String task;
    public int priority;
    }

public class ToDo {
    public static void main(String[] args){
        int length = args.length < 1 ? 5 : Integer.parseInt(args[0]);

        Item[] list = new Item[length];
        Scanner sc = new Scanner(System.in);

        String task;
        int priority;

        for (int i = 0; i < length; i++) {
            System.out.printf("Task #%d: ", i);
            task = sc.nextLine();
            System.out.print("Priority from 1 (highest) to 5 (lowest): ");
            priority = sc.nextInt();
            sc.nextLine();

            Item item = new Item();
            item.task = task;
            item.priority = priority;
            list[i] = item;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (list[j].priority == i){
                    System.out.printf("%d %s \n", i, list[j].task);
                }
            }

        }
    }
}
