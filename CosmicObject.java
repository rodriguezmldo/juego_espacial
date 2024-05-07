import java.util.Random;

public abstract class CosmicObject {
    protected int distance;
    protected int speed;
    protected int damage;
    protected int missilesPenalty;
    protected Random random; // Declaración de la variable random

    public CosmicObject() {
        random = new Random(); // Inicialización de la variable random
    }

    public void move() {
        // Actualizar la posición basada en la velocidad actual y la dirección aleatoria
        double randomDirection = random.nextDouble() * 2 - 1; // Genera un valor aleatorio entre -1 y 1
        distance += speed * randomDirection;
    }

    public abstract void interact(Spacecraft spacecraft);

    public int getDistance() {
        return distance;
    }

    public int getDamage() {
        return damage;
    }

    public int getMissilesPenalty() {
        return missilesPenalty;
    }
}