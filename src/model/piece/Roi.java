package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.ArrayList;
import java.util.List;

public class Roi extends AbstractPiece implements MemoriseSonPremierMouvement {
    private boolean hasMoved = false;
    public Roi(Couleur col, Coord coord) {
        super("Roi", coord, col);
    }

    @Override
    public int getX() {
        return this.getCoord().getX();
    }

    @Override
    public int getY() {
        return this.getCoord().getY();
    }

    @Override
    public Couleur getCouleur() {
        return this.getCol();
    }

    @Override
    public String getName() {
        return this.getNom();
    }

    @Override
    public ActionType doMove(int xFinal, int yFinal) {
        this.setCoord(new Coord(xFinal, yFinal));
        this.hasMoved = true;
        return ActionType.MOVE;
    }

    @Override
    public boolean catchPiece() {
        return false;
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return (Math.abs(this.getX() - xFinal) <= 1) && (Math.abs(this.getY() - yFinal) <= 1);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        switch(type) {
            case MOVE:
                return isAlgoMoveOk(xFinal, yFinal);
            default:
                return false;
        }s
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        List<Coord> l = new ArrayList<>();
        l.add(new Coord(xFinal, yFinal));
        return l;
    }

    @Override
    public boolean undoLastMove() {
        return false;
    }

    @Override
    public boolean undoLastCatch() {
        return false;
    }

    @Override
    public boolean hasMoved() {
        return this.hasMoved;
    }
}
