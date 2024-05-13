package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Keyboard extends JLabel {
    private static final int DELAY = 10; // Tiempo de retardo en milisegundos
    private int dx = 0;
    private int dy = 0;
    private int velocidad = 6;
    private Timer timer;
    private Set<Integer> teclasPresionadas = new HashSet<>();
    private List<Bala> balas = new ArrayList<>();

    public Keyboard() {
        cargarImagen();
        setFocusable(true);
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover();
            }
        });
        timer.start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                teclasPresionadas.add(e.getKeyCode());
                actualizarMovimiento();
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    disparar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasPresionadas.remove(e.getKeyCode());
                actualizarMovimiento();
            }
        });
    }

    private void cargarImagen() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Res/Player/ship0.gif"));
        setIcon(icono);
        setSize(icono.getIconWidth(), icono.getIconHeight());
    }

    private void actualizarMovimiento() {
        dx = 0;
        dy = 0;
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
    }

    private void mover() {
        int x = getX() + dx;
        int y = getY() + dy;

        x = Math.max(0, Math.min(getParent().getWidth() - getWidth(), x));
        y = Math.max(0, Math.min(getParent().getHeight() - getHeight(), y));

        setLocation(x, y);
        moverBalas();
    }

    private void disparar() {
        Bala bala = new Bala(getX() + getWidth(), getY() + getHeight() / 2);
        getParent().add(bala, 0);
        balas.add(bala);
    }

    public void moverBalas() {
        Iterator<Bala> iterator = balas.iterator();
        while (iterator.hasNext()) {
            Bala bala = iterator.next();
            bala.mover();
            if (bala.fueraDePantalla()) {
                getParent().remove(bala);
                iterator.remove();
            }
        }
    }
}
