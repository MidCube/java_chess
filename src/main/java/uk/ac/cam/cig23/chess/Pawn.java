package uk.ac.cam.cig23.chess;

import java.util.ArrayList;
import java.util.List;

import static uk.ac.cam.cig23.chess.PieceColor.BLACK;
import static uk.ac.cam.cig23.chess.PieceColor.WHITE;
import static uk.ac.cam.cig23.chess.Position.Rank.SEVEN;
import static uk.ac.cam.cig23.chess.Position.Rank.TWO;

public class Pawn extends Piece {

    public final int value = 1;
    private final char name;

    public Pawn(Position piecePosition, PieceColor pieceColor, Board board) {
        super(piecePosition,pieceColor,board);
        this.name = 'P';
    }

    public List<Position> validNextPositions() {
        List<Position> nextPositions = new ArrayList<>();
        int upDir = (pieceColor == WHITE ? 1 : -1);

        // move up by one
        addPawnPositionIfValid(upDir, 0, false, nextPositions);

        // move up left and right
        addPawnPositionIfValid(upDir, -1, true, nextPositions);
        addPawnPositionIfValid(upDir, 1, true, nextPositions);

        // move up two if on their home row
        if (position().getRank() == (colour() == BLACK ? SEVEN : TWO)) {
            addPawnPositionIfValid(upDir + upDir, 0, false, nextPositions);
        }

        return nextPositions;
    }

    private void addPawnPositionIfValid(
            int deltaRank,
            int deltaFile,
            boolean allowIfOccupiedByOpponent,
            List<Position> nextPositions) {

        Position movePosition = position().getPosAtDelta(deltaRank, deltaFile);

        if (movePosition != null) {
            boolean movePosOccupied = board().positionOccupied(movePosition);
            // the up left and right cases
            if (allowIfOccupiedByOpponent
                    && movePosOccupied
                    && board().atPosition(movePosition).colour() != colour()) {
                nextPositions.add(movePosition);
            }
            // the "up straight ahead" and "up straight ahead two" moves.
            else if (!allowIfOccupiedByOpponent && !movePosOccupied) {
                nextPositions.add(movePosition);
            }
        }
    }

    public char icon() {

        boolean colourSwitch = pieceColor == PieceColor.BLACK;
        return colourSwitch ? '♟' : '♙';
    }

    public int value() {
        return value;
    }

    public char name() {
        return name;
    }
}

