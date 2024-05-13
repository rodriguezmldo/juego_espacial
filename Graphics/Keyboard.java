package Graphics;

import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;


public class Keyboard extends JLabel implements KeyListener {
    private Set<Integer> teclasPresionadas = new HashSet<>();
    private int velocidad = 30;

    public Keyboard(){
        cargarImagen();
        setFocusable(true);
        addKeyListener(this);
    }

    private void cargarImagen() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Res/Player/ship0.gif"));
        setIcon(icono);
        setSize(icono.getIconWidth(), icono.getIconHeight());
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

        int x = getX();
        int y = getY();

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
        } else if (LimitX > getParent().getWidth() - getWidth()) {
            LimitX = getParent().getWidth() - getWidth();
        }

        if (LimitY < 0) {
            LimitY = 0;
        } else if (LimitY > getParent().getHeight() - getHeight()) {
            LimitY = getParent().getHeight() - getHeight();
        }
        setLocation(LimitX, LimitY);
    }
}