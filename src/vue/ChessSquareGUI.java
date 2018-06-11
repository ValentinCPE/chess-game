package vue;

import tools.data.Coord;

import javax.swing.*;
import java.awt.*;

public class ChessSquareGUI extends JPanel{
    private Color color;
    private Coord coord;

    public ChessSquareGUI(Color color, Coord coord) {
        super();
        this.color = color;
        this.coord = coord;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
    }

    public Coord getCoord() {
        return coord;
    }
}
