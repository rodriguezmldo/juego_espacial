package Graphics;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class History extends JPanel {
    public History() {
        loadHistory();
        setFocusable(true);
    }

    private void loadHistory() {
        List<String> lines = getLines("SaveData\\DataFiles\\profiles.txt");
        createHistoryPanel(lines);
    }

    private List<String> getLines(String filePath) {
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
        LoadBackground historyGame = new LoadBackground();
        historyGame.setPreferredSize(new Dimension(1280, 730));
    
        Color backgroundColor = Color.decode("#663399");
        Font font = new Font("Times New Roman", Font.BOLD, 20);
    
        GridBagLayout layout = new GridBagLayout();
        historyGame.setLayout(layout);
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0); // Espacio entre etiquetas
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    
        int y = 0; // Posición inicial en el eje Y
    
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
    
        JScrollPane scrollPane = new JScrollPane(historyGame);
        // Ajuste para que el panel de desplazamiento comience desde el borde superior
        scrollPane.getViewport().setPreferredSize(new Dimension(1280, 730));
        add(scrollPane); // Agregar el JScrollPane al JPanel
    }
    
}
