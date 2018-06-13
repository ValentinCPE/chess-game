package model.business;

import model.piece.Pieces;
import tools.data.ActionType;
import tools.data.Coord;
import tools.data.Couleur;

import java.util.List;

public interface ChessGameImplementor {

    /**
     * Initialisation des pièces à partir de la ChessPiecesFactory par couleur
     * @param col : couleur en question
     * @return liste de pièces avec la couleur passée en paramètre
     */
    List<Pieces> createPieces(Couleur col);

    /**
     * Renvoie la couleur de la pièce de coordonnées x et y
     * @param x : lignes
     * @param y : colonnes
     * @return la couleur de la pièce
     */
    Couleur getColorForAPiece(int x, int y);

    /**
     * Interroge la méthode spécifique selon la pièce qui indique si un déplacement est possible
     * @param start : coordonnée de départ
     * @param end : coordonnée d'arrivée
     * @return booléen indiquant si le déplacement est possible ou pas
     */
    boolean canMoveInThisWay(Coord start, Coord end);

    /**
     * Signifie si une pièce se trouve à la coordonnée position
     * @param position : coordonnée à tester
     * @return booléen indiquant la présence de la pièce
     */
    boolean isPieceToEatAtPosition(Coord position);

    /**
     * Effectue le mouvement selon la pièce et renvoie l'ActionType correspondant à l'évenement renvoyé par le déplacement (PROMOTION, MOVE...)
     * @param xInit : ligne de départ
     * @param yInit : colonne de départ
     * @param xFinal : ligne d'arrivée
     * @param yFinal : colonne d'arrivée
     * @return ActionType correspondant à l'évenement rencontré durant le déplacement
     */
    ActionType doMove(int xInit, int yInit, int xFinal, int yFinal);

     /**
     * Renvoie la pièce selon son x, y et sa couleur
     * @param x : ligne
     * @param y : colonne
     * @param couleur : couleur de la pièce rencontrée
     * @return Pièce en question
     */
   // Pieces getPieceAccordingToXYAndColour(int x, int y, Couleur couleur);

    /**
     * Renvoie la pièce selon son x, y
     * @param x : ligne
     * @param y : colonne
     * @return Pièce en question
     */
 //   Pieces getPieceAccordingToXY(int x, int y); */

}
