package vue;

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

    public Icon getImg() {
        return img;
    }

    public Couleur getCol() {
        return col;
    }

    public String getNom() {
        return nom;
    }

}
