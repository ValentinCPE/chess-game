package controler.controlerLocal;

import controler.ChessGameControlerModelVue;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import model.business.ChessGameModel;
import tools.data.Coord;
import tools.data.Couleur;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class ChessControlerLocal implements ChessGameControlerModelVue {

    private ChessGameModel chessGameModel;

    public ChessControlerLocal(ChessGameModel chessModelObs){
        this.chessGameModel = chessModelObs;
    }

    @Override
    public void setGridPanel(JLayeredPane panel) {

    }

    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
        return (chessGameModel.getColorCurrentPlayer() == pieceToMoveCouleur);
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord, Couleur pieceToMoveCouleur) {
       // TODO : déplacement ici ou dans chessGridGUI avec appel à une méthode
    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {

    }
}
