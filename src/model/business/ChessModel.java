package model.business;

import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public class ChessModel implements ChessGameModel {

    private Couleur colorCurrentPlayer;
    private ChessImplementor chessImplementor;

    public ChessModel(){
        this.colorCurrentPlayer = BoardGameConfig.getBeginColor();
        this.chessImplementor = new ChessImplementor();
    }

    @Override
    public String toString() {
        return "ChessModel{" +
                "colorCurrentPlayer=" + colorCurrentPlayer +
                ", chessImplementor=" + chessImplementor +
                '}';
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        return this.colorCurrentPlayer;
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
        if (this.chessImplementor.checkMoveOk(new Coord(xInit, yInit), new Coord(xFinal, yFinal))) {
            System.out.println("moved");
            return ActionType.MOVE;
        } else {
            return ActionType.ILLEGAL;
        }
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
