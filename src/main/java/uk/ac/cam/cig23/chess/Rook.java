package uk.ac.cam.cig23.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public final int value = 5;
    private final char name = 'R';

    public Rook(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition,pieceColor,board);
    }

    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        position.getAllStraightMoves(8, board(), nextPositions);
        return nextPositions;
    }

    public char icon() {

        boolean colourSwitch = pieceColor == PieceColor.BLACK;
        return colourSwitch ? '♜' : '♖';
    }

    public int value() {
        return value;
    }

    public char name() {
        return name;
    }
}
