package model.piece;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.ArrayList;
import java.util.List;

public class Tour extends AbstractPiece {


    public Tour(Couleur col, Coord coord) {
        super("Tour", coord, col);

    }

    @Override
    public boolean isMoveOk(Pieces piece, Coord targetCoord) {
        return false;
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
        return (xFinal == this.getX() && yFinal != this.getY()) || (xFinal != this.getX() && yFinal == this.getY());
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
        List<Coord> l = new ArrayList<>();
        int x = this.getX();
        int y = this.getY();
        while (x != xFinal) {
            if (x < xFinal) {
                x--;
            } else {
                x++;
            }
            l.add(new Coord(x, y));
        }
        while (y != yFinal) {
            if (y < yFinal) {
                y--;
            } else {
                y++;
            }
            l.add(new Coord(x, y));
        }
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
}
