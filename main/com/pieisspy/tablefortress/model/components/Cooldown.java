package main.com.pieisspy.tablefortress.model.components;

public class Cooldown {
    public Cooldown(int c) {
        COOLDOWN = c;
        counter = 0;
    }

    public int getCooldown() {
        return COOLDOWN;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int c) {
        counter = c;
    }

    public void decrementCounter() {
        counter--;
    }

    private final int COOLDOWN;
    private int counter;
}
