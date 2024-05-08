package Pruebas;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) { 
        JFrame ventana = new JFrame("Nave");
        ventana.add(new Nave());
        ventana.setSize(1500, 1000);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
