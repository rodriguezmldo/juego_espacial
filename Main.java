import javax.swing.*;
import java.awt.*;

import Graphics.Menu;

//prueba 2
class BackgroundPanel extends JPanel {
    private ImageIcon backgroundImage;

    public BackgroundPanel() {
        backgroundImage = new ImageIcon("Res/Effects/background.jpg");
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("GAMING NAVE");

        UIManager.put("nimbusBase", new Color(60, 60, 60)); // Color de fondo
        UIManager.put("nimbusBlueGrey", new Color(200, 200, 200)); // Color de resaltado
        UIManager.put("nimbusBorder", new Color(100, 100, 100)); // Color del borde

        ventana.setSize(1280, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.add(new Menu(), BorderLayout.CENTER);

        ventana.add(backgroundPanel);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
