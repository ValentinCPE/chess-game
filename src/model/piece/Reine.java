package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.ArrayList;
import java.util.List;

public class Reine extends AbstractPiece {

    public Reine(Couleur col, Coord coord) {
        super("Reine", coord, col);
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
        int deltaX = Math.abs(this.getX() - xFinal);
        int deltaY = Math.abs(this.getY() - yFinal);
        return  (xFinal != this.getX() && yFinal == this.getY()) ||
                (xFinal == this.getX() && yFinal != this.getY()) ||
                (deltaX == deltaY);
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        switch (type) {
            case MOVE:
                isAlgoMoveOk(xFinal, yFinal);
            default:
                return false;
        }
    }

    @Override
    public List<Coord> getMoveItinerary(int xFinal, int yFinal) {
        List<Coord> l = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();
        if (Math.abs(this.getY() - yFinal) == Math.abs(this.getX() - xFinal)) {
            while (x != xFinal && y != yFinal) {
                x = prepareCoordinate(x, xFinal);
                y = prepareCoordinate(y, yFinal);
                l.add(new Coord(x, y));
            }
        } else if (x == xFinal) {
            while (y != yFinal) {
                y = prepareCoordinate(y, yFinal);
                l.add(new Coord(x, y));
            }
        } else if (y == yFinal) {
            x = prepareCoordinate(x, xFinal);
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
