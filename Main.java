import javax.swing.*;
import java.awt.*;
import Graphics.LoadBackground;
import Graphics.Menu;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("GAMING NAVE");

        UIManager.put("nimbusBase", new Color(15, 15, 25)); // Color de fondo oscuro
        UIManager.put("nimbusBlueGrey", new Color(30, 30, 40)); // Color de resaltado oscuro
        UIManager.put("nimbusBorder", new Color(10, 10, 15)); // Color del borde oscuro

        ventana.setSize(1280, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoadBackground backgroundPanel = new LoadBackground();
        backgroundPanel.add(new Menu(), BorderLayout.CENTER);

        ventana.add(backgroundPanel);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}