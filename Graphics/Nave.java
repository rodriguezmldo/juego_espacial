package Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Nave extends JPanel implements KeyListener {
    private JLabel nave;
    private Set<Integer> teclasPresionadas = new HashSet<>();
    private int velocidad = 20; 

    public Nave(){
        setFocusable(true);
        cargarImagen();
        addKeyListener(this);
    }

    private void cargarImagen() {
        try {
            ImageIcon icono = new ImageIcon("Graphics/Resources/nave_volando.gif");
            Image imagen = icono.getImage();
            Image nuevaImagen = imagen.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            nave = new JLabel(new ImageIcon(nuevaImagen));
            add(nave);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
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

        int limitX = x + dx;
        int limitY = y + dy;

        if (limitX < 0) {
            limitX = 0;
        } else if (limitX > getWidth() - nave.getWidth()) {
            limitX = getWidth() - nave.getWidth();
        }

        if (limitY < 0) {
            limitY = 0;
        } else if (limitY > getHeight() - nave.getHeight()) {
            limitY = getHeight() - nave.getHeight();
        }

        nave.setLocation(limitX, limitY);
    }
}
