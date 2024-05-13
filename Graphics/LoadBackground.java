package Graphics;

import javax.swing.*;
import java.awt.*;

public class LoadBackground extends JPanel {
    private ImageIcon backgroundImage;

    public LoadBackground() {
        backgroundImage = new ImageIcon("Res/BackGround/background.jpg");
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}