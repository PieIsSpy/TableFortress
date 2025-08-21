package java.com.pieisspy.tablefortress.model.pieces;

public abstract class Piece {
    public Piece(int h, int a, int p, int r, int c) {
        health = h;
        maxHealth = h;
        attack = a;
        precedence = p;
        row = r;
        col = c;
    }

    private int health;
    private final int maxHealth;
    private int attack;
    private int precedence;
    private int row;
    private int col;
}