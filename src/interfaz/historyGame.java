package interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class historyGame extends JFrame {
    JPanel menuWindow;

    public historyGame(JPanel menuWindow) {
        this.menuWindow = menuWindow;
        loadHistory();
        setFocusable(true);
        setTitle("Historial del Juego");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo la ventana actual
        setSize(1280, 730);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setResizable(false); // Evitar que se pueda redimensionar la ventana
        setVisible(true);
    }

    private void loadHistory() { // cargamos los resultados al programa
        List<String> lines = getLines("resources\\gameData\\data.txt");
        createHistoryPanel(lines);
    }

    private List<String> getLines(String filePath) { // leemos los resultados y los guardamos para su proceso
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al leer archivo: " + e.getMessage());
        }
        return lines;
    }

    private void createHistoryPanel(List<String> lines) {
        JPanel historyGame = new loadBackground(); // cargamos el fondo
        historyGame.setPreferredSize(new Dimension(1280, 730));

        Color backgroundColor = Color.decode("#663399");
        Font font = new Font("Times New Roman", Font.BOLD, 20);

        GridBagLayout layout = new GridBagLayout();
        historyGame.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int y = 0;

        for (String text : lines) {
            JLabel viewResult = new JLabel(text);
            viewResult.setBackground(backgroundColor);
            viewResult.setPreferredSize(new Dimension(500, 30));
            viewResult.setOpaque(true);
            viewResult.setFont(font);
            viewResult.setHorizontalAlignment(SwingConstants.CENTER);
            viewResult.setForeground(Color.white);
            viewResult.setBorder(BorderFactory.createLineBorder(backgroundColor, 2));

            gbc.gridy = y++;
            layout.setConstraints(viewResult, gbc);
            historyGame.add(viewResult);
        }
        
        add(historyGame);
    }
}
