package main;

import javax.swing.*;
import interfaz.menu;
import java.awt.*;
import interfaz.loadBackground;

public class main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("GAMING NAVE"); // creamos la venta principal del programa
        
        // Damos unos estilos a la ventana
        UIManager.put("nimbusBase", new Color(60, 60, 60));
        UIManager.put("nimbusBlueGrey", new Color(200, 200, 200));
        UIManager.put("nimbusBorder", new Color(100, 100, 100));
        
        ventana.setSize(1280, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // cargamos el fondo a la ventana
        loadBackground backgroundPanel = new loadBackground();
        backgroundPanel.setLayout(new BorderLayout());

        // Creamos el menu y lo agregamos el menu al fondo.
        menu initMenu = new menu();
        backgroundPanel.add(initMenu.getPanel(), BorderLayout.CENTER);
        
        // Agregamos todo a la ventana principal
        ventana.add(backgroundPanel);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
}
   