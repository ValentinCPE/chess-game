package vue;

import controler.ChessGameControlerModel;
import controler.ChessGameControlerModelVue;
import tools.data.Coord;
import tools.data.Couleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ChessGridGUIListener extends ChessGridGUI implements MouseListener, MouseMotionListener{

    private ChessGridGUI chessGridGUI;
    private ChessGameControlerModelVue chessGameControlerModelVue;

    public ChessGridGUIListener(ChessGridGUI chessGridGUI, ChessGameControlerModelVue chessGameControlerModelVue) {
        this.chessGridGUI = chessGridGUI;
        this.chessGameControlerModelVue = chessGameControlerModelVue;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        Coord coord = this.chessGridGUI.getCoordForSquareGUI(e.getX(), e.getY());


        this.chessGameControlerModelVue.actionsWhenPieceIsSelectedOnGUI(coord,
                this.chessGridGUI.getCouleurPieceForSquareCoord(coord));

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.chessGameControlerModelVue.actionsWhenPieceIsMovedOnGUI(null, this.chessGridGUI.getCoordForSquareGUI(e.getX(),e.getY()));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.chessGridGUI.pieceIsMoving(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
