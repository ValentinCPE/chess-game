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
        boolean isMoveOK = true;
        if (piece.getCouleur() == Couleur.BLANC && piece.getX() == 6) {
            if (piece.getX() == 6) {
                isMoveOK = targetCoord.getX() + 2 == piece.getX() && targetCoord.getY() == piece.getY();
            } else {
                isMoveOK = targetCoord.getX() + 1 == piece.getX() && targetCoord.getY() == piece.getY();
            }
        } else {
            if (piece.getX() == 1) {
                isMoveOK = targetCoord.getX() + 2 == piece.getX() && targetCoord.getY() == piece.getY();
            } else {
                isMoveOK = targetCoord.getX() + 1 == piece.getX() && targetCoord.getY() == piece.getY();
            }
        }
        System.out.println("is move ok ? " + isMoveOK);
        return isMoveOK;
    }

    @Override
    public void getMoveItinary() {

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
