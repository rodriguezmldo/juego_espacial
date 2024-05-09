package Graphics;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class History extends JFrame {

    public History (List<String> lineas) {
        initUI(lineas);
    }

    private void initUI(List<String> lineas) {
        setTitle("Etiquetas Posicionadas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0); // Espacio entre etiquetas
        Color backgroundColor = Color.decode("#663399");
        Font font = new Font("Times New Roman", Font.BOLD, 20);

        for (String texto : lineas) {
            JLabel etiqueta = new JLabel(texto);
            // Configurar características de la etiqueta
            etiqueta.setPreferredSize(new Dimension(500, 30)); // Establecer tamaño
            etiqueta.setBackground(backgroundColor); // Establecer color de fondo
            etiqueta.setOpaque(true); // Hacer el fondo visible
            etiqueta.setFont(font);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            etiqueta.setVerticalAlignment(SwingConstants.CENTER);
            etiqueta.setForeground(Color.white);

            panel.add(etiqueta, gbc);
            gbc.gridy++; // Incrementar la coordenada Y para la siguiente etiqueta
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        getContentPane().add(scrollPane);
    }

    public static List<String> obtenerLineas(String rutaArchivo) {
        List<String> lineas = new ArrayList<>();
        try {
            FileReader archivo = new FileReader(rutaArchivo);
            BufferedReader lector = new BufferedReader(archivo);

            String linea;
            while ((linea = lector.readLine()) != null) {
                // Eliminar los espacios en blanco al principio y al final de la línea antes de agregarla a la lista
                lineas.add(linea.trim());
            }

            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    public static void main(String[] args) {
        List<String> lineas = obtenerLineas("SaveData\\DataFiles\\profiles.txt");

        SwingUtilities.invokeLater(() -> {
            History gameHistory = new History(lineas);
            gameHistory.setVisible(true);
        });
    }
}
