import javax.swing.*;
import java.awt.*;


import Graphics.Menu;

class BackgroundPanel extends JPanel {
    private ImageIcon backgroundImage;

    public BackgroundPanel() {
        backgroundImage = new ImageIcon("Res/BackGroundFile/background.jpg");
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

        UIManager.put("nimbusBase", new Color(15, 15, 25)); // Color de fondo oscuro
        UIManager.put("nimbusBlueGrey", new Color(30, 30, 40)); // Color de resaltado oscuro
        UIManager.put("nimbusBorder", new Color(10, 10, 15)); // Color del borde oscuro

        ventana.setSize(1280, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.add(new Menu(), BorderLayout.CENTER);

        ventana.add(backgroundPanel);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}