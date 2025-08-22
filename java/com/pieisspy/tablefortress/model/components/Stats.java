package java.com.pieisspy.tablefortress.model.components;

public class Stats {
    public Stats(int h, int ad, int ar, int p, int m) {
        health = h;
        maxHealth = h;
        attackDamage = ad;
        attackRange = ar;
        precedence = p;
        movementRange = m;
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

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int r) {
        attackRange = r;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int p) {
        precedence = p;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public void setMovementRange(int r) {
        movementRange = r;
    }

    private int health;
    private final int maxHealth;
    private int attackDamage;
    private int attackRange;
    private int precedence;
    private int movementRange;
}
