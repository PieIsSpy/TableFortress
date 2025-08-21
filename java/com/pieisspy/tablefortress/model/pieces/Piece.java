package java.com.pieisspy.tablefortress.model.pieces;

import java.com.pieisspy.tablefortress.model.Board;

/** This class represents a Piece unit in a Board.
 *
 * @author PieIsSpy
 * @version 1.0
 */
public abstract class Piece {
    /** This constructor initializes its basic stats, position
     *  and the board reference of the Piece.
     *
     * @param h the health stat of the Piece
     * @param a the attack stat of the Piece
     * @param p the precedence stat of the Piece
     * @param r the row position of the Piece
     * @param c the col position of the Piece
     * @param b the board reference of the Piece
     */
    public Piece(int h, int a, int p, int r, int c, Board b) {
        health = h;
        maxHealth = h;
        attack = a;
        precedence = p;
        row = r;
        col = c;
        BOARD_REFERENCE = b;
    }

    /** This method returns the current health of the Piece.
     *
     * @return the current health of the Piece
     */
    public int getHealth() {
        return health;
    }

    /** This method sets the current health of the Piece.
     *
     * @param h the health of the Piece
     */
    public void setHealth(int h) {
        health = h;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int r) {
        row = r;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int c) {
        col = c;
    }

    private int health;
    private final int maxHealth;
    private int attack;
    private int precedence;
    private int row;
    private int col;
    private final Board BOARD_REFERENCE;
}