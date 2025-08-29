package main.com.pieisspy.tablefortress.model.logics;

import main.com.pieisspy.tablefortress.model.components.PieceHolder;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

import java.util.ArrayList;

public class TurnHandler {
    public static void sortPrecedence(PieceHolder turns) {
        turns.precedenceSort();
    }

    public static void sortCooldown(PieceHolder cooldowns) {
        cooldowns.cooldownSort();
    }

    public static void placeOnCooldown(PieceHolder turns, PieceHolder cooldown) {
        Piece temp = turns.getHolder().getFirst();

        if (temp != null && temp.getCooldown().getCooldown() > 0) {
            turns.getHolder().removeFirst();
            cooldown.getHolder().add(temp);
            sortCooldown(cooldown);
        }
    }

    public static void removeCooldown(PieceHolder turns, PieceHolder cooldown) {
        Piece temp;
        ArrayList<Piece> turnHolder = turns.getHolder();
        ArrayList<Piece> cooldownHolder = cooldown.getHolder();

        while (!cooldownHolder.isEmpty() && cooldownHolder.getFirst().getCooldown().getCounter() < 1) {
            temp = cooldownHolder.getFirst();
            cooldownHolder.removeFirst();
            turnHolder.add(temp);
        }
    }

    public static void decrementCooldowns(PieceHolder cooldown) {
        for (Piece p : cooldown.getHolder())
            p.getCooldown().decrementCounter();
    }

    public static void rotateTurns(PieceHolder turns) {
        Piece temp;
        temp = turns.getHolder().getFirst();

        if (temp != null) {
            turns.getHolder().removeFirst();
            turns.getHolder().add(temp);
        }
    }

    public static void removeDeadPieces(PieceHolder turns, PieceHolder cooldown) {
        turns.getHolder().removeIf(p -> !p.isAlive());
        cooldown.getHolder().removeIf(p -> !p.isAlive());
    }
}
