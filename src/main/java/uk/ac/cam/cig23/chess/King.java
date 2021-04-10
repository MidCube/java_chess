package uk.ac.cam.cig23.chess;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    public static int KING_VALUE = 10000;
    private final char name = 'K';

    public King(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition,pieceColor,board);
    }

    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        position.getAllDiagonalMoves(1, board(), nextPositions);
        position.getAllStraightMoves(1, board(), nextPositions);
        return nextPositions;
    }

    public char icon() {
        boolean colourSwitch = pieceColor == PieceColor.BLACK;
        return colourSwitch ? '♚' : '♔';
    }

    public int value() {
        return KING_VALUE;
    }

    public char name() {
        return name;
    }
}
