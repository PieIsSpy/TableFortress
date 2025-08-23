package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.comparators.PrecedenceComparator;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TurnHandler {
    public void sortPrecedence(ArrayList<Piece> pieces) {
        PrecedenceComparator c = new PrecedenceComparator();
        pieces.sort(c);
    }

    public void placeOnCooldown(Queue<Piece> turns, PriorityQueue<Piece> cooldown) {
        Piece temp = turns.poll();
        if (temp != null)
            cooldown.add(temp);
    }

    public void removeCooldown(Queue<Piece> turns, PriorityQueue<Piece> cooldown) {
        Piece temp;

        while (!cooldown.isEmpty() && cooldown.peek().getCooldown().getCounter() == 0) {
            temp = cooldown.poll();
            turns.add(temp);
        }
    }

    public void rotateTurns(Queue<Piece> turns) {
        Piece temp;
        temp = turns.poll();
        if (temp != null)
            turns.add(temp);
    }
}
