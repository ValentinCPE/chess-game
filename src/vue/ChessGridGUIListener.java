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
    private JLabel chessPiece;
    private int xAdjustment,yAdjustment;
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
        Component c =  this.chessGridGUI.findComponentAt(e.getX(), e.getY());

        if(c instanceof ChessPieceGUI){

            Point parentLocation = c.getParent().getLocation();
            this.xAdjustment = parentLocation.x - e.getX();
            this.yAdjustment = parentLocation.y - e.getY();

            c.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            c.setSize(c.getWidth(), c.getHeight());
            this.chessPiece = (JLabel) c;
            chessPiece.setLocation(e.getX() , e.getY() );
            this.chessGridGUI.add(chessPiece, JLayeredPane.DRAG_LAYER);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(chessPiece == null) return;

        chessPiece.setVisible(false);
        Component c =  this.chessGridGUI.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel){
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( chessPiece );
        }
        else {
            Container parent = (Container)c;
            parent.add( chessPiece );
        }

        chessPiece.setVisible(true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
