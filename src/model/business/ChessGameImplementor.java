package model.business;

import model.piece.Pieces;
import tools.data.Couleur;

import java.util.List;

public interface ChessGameImplementor {

    public List<Pieces> createPieces(Couleur col);

}
