package vue;

import controler.ChessGameControlerModelVue;
import tools.data.Coord;
import tools.data.Couleur;

import javax.swing.*;

public class ChessGridGUIListener extends ChessGridGUI implements ChessGameControlerModelVue{



    @Override
    public void setGridPanel(JLayeredPane panel) {

    }

    @Override
    public boolean isPlayerOk(Couleur pieceToMoveCouleur) {
        return false;
    }

    @Override
    public void actionsWhenPieceIsSelectedOnGUI(Coord pieceToMoveCoord, Couleur pieceToMoveCouleur) {

    }

    @Override
    public void actionsWhenPieceIsMovedOnGUI(Coord pieceToMoveCoord, Coord targetCoord) {

    }

}
