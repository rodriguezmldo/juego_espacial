package Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;


public class Menu extends JPanel {

    public Menu(){
        setFocusable(true);
        activeWindowMenu(this);
    }

    public void activeWindowMenu(JPanel menuWindow){

        menuWindow.setLayout(null);
        setOpaque(false);

        // Creamos y colocamos los botones en el panel de la ventana
        JLabel label = new JLabel("Seleccione una opción:");
        label.setBounds(400, 20, 500, 65);
        menuWindow.add(label);
        label.setForeground(Color.WHITE);

        JButton opcion1Button = new JButton("INICIAR HISTORIA");
        opcion1Button.setBounds(400, 110, 450, 65);
        menuWindow.add(opcion1Button);

        JButton opcion2Button = new JButton("INICIAR ARCADES");
        opcion2Button.setBounds(400, 210, 450, 65);
        menuWindow.add(opcion2Button);

        JButton opcion3Button = new JButton("HISTORIAL DE PARTIDA");
        opcion3Button.setBounds(400, 310, 450, 65);
        menuWindow.add(opcion3Button);

        JButton opcion4Button = new JButton("SALIR");
        opcion4Button.setBounds(400, 410, 450, 65);
        menuWindow.add(opcion4Button);

        // colocamos la fuentes 
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        opcion1Button.setFont(font);
        opcion2Button.setFont(font);
        opcion3Button.setFont(font);
        opcion4Button.setFont(font);

        // agregamos estilo a las fuentes de los botones
        Color fontColor = Color.decode("#FFFFFF");
        opcion1Button.setForeground(fontColor);
        opcion2Button.setForeground(fontColor);
        opcion3Button.setForeground(fontColor);
        opcion4Button.setForeground(fontColor);

        // agregamos estilos de fondo a los botones
        Color backgroundColor = Color.decode("#663399");
        opcion1Button.setBackground(backgroundColor);
        opcion2Button.setBackground(backgroundColor);
        opcion3Button.setBackground(backgroundColor);
        opcion4Button.setBackground(backgroundColor);

        opcion1Button.addActionListener(e -> {

        });

        opcion2Button.addActionListener(e -> {

        });

        opcion3Button.addActionListener(e -> {

        });

        opcion4Button.addActionListener(e -> {
            System.exit(0);
        });

    } 
}

