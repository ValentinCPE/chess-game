package model.business;

import model.piece.Pieces;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;
import tools.factory.ChessPiecesFactory;

import java.util.*;

public class ChessImplementor implements ChessGameImplementor {

    private Map<Couleur, List<Pieces>> map = new HashMap<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChessImplementor{");
        stringBuilder.append("liste_pieces_blanches=");
        stringBuilder.append(this.map.get(Couleur.BLANC));
        stringBuilder.append(",liste_pieces_noires=");
        stringBuilder.append(this.map.get(Couleur.NOIR));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ChessImplementor() {
        this.map.put(Couleur.BLANC,createPieces(Couleur.BLANC));
        this.map.put(Couleur.NOIR,createPieces(Couleur.NOIR));
    }

    @Override
    public List<Pieces> createPieces(Couleur col) {
        return ChessPiecesFactory.newPieces(col);
    }


    public Couleur getColorForAPiece(int x, int y){
        return this.getPieceAccordingToXY(x, y).getCouleur();
    }

    public boolean canMoveInThisWay(Coord start, Coord end){
        boolean movePossible = false;

        Pieces pieceToTest = this.getPieceAccordingToCoord(start);

        if(pieceToTest.isAlgoMoveOk(end.getX(),end.getY())){
            movePossible = true;
        }

        return movePossible;
    }

    public boolean isPieceToEatAtPosition(Coord position){
        boolean exists = false;

        if(this.getPieceAccordingToCoord(position) != null){
            exists = true;
        }

        return exists;
    }

    public ActionType doMove(int xInit, int yInit, int xFinal, int yFinal){
        ActionType actionType = ActionType.ILLEGAL;

        Coord start = new Coord(xInit,yInit);

        Pieces pieces = this.getPieceAccordingToCoord(start);

        if(pieces != null){
            actionType = pieces.doMove(xFinal,yFinal);
        }

        return actionType;
    }

    private List<Pieces> getPieces(Couleur couleur){
        return this.map.get(couleur);
    }

    private Pieces getPieceAccordingToCoordAndColour(Coord coord, Couleur couleur){
        return this.getPieceAccordingToXYAndColour(coord.getX(),coord.getY(),couleur);
    }

    private Pieces getPieceAccordingToXYAndColour(int x, int y, Couleur couleur){
        Pieces pieceFound = null;
        List<Pieces> pieces = this.map.get(couleur);

        if(pieces != null){
            for(Pieces piece : pieces){
                if(piece.getX() == x && piece.getY() == y){
                    pieceFound = piece;
                }
            }
        }
        return pieceFound;
    }

    private Pieces getPieceAccordingToCoord(Coord coord){
        return this.getPieceAccordingToXY(coord.getX(),coord.getY());
    }

    private Pieces getPieceAccordingToXY(int x, int y){
        Pieces pieceFound = null;
        Set set = this.map.entrySet();
        for (Object aSet : set) {
            Map.Entry entry = (Map.Entry) aSet;
            List<Object> obj = (List<Object>) entry.getValue();
            for (Object pieces : obj) {
                if (((Pieces) pieces).getX() == x && ((Pieces) pieces).getY() == y) {
                    pieceFound = (Pieces) pieces;
                }
            }
        }
        return pieceFound;
    }
}
