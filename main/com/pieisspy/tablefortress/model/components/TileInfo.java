package main.com.pieisspy.tablefortress.model.components;

import main.com.pieisspy.tablefortress.model.enumerators.PieceType;

public record TileInfo(PieceType type, boolean isAttackTile, boolean isMovementTile, boolean isCurrent) {
}
