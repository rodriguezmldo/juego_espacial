package interfaz;

import java.awt.*;
import javax.swing.*;

public class loadBackground extends JPanel {
    private ImageIcon backgroundImage;

    public loadBackground() {
        backgroundImage = new ImageIcon("resources\\background\\background.jpg");
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
