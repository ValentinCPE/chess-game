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
        System.out.println("color "+piece.getCouleur());
        if (piece.getCouleur() == Couleur.BLANC) {
            if (piece.getX() == 6) {
                System.out.println("premier move");
                isMoveOK = targetCoord.getY() + 2 == piece.getY() && targetCoord.getX() == piece.getX();
            } else {
                System.out.println("autre move");
                isMoveOK = targetCoord.getY() + 1 == piece.getY() && targetCoord.getX() == piece.getX();
            }
        } else {
            if (piece.getX() == 1) {
                isMoveOK = targetCoord.getY() + 2 == piece.getY() && targetCoord.getX() == piece.getX();
            } else {
                isMoveOK = targetCoord.getY() + 1 == piece.getY() && targetCoord.getX() == piece.getX();
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
