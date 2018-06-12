package model.business;

import model.piece.Pieces;
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
        System.out.println(this.chessImplementor.getMap());
        return this.chessImplementor.getMap().get(new Coord(x, y)).getCouleur();
    }

    @Override
    public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
        return null;
    }

    @Override
    public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {
        Coord cInit = new Coord(xInit, yInit);
        Coord cFinal = new Coord(xFinal, yFinal);
        Pieces movingPiece = this.chessImplementor.getMap().get(cInit);
        if (movingPiece.isMoveOk(movingPiece, cFinal)) {
            movingPiece.doMove(xFinal, yFinal);
            return ActionType.MOVE;
        }

        return ActionType.UNKNOWN;
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
