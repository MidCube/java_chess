package uk.ac.cam.cig23.chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public final int value = 3;
    private final char name = 'N';

    public Knight(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition,pieceColor,board);
    }

    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();

        final int[][] nextPosDeltas =
                new int[][] {
                        {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                        {2, 1}, {-2, 1}, {2, -1}, {-2, -1}
                };

        // iterate through all possible positions, getting any valid next positions
        for (int[] posDeltaPair : nextPosDeltas) {
            position.addPosAtDelta(posDeltaPair[0], posDeltaPair[1], board(), nextPositions);
        }

        return nextPositions;
    }

    public char icon() {

        boolean colourSwitch = pieceColor == PieceColor.BLACK;
        return colourSwitch ? '♞' : '♘';
    }

    public int value() {
        return value;
    }

    public char name() {
        return name;
    }
}
