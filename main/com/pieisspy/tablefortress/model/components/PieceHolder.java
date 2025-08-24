package main.com.pieisspy.tablefortress.model.components;

import main.com.pieisspy.tablefortress.model.comparators.CooldownComparator;
import main.com.pieisspy.tablefortress.model.comparators.PrecedenceComparator;
import main.com.pieisspy.tablefortress.model.pieces.Piece;

import java.util.ArrayList;

public class PieceHolder {
    public PieceHolder() {
        Holder = new ArrayList<>();
        cooldownComparator = new CooldownComparator();
        precedenceComparator = new PrecedenceComparator();
    }

    public void precedenceSort() {
        Holder.sort(precedenceComparator);
    }

    public void cooldownSort() {
        Holder.sort(cooldownComparator);
    }

    public ArrayList<Piece> getHolder() {
        return Holder;
    }

    private final ArrayList<Piece> Holder;
    private final CooldownComparator cooldownComparator;
    private final PrecedenceComparator precedenceComparator;
}
