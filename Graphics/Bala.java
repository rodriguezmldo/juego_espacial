package Graphics;

import javax.swing.*;
import java.awt.*;

public class Bala extends JLabel {
    private static final int VELOCIDAD_BALA = 10;

    public Bala(int x, int y) {
        ImageIcon iconoBala = new ImageIcon(getClass().getResource("/Res/Effects/laser.gif"));
        setIcon(iconoBala);
        setSize(iconoBala.getIconWidth(), iconoBala.getIconHeight());
        setLocation(x, y);
    }

    public void mover() {
        setLocation(getX() + VELOCIDAD_BALA, getY());
        getParent().repaint(); // Actualizar la pantalla después de mover la bala
    }

    public boolean fueraDePantalla() {
        return getX() >= getParent().getWidth();
    }
}
