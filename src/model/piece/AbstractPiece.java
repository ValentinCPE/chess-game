package model.piece;

import tools.data.Coord;
import tools.data.Couleur;

public abstract class AbstractPiece implements Pieces {

    private String nom;
    private Coord coord;
    private Couleur col;

    public AbstractPiece(String nom, Coord coord, Couleur col) {
        this.nom = nom;
        this.coord = coord;
        this.col = col;
    }

    public abstract boolean isMoveOk(Pieces piece, Coord targetCoord);
    public abstract void getMoveItinary();

    public String getNom() {
        return nom;
    }

    public Coord getCoord() {
        return coord;
    }

    public Couleur getCol() {
        return col;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        return "Piece " + this.nom + " aux coordonnées (" + this.coord.getX() + ", " + this.coord.getY() + ")";
    }
}
