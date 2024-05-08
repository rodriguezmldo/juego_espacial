package Graphics;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JButton;


public class Menu extends JPanel {

    public Menu(){
        setFocusable(true);
        activeWindowMenu();
    }

    public void activeWindowMenu(){

        // cramos la ventana de menu
        JPanel menuWindow = this;
        setLayout(new FlowLayout());
        // Mostramos las opciones de menu

        
        JLabel label = new JLabel("Seleccione una opción:");
        label.setBounds(80, 20, 200, 80);
        menuWindow.add(label);

        JButton opcion1Button = new JButton("Opción 1");
        opcion1Button.setBounds(50, 50, 400, 80);
        menuWindow.add(opcion1Button);

        JButton opcion2Button = new JButton("Opción 2");
        opcion2Button.setBounds(50, 80, 400, 80);
        menuWindow.add(opcion2Button);

        JButton opcion3Button = new JButton("Opción 3");
        opcion3Button.setBounds(50, 110, 400, 80);
        menuWindow.add(opcion3Button);

        JButton opcion4Button = new JButton("Opción 4");
        opcion4Button.setBounds(50, 140, 400, 80);
        menuWindow.add(opcion4Button);

        opcion1Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuWindow, "Has seleccionado la Opción 1");
        });

        opcion2Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuWindow, "Has seleccionado la Opción 2");
        });

        opcion3Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuWindow, "Has seleccionado la Opción 3");
        });

        opcion4Button.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuWindow, "Has seleccionado la Opción 4");
        });
    }
    
}
