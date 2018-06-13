package model.piece;

import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.ArrayList;
import java.util.List;

public class Pion extends AbstractPiece implements MemoriseSonPremierMouvement {

    private boolean hasMoved = false;

    public Pion(Couleur col, Coord coord) {
        super("Pion", coord, col);
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
    public boolean isAlgoMoveOk(int xFinal, int yFinal, ActionType type) {
        switch(type) {
            case MOVE:
                return isAlgoMoveOk(xFinal, yFinal);
            case TAKE:
                return isTakeOk(xFinal, yFinal);
            case PROMOTION:
                return isPromotionOk(xFinal);
            case PRISE_EN_PASSANT:
                return isEnPassantOk(xFinal, yFinal);
            default:
                return false;
        }
    }

    private boolean isPromotionOk(int xFinal) {
        if (this.getCouleur() == Couleur.BLANC) {
            return xFinal == 0;
        } else {
            return xFinal == BoardGameConfig.getNbLigne() - 1;
        }
    }

    private boolean isEnPassantOk(int xFinal, int yFinal) {
        if (this.getCouleur() == Couleur.BLANC) {
            return (xFinal == BoardGameConfig.getBlancEnPassant()) && (isTakeOk(xFinal, yFinal));
        } else {
            return (xFinal == BoardGameConfig.getNoirEnPassant()) && (isTakeOk(xFinal, yFinal));
        }
    }

    @Override
    public boolean isAlgoMoveOk(int xFinal, int yFinal) {
        boolean isOk = true;

        if (hasMoved()) {
            if (this.getCouleur() == Couleur.NOIR) {
                isOk = this.getX() == xFinal && this.getY()+1 == yFinal;
            } else {
                isOk = this.getX() == xFinal && this.getY()-1 == yFinal;
            }
        } else {
            if (this.getCouleur() == Couleur.NOIR) {
                isOk = this.getX() == xFinal && this.getY()+2 == yFinal;
            } else {
                isOk = (this.getX() == xFinal && this.getY()-2 == yFinal) || (this.getX() == xFinal && this.getY()-1 == yFinal);
            }
        }
        return isOk;
    }

    private boolean isTakeOk(int xFinal, int yFinal) {
        if (this.getCouleur() == Couleur.BLANC) {
            return (this.getX() < xFinal) && (Math.abs(this.getY() - yFinal) == 1);
        } else {
            return (this.getX() > xFinal) && (Math.abs(this.getY() - yFinal) == 1);
        }
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
        return hasMoved;
    }
}
