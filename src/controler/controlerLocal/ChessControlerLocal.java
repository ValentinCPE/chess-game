package controler.controlerLocal;

import controler.ChessGameControlerModelVue;
import model.business.ChessGameModel;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import vue.ChessGridGUI;

import javax.swing.*;

public class ChessControlerLocal implements ChessGameControlerModelVue {

    private ChessGameModel chessGameModel;
    private ChessGridGUI chessGridGUI;

    public ChessControlerLocal(ChessGameModel chessModelObs){
        this.chessGameModel = chessModelObs;
    }

    @Override
    public void setGridPanel(JLayeredPane panel) {
        this.chessGridGUI = (ChessGridGUI) panel;
    }

    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
        return (chessGameModel.getColorCurrentPlayer() == pieceToMoveCouleur);
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord, Couleur pieceToMoveCouleur) {
        this.chessGridGUI.setPieceToMove(pieceToMoveCoord);
    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {

        ActionType actionType = this.chessGameModel.move(pieceToMoveCoord.getX(), pieceToMoveCoord.getY(), targetCoord.getX(), targetCoord.getY());

       // this.chessGridGUI.movePiece(targetCoord);

        switch (actionType){

            case UNKNOWN:
                this.chessGridGUI.undoMovePiece(pieceToMoveCoord);

            case ILLEGAL:
                this.chessGridGUI.undoMovePiece(pieceToMoveCoord);

            case MOVE:
                this.chessGridGUI.movePiece(targetCoord);

            case TAKE:

            case PROMOTION:
                this.chessGridGUI.promotePiece(targetCoord,this.chessGridGUI.getPromotionType());

            default:
                System.out.println("DEFAULT");
        }
    }
}
