package vue;

import tools.data.ChessPieceImage;
import tools.data.Couleur;

import javax.swing.*;

public class ChessPieceGUI extends JLabel {

    private Icon img;
    private Couleur col;
    private String nom;

    public ChessPieceGUI(Couleur col, String nom, ImageIcon img) {
        super(img);
        this.img = img;
        this.col = col;
        this.nom = nom;
    }
}
