package model.business;

import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class ChessModel implements ChessGameModel {

    @Override
    public Couleur getColorCurrentPlayer() {
        return null;
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        return null;
    }

    @Override
    public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
        return null;
    }

    @Override
    public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
        return null;
    }

    @Override
    public boolean pawnPromotion(int x, int y, String promotionType) {
        return false;
    }

    @Override
    public boolean isEnd() {
        return false;
    }

}
