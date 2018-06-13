package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.ArrayList;
import java.util.List;

public class Fou extends AbstractPiece {

    public Fou(Couleur col, Coord coord) {
        super("Fou", coord, col);
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
        return ActionType.MOVE;
    }

    @Override
    public boolean catchPiece() {
        return false;
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        return Math.abs(xFinal - this.getX()) == Math.abs(yFinal - this.getY());
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        switch (type) {
            case MOVE:
                return isAlgoMoveOk(xFinal, yFinal);
            default:
                return false;
        }
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        int x = this.getX();
        int y = this.getY();
        List<Coord> l = new ArrayList<>();
        while (x != xFinal && y != yFinal) {
            x = prepareCoordinate(x, xFinal);
            y = prepareCoordinate(y, yFinal);
            l.add(new Coord(x, y));
        }
        return l;
    }

    private int prepareCoordinate(int cInit, int cFinal) {
        if (cInit < cFinal) {
            return cInit++;
        } else {
            return cInit--;
        }
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
