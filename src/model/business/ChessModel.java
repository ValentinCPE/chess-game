package model.business;

import tools.BoardGameConfig;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import tools.data.TextMessage;
import tools.exception.CoordIsNullException;

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
        return this.chessImplementor.getColorForAPiece(x,y);
    }

    @Override
    public List<Coord> getPieceListMoveOK(int xInit, int yInit) {
        return null;
    }

    @Override
    public ActionType move(int xInit, int yInit, int xFinal, int yFinal) {

        try {
            if ((xInit < 0 || xInit >= BoardGameConfig.getNbColonne()) || (yInit < 0 || yInit >= BoardGameConfig.getNbLigne())) {
                throw new CoordIsNullException(TextMessage.INIT_VALUE_POSITION_NOT_CORRECT.toString());
            }

            if ((xFinal < 0 || xFinal >= BoardGameConfig.getNbColonne()) || (yFinal < 0 || yFinal >= BoardGameConfig.getNbLigne())) {
                return ActionType.ILLEGAL;
            }

            if (this.getPieceColor(xInit, yInit) == null || this.getPieceColor(xInit, yInit) != this.colorCurrentPlayer) {
                return ActionType.ILLEGAL;
            }

            Coord coordInit = new Coord(xInit, yInit);
            Coord coordEnd = new Coord(xFinal, yFinal);

            boolean isPieceToEat = this.chessImplementor.isPieceToEatAtPosition(coordEnd);

            if (isPieceToEat) {
                if (this.getPieceColor(xFinal,yFinal) == this.colorCurrentPlayer) {
                    return ActionType.ILLEGAL;
                } else {
                    if(this.chessImplementor.isActionPossible(coordInit,coordEnd,ActionType.TAKE)){
                        this.changePlayer();
                        return ActionType.TAKE;
                    }else{
                        return ActionType.ILLEGAL;
                    }
                }
            } else {
                ActionType actionType = this.chessImplementor.doMove(xInit,yInit,xFinal,yFinal);
                if(actionType == ActionType.MOVE){
                    this.changePlayer();
                }
                return actionType;
            }

        }catch(CoordIsNullException exc){
            System.err.println(exc.getMessage());
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

    private void changePlayer(){
        if(this.colorCurrentPlayer == Couleur.BLANC){
            this.colorCurrentPlayer = Couleur.NOIR;
        }else{
            this.colorCurrentPlayer = Couleur.BLANC;
        }
    }

}
