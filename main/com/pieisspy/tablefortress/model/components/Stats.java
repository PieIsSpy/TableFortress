package main.com.pieisspy.tablefortress.model.components;

public class Stats {
    public Stats(int h, int ad, int p) {
        health = h;
        maxHealth = h;
        attackDamage = ad;
        precedence = p;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h) {
        health = h;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int a) {
        attackDamage = a;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int p) {
        precedence = p;
    }

    private int health;
    private final int maxHealth;
    private int attackDamage;
    private int precedence;
}
