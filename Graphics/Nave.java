package Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;

public class Nave extends JPanel implements KeyListener {
    private JLabel nave;
    private Set<Integer> teclasPresionadas = new HashSet<>();
    private int velocidad = 30; 
    
    public Nave(){
        setLayout(null); // Establecer el layout como null para poder posicionar los componentes manualmente
        setFocusable(true);
        addKeyListener(this);
        cargarImagen(); 
        // Establecer las coordenadas iniciales
        nave.setLocation(100, 440);
        add(nave); // Agregar el JLabel nave al panel
    }

    private void cargarImagen() {
        ImageIcon icono = new ImageIcon(getClass().getResource("nave_volando.gif"));
        nave = new JLabel(icono);
        nave.setSize(icono.getIconWidth(), icono.getIconHeight());
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        teclasPresionadas.add(e.getKeyCode());
        mover();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclasPresionadas.remove(e.getKeyCode());
    }

    private void mover() {
        int dx = 0;
        int dy = 0;
        
        int x = nave.getX();
        int y = nave.getY();

        if (teclasPresionadas.contains(KeyEvent.VK_UP) || teclasPresionadas.contains(KeyEvent.VK_W)) {
            dy -= velocidad;
        }
        if (teclasPresionadas.contains(KeyEvent.VK_DOWN) || teclasPresionadas.contains(KeyEvent.VK_S)) {
            dy += velocidad;
        }
        if (teclasPresionadas.contains(KeyEvent.VK_LEFT) || teclasPresionadas.contains(KeyEvent.VK_A)) {
            dx -= velocidad;
        }
        if (teclasPresionadas.contains(KeyEvent.VK_RIGHT) || teclasPresionadas.contains(KeyEvent.VK_D)) {
            dx += velocidad;
        }

        int LimitX = x + dx;   
        int LimitY = y + dy;

        if (LimitX < 0) {
            LimitX = 0;
        } else if (LimitX > getWidth() - nave.getWidth()) {
            LimitX = getWidth() - nave.getWidth();
        }

        if (LimitY < 0) {
            LimitY = 0;
        } else if (LimitY > getHeight() - nave.getHeight()) {
            LimitY = getHeight() - nave.getHeight();
        }
        nave.setLocation(LimitX, LimitY);
    }
}