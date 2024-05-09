import javax.swing.JFrame;

import Graphics.Menu;
import Graphics.Nave;

public class Main {
    public static void main(String[] args) { 

        int dWhile = 0;

        do {
            JFrame ventana = new JFrame(" Visible");
        
            ventana.setSize(800, 1000);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);

            Menu menuWin = new Menu(dWhile);
            ventana.add(menuWin);
            dWhile = menuWin.optionWindow();

            switch (dWhile) {
                case 1:

                    

                    break;
                case 2:
                    ventana.add(new Nave());
                    break;
                case 3:
                    break;
            
                default:
                    break;
            }
            
        } while (dWhile != 0);
        
    }
}
