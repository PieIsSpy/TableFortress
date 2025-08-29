package main.com.pieisspy.tablefortress.model.components;

import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public record PieceInfo(PieceType type, int curHealth, int maxHealth, Cooldown cooldown) {
}
