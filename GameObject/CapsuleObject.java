package GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Math.Vector2D;

public class CapsuleObject extends CosmicObject {
    private int health;
    public CapsuleObject(Vector2D position, BufferedImage texture) {
        super(position, texture); // No es necesario pasar la velocidad
    }

    // Agregar el método getCapsules() para obtener el número de cápsulas
    public int getHealth() {
        return health;
     }

     public void setHealth(int health) {
        this.health = health;
     }

    @Override
    public void update(float dt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    } 
}