package vue;

import tools.BoardGameConfig;
import tools.data.ChessPiecePos;
import tools.data.Coord;
import tools.data.Couleur;
import tools.factory.ChessImageProvider;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessGridGUI extends JLayeredPane implements ChessGameGUI {

    private Map<Coord, ChessSquareGUI> map;
    private int xAdjustment,yAdjustment;
    private ChessPieceGUI pieceToMove;


    public ChessGridGUI() {
        super();
        map = new HashMap<>();
        setCheckersBoard();
    }

    /**
     * Initialisation of the board
     */
    private void setCheckersBoard() {
        this.setLayout(new GridLayout(BoardGameConfig.getNbColonne(), BoardGameConfig.getNbLigne()));
        for (int x=0;x<BoardGameConfig.getNbColonne();x++){
            for(int y = 0; y < BoardGameConfig.getNbLigne(); y++) {
                ChessSquareGUI square;
                //If the current case is black
                if ((x+y)%2 == 1) {
                    square = new ChessSquareGUI(BoardGameConfig.getBlackSquareColor(), new Coord(x, y));
                } else {
                    square = new ChessSquareGUI(BoardGameConfig.getWhiteSquareColor(), new Coord(x, y));
                }
                this.add(square);
                map.put(square.getCoord(), square);
            }
        }

        JPanel square;

        JLabel chessPieceGUI = null;
        int index;

        for (int i = 0; i < ChessPiecePos.values().length; i++){
            for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++){
                chessPieceGUI = new ChessPieceGUI(ChessPiecePos.values()[i].couleur,
                        ChessPiecePos.values()[i].nom,
                        new ImageIcon(ChessImageProvider.getImageFile(ChessPiecePos.values()[i].nom,
                                ChessPiecePos.values()[i].couleur)));
                index = ChessPiecePos.values()[i].coords[j].getY() * 8 +
                        ChessPiecePos.values()[i].coords[j].getX();
                square = (JPanel) this.getComponent(index);
                square.add(chessPieceGUI);
            }

        }
    }


    @Override
    public void setPieceToMove(Coord coord) {
        this.pieceToMove = (ChessPieceGUI) (this.map.get(coord).getComponents()[0]);
    }

    @Override
    public void resetLight(List<Coord> coords, boolean isLight) {

    }

    @Override
    public void movePiece(Coord targetCoord) {
        this.pieceToMove.setLocation(targetCoord.getX() + xAdjustment, targetCoord.getY() + yAdjustment);
        this.pieceToMove.setSize(this.pieceToMove.getWidth(), this.pieceToMove.getHeight());
        this.add(this.pieceToMove, JLayeredPane.DRAG_LAYER);
    }

    @Override
    public void undoMovePiece(Coord pieceToMoveInitCoord) {

    }

    @Override
    public String getPromotionType() {
        return null;
    }

    @Override
    public void promotePiece(Coord coord, String promotionType) {

    }

    public Coord getCoordForSquareGUI(int x, int y){
        Component c = this.findComponentAt(x, y);

        if(!(c.getParent() instanceof ChessSquareGUI)) return null;

        return ((ChessSquareGUI) c.getParent()).getCoord();
    }

    public Couleur getCouleurPieceForSquareCoord(Coord coord){
        ChessSquareGUI chessSquareGUI = this.map.get(coord);
        ChessPieceGUI pieceGUI = (ChessPieceGUI) chessSquareGUI.getComponents()[0];
        return pieceGUI.getCol();
    }

}
