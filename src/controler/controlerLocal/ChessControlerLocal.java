package controler.controlerLocal;

import controler.ChessGameControlerModelVue;
import model.business.ChessGameModel;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import vue.ChessGameGUI;
import vue.ChessGridGUI;

public class ChessControlerLocal implements ChessGameControlerModelVue {

    private ChessGameModel chessGameModel;
    private ChessGridGUI chessGridGUI;

    public ChessControlerLocal(ChessGameModel chessModelObs){
        this.chessGameModel = chessModelObs;
    }

    @Override
    public void setGridPanel(ChessGameGUI panel) {
        this.chessGridGUI = (ChessGridGUI) panel;
    }

    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
        return (chessGameModel.getColorCurrentPlayer() == pieceToMoveCouleur);
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord, Couleur pieceToMoveCouleur) {
        if(this.isPlayerOk(pieceToMoveCouleur)){
            this.chessGridGUI.setPieceToMove(pieceToMoveCoord);
        }
    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {
        ActionType actionType = this.chessGameModel.move(pieceToMoveCoord.getX(), pieceToMoveCoord.getY(), targetCoord.getX(), targetCoord.getY());

        switch (actionType){

            case UNKNOWN:
                this.chessGridGUI.undoMovePiece(pieceToMoveCoord);
                break;

            case ILLEGAL:
                this.chessGridGUI.undoMovePiece(pieceToMoveCoord);
                break;

            case MOVE:
                this.chessGridGUI.movePiece(targetCoord);
                break;

            case TAKE:
                this.chessGridGUI.take(targetCoord);
                break;

            case PROMOTION:
                this.chessGridGUI.promotePiece(targetCoord,this.chessGridGUI.getPromotionType());
                break;

            default:
                System.out.println("DEFAULT");
        }
    }
}
