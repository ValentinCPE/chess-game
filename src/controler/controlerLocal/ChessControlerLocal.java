package controler.controlerLocal;

import controler.ChessGameControlerModelVue;
import model.business.ChessGameModel;
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
        /*  Point parentLocation = c.getParent().getLocation();
        System.out.println(parentLocation);
            xAdjustment = parentLocation.x - e.getX();
           yAdjustment = parentLocation.y - e.getY();

            chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
       JLabel chessPiece = (JLabel) c;
       chessPiece.setLocation(e.getX() , e.getY() );
       this.add(chessPiece, JLayeredPane.DRAG_LAYER); */
        // TODO : déplacement ici ou dans chessGridGUI avec appel à une méthode
        this.chessGridGUI.setPieceToMove(pieceToMoveCoord);


    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {
        this.chessGridGUI.movePiece(targetCoord);
    }
}
