package model.business;

import model.piece.Pieces;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

import java.util.List;

public class ChessImplementor implements ChessGameImplementor {

    private List<Pieces> liste_pieces_blanches;
    private List<Pieces> liste_pieces_noires;

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
    }

    @Override
    public List<Pieces> createPieces(Couleur col) {
        return ChessPiecesFactory.newPieces(col);
    }
}
