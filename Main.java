import java.awt.Color;

import javax.swing.JFrame;

import Graphics.Menu;
import Graphics.Nave;

public class Main {
    public static void main(String[] args) { 


        JFrame ventana = new JFrame(" Visible");
        
        ventana.setSize(1280, 720);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.getContentPane().setBackground(Color.WHITE);
        ventana.add(new Menu());

        ventana.setVisible(true);
        
    }
}
