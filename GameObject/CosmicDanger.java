package GameObject;

public class CosmicDanger extends CosmicObject {
    protected Spacecraft spacecraft; // Agregar esta línea
    private int lifeCapsulesPenalty;
    private int missilesPenalty;

    private static final int INTERACTION_DISTANCE_THRESHOLD = 1000;

    public CosmicDanger(int distance, int speed, Spacecraft spacecraft, int damage, int lifeCapsulesPenalty, int missilesPenalty) {
        this.distance = distance;
        this.speed = speed;
        this.spacecraft = spacecraft;
        this.damage = damage;
        this.lifeCapsulesPenalty = lifeCapsulesPenalty;
        this.missilesPenalty = missilesPenalty;
    }

    public void move() {
        // Supongamos que el peligro cósmico se mueve en línea recta
        // Actualizar la posición basándose en la velocidad y el tiempo transcurrido
        this.distance += this.speed; // Suponiendo que el tiempo es discreto y la velocidad es constante
    }

    @Override
    public void interact(Spacecraft spacecraft) {
        // Calcula la distancia entre la nave espacial y este objeto cósmico
        int distanceToSpacecraft = Math.abs(this.distance - spacecraft.getDistance());

        // Verifica si la nave está dentro de un cierto rango de este objeto cósmico y aplica efectos en consecuencia
        if (distanceToSpacecraft <= INTERACTION_DISTANCE_THRESHOLD) {
            // Aplica los efectos en la nave espacial
            spacecraft.lifeCapsules -= lifeCapsulesPenalty;
            spacecraft.missiles -= missilesPenalty;

            // Registra la interacción en el registro de eventos del juego
            System.out.println("Interacción con " + getClass().getSimpleName() + " en distancia: " + distanceToSpacecraft);
        } else {
            // Emitir un mensaje indicando que la nave espacial está fuera de rango de interacción
            System.out.println("Nave espacial está fuera de rango de interacción con " + getClass().getSimpleName());
        }
    }
}