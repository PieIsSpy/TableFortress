package main.com.pieisspy.tablefortress.model.comparators;

import main.com.pieisspy.tablefortress.model.pieces.Piece;
import java.util.Comparator;

public class CooldownComparator implements Comparator<Piece> {
    public int compare(Piece p1, Piece p2) {
        if (p1.getCooldown().getCounter() > p2.getCooldown().getCounter())
            return 1;
        else if (p1.getCooldown().getCounter() < p2.getCooldown().getCounter())
            return -1;
        else
            return 0;
    }
}
