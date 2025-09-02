package P02.bonus;

public class ItemClass {
    private String task;
    private int priority;

    public ItemClass(String task, int priority) {
        this.task = task;
        this.priority = priority;
    }

    public boolean isPriority(int priority) {
        return this.priority == priority;
    }

    public String toString() {
        return priority + " " + task;
    }
}
