package model.business;

import model.piece.Pieces;
import tools.data.ActionType;
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


    public Map<Coord, Pieces> getMap() {
        return map;
    }

    public Couleur getColorForAPiece(int x, int y){
        Coord coord = new Coord(x,y);

        return this.getPieces(coord).getCouleur();
    }

    public boolean canMoveInThisWay(Coord start, Coord end){
        boolean movePossible = false;

        Pieces pieceToTest = this.getPieces(start);

        if(pieceToTest.isAlgoMoveOk(end.getX(),end.getY())){
            movePossible = true;
        }

        return movePossible;
    }

    public boolean isPieceToEatAtPosition(Coord position){
        boolean exists = false;

        if(this.getPieces(position) != null){
            exists = true;
        }

        return exists;
    }

    public ActionType doMove(int xInit, int yInit, int xFinal, int yFinal){
        ActionType actionType = ActionType.ILLEGAL;

        Coord start = new Coord(xInit,yInit);

        Pieces pieces = this.getPieces(start);

        if(pieces != null){
            actionType = pieces.doMove(xFinal,yFinal);
        }

        return actionType;
    }

    private Pieces getPieces(Coord coord){
        return this.map.get(coord);
    }
}
