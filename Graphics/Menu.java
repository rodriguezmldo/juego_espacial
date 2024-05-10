package Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;

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

        opcion1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame(menuWindow);
            }
        });

        opcion2Button.addActionListener(e -> {
            showOption2();
        });

        opcion3Button.addActionListener(e -> {
            showOption3();
        });

        opcion4Button.addActionListener(e -> {
            System.exit(0);
        });
    }


    private void startGame(JPanel menuWindow) {
        menuWindow.removeAll(); // Elimina todos los componentes del panel del menú
        
        Keyboard keyboard = new Keyboard();
        keyboard.setSize(700, 100); // Establece el tamaño de la Keyboard
        keyboard.setLocation(100, 300); // Establece la posición inicial de la Keyboard
        menuWindow.add(keyboard); // Agrega la Keyboard al panel
        menuWindow.revalidate(); // Vuelve a validar el panel
        menuWindow.repaint(); // Vuelve a dibujar el panel
        keyboard.requestFocusInWindow(); // Hacer que la Keyboard tenga el foco para poder recibir eventos de teclado
    }

    private void showOption2() {
        // Crear y mostrar la ventana de la opción 2
        JFrame option2Window = new JFrame("Option 2");
        option2Window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        option2Window.setSize(400, 300);
        option2Window.setLocationRelativeTo(this);
        option2Window.setVisible(true);
    }

    private void showOption3() {
        // Crear y mostrar la ventana de la opción 3
        List<String> lineas = History.obtenerLineas("SaveData\\DataFiles\\profiles.txt");

        SwingUtilities.invokeLater(() -> {
            History gameHistory = new History(lineas);
            gameHistory.setVisible(true);
        });
    }
}

