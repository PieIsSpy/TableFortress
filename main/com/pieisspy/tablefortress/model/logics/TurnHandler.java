package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.comparators.CooldownComparator;
import main.com.pieisspy.tablefortress.model.comparators.PrecedenceComparator;
import main.com.pieisspy.tablefortress.model.components.PieceHolder;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

import java.util.ArrayList;

public class TurnHandler {
    public void sortPrecedence(ArrayList<Piece> pieces) {
        PrecedenceComparator c = new PrecedenceComparator();
        pieces.sort(c);
    }

    public void sortCooldown(ArrayList<Piece> cooldown) {
        CooldownComparator c = new CooldownComparator();
        cooldown.sort(c);
    }

    public void placeOnCooldown(ArrayList<Piece> turns, ArrayList<Piece> cooldown) {
        Piece temp = turns.getFirst();
        turns.removeFirst();
        if (temp != null) {
            cooldown.add(temp);
            sortCooldown(cooldown);
        }
    }

    public void removeCooldown(ArrayList<Piece> turns, ArrayList<Piece> cooldown) {
        Piece temp;

        while (!cooldown.isEmpty() && cooldown.getFirst().getCooldown().getCounter() < 1) {
            temp = cooldown.getFirst();
            cooldown.removeFirst();
            turns.add(temp);
        }
    }

    public void decrementCooldowns(ArrayList<Piece> cooldown) {
        for (Piece p : cooldown)
            p.getCooldown().decrementCounter();
    }

    public void rotateTurns(ArrayList<Piece> turns) {
        Piece temp;
        temp = turns.getFirst();

        if (temp != null) {
            turns.removeFirst();
            turns.add(temp);
        }
    }

    public void removeDeadPieces(ArrayList<Piece> turns, ArrayList<Piece> cooldown) {
        turns.removeIf(p -> !p.isAlive());
        cooldown.removeIf(p -> !p.isAlive());
    }
}
