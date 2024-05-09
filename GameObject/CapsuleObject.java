package GameObject;

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
}