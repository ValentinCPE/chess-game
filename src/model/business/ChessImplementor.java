package model.business;

import model.piece.Pieces;
import tools.data.Coord;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessImplementor implements ChessGameImplementor {

    private List<Pieces> liste_pieces_blanches;
    private List<Pieces> liste_pieces_noires;
    private Map<Coord, Pieces> map = new HashMap<>();

    @Override
    public String toString() {
        return "ChessImplementor{" +
                "liste_pieces_blanches=" + liste_pieces_blanches +
                ", liste_pieces_noires=" + liste_pieces_noires +
                '}';
    }

    public ChessImplementor() {
        this.liste_pieces_blanches = createPieces(Couleur.BLANC);
        this.liste_pieces_noires = createPieces(Couleur.NOIR);
        for (Pieces p : this.liste_pieces_noires) {
            this.map.put(new Coord(p.getX(), p.getY()), p);
        }
        for (Pieces p2 : this.liste_pieces_blanches) {
            this.map.put(new Coord(p2.getX(), p2.getY()), p2);
        }
    }

    @Override
    public List<Pieces> createPieces(Couleur col) {
        return ChessPiecesFactory.newPieces(col);
    }

    public boolean checkMoveOk(Coord coordPiece, Coord target) {
        System.out.println("coord to look for " + coordPiece.toString());
        Pieces movingPiece = this.map.get(coordPiece);
        System.out.println("moving piece "+ movingPiece);
        return movingPiece != null && movingPiece.isMoveOk(movingPiece, target);
    }

}
