package vue;

import controler.ChessGameControlerModelVue;
import tools.data.Coord;
import tools.data.TextMessage;
import tools.exception.CoordIsNullException;
import tools.exception.PieceDoesNotExist;

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

        try {

            Coord coord = this.chessGridGUI.getCoordForSquareGUI(e.getX(), e.getY());

            if (coord == null) {
                throw new CoordIsNullException(TextMessage.COORD_IS_NULL.toString());
            }

            this.chessGridGUI.setInitialCoord(coord);
            this.chessGridGUI.setPieceToMove(coord);

        } catch (CoordIsNullException coordIsNullException){
            System.err.println(coordIsNullException.getMessage());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        try {
            Coord coordInit = this.chessGridGUI.getInitialCoord();
            Coord coordEnd = this.chessGridGUI.getCoordForSquareGUI(e.getX(),e.getY());

            if(coordInit == null || coordEnd == null){ throw new PieceDoesNotExist(TextMessage.PIECE_DOES_NOT_EXIST.toString()); }

            this.chessGameControlerModelVue.actionsWhenPieceIsMovedOnGUI(coordInit,coordEnd);
        } catch (PieceDoesNotExist exc){
            System.err.println(exc.getMessage());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Coord coord = this.chessGridGUI.getCoordForSquareGUI(e.getX(), e.getY());
        this.chessGridGUI.pieceIsMoving(coord);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
