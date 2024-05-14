package interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.JButton;

public class menu extends JPanel {

	private JButton option1Button;
    private JButton option2Button;
    private JButton option3Button;

    public menu() {
        setFocusable(true);
        activeWindowMenu(this);
        setBounds(0, 0, 1280, 720);
    }

    public void activeWindowMenu(JPanel menuWindow) {
    	
        menuWindow.setLayout(null);
        loadBackground backG = new loadBackground();
        setOpaque(false); // para que se vean los objetos por encima del fondo

        // creamos el mensaje de selección de opción
        JLabel label = new JLabel("Seleccione una opción:");
        label.setBounds(400, 20, 500, 65);
        menuWindow.add(label);
        label.setForeground(Color.WHITE);

        // creamos los botones y les damos su posición
        option1Button = new JButton("INICIAR HISTORIA");
        option1Button.setBounds(400, 110, 450, 65);
        menuWindow.add(option1Button);

        option2Button = new JButton("HISTORIAL DE PARTIDA");
        option2Button.setBounds(400, 210, 450, 65);
        menuWindow.add(option2Button);

        option3Button = new JButton("SALIR");
        option3Button.setBounds(400, 310, 450, 65);
        menuWindow.add(option3Button);

        // agregamos fuentes de letra
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        option1Button.setFont(font);
        option2Button.setFont(font);
        option3Button.setFont(font);

        // estilizamos las fuentes
        Color fontColor = Color.decode("#FFFFFF");
        option1Button.setForeground(fontColor);
        option2Button.setForeground(fontColor);
        option3Button.setForeground(fontColor);

        // estilizamos los botones
        Color backgroundColor = Color.decode("#663399");
        option1Button.setBackground(backgroundColor);
        option2Button.setBackground(backgroundColor);
        option3Button.setBackground(backgroundColor);

        option1Button.addActionListener(e -> {
            showOption1(backG); // si se presiona se abre el juego 
        });

        option2Button.addActionListener(e -> {
            showOption2(menuWindow); // si se presiona se abren los resultados guardados
        });

        option3Button.addActionListener(e -> {
            System.exit(0); // si se presiona terminamos el juego
        });
    } 

    private void showOption1(JPanel menuWindow) {
        SwingUtilities.invokeLater(() -> { // si no hay errores, comenzamos el juego 
            Window window = new Window();
            window.start(); // juego iniciado
            window.setDefaultCloseOperation(window.HIDE_ON_CLOSE); 
        });
    }

    private void showOption2(JPanel menuWindow) {
        SwingUtilities.invokeLater(() -> {  // si no hay errores, mostramos los resultados 
            historyGame history = new historyGame(menuWindow);
            history.setSize(1280, 720);
            menuWindow.add(history); // mostramos los resultados
        });
    }  

    public JPanel getPanel() { // este método esta demás
        return this;
    }
    
}

