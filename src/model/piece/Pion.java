package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class Pion extends AbstractPiece{

    public Pion(Couleur col, Coord coord) {
        super("Pion", coord, col);
    }

    @Override
    public boolean isMoveOk(Pieces piece, Coord targetCoord) {
        return false;
    }

    @Override
    public void getMoveItinary() {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public Couleur getCouleur() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public ActionType doMove(int xFinal, int yFinal) {
        return null;
    }

    @Override
    public boolean catchPiece() {
        return false;
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return false;
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        return false;
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        return null;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public boolean undoLastCatch() {
        return false;
    }
}
