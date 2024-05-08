import javax.swing.JFrame;

import Graphics.Nave;
import Graphics.Menu;

public class Main {
    public static void main(String[] args) { 
        JFrame ventana = new JFrame(" Visible");
        ventana.add(new Menu());
        //ventana.add(new Nave());
        ventana.setSize(800, 1000);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
