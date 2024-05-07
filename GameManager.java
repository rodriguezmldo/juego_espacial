import java.util.Random;
import java.util.List;

public class GameManager {
    private Spacecraft spacecraft;
    private List<CosmicObject> cosmicObjects;
    private Random random;

    private static final int COLLISION_THRESHOLD = 500;
    private static final int CAPSULE_THRESHOLD = 1000;
    private static final int DESTROY_THRESHOLD = 500;

    public GameManager(Spacecraft spacecraft, List<CosmicObject> cosmicObjects) {
        this.spacecraft = spacecraft;
        this.cosmicObjects = cosmicObjects;
        this.random = new Random();
    }

    private void simulateRandomEvents() {
        // Probabilidad del 50% para eventos aleatorios
        for (int i = 0; i < 10; i++) { // Iteramos 10 veces para generar varios eventos
            int randomNumber = random.nextInt(100);
            if (randomNumber < 50) {
                // Seleccionar aleatoriamente un evento y ejecutarlo
                int eventType = random.nextInt(4); // 4 tipos de eventos posibles
                switch (eventType) {
                    case 0:
                        System.out.println("¡La nave ha colisionado con un peligro cósmico!");
                        handleCollisionEvent(); // Lógica para tratar la colisión basada en las condiciones del nivel
                        break;
                    case 1:
                        System.out.println("¡La nave ha recolectado una cápsula de vida!");
                        handleLifeCapsuleEvent(); // Lógica para recolectar la cápsula de vida basada en las condiciones del nivel
                        break;
                    case 2:
                        System.out.println("¡La nave fue destruida!");
                        handleSpacecraftDestructionEvent(); // Lógica para manejar la destrucción de la nave basada en las condiciones del nivel
                        break;
                    case 3:
                        System.out.println("¡La nave ha destruido un peligro cósmico!");
                        handleCosmicDangerDestructionEvent(); // Lógica para destruir un peligro cósmico basada en las condiciones del nivel
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void handleCollisionEvent() {
        // Si la distancia entre la nave y un objeto cósmico es menor que un cierto umbral,
        // la nave sufre daño basado en las características del objeto cósmico
        for (CosmicObject cosmicObject : cosmicObjects) {
            int distanceToSpacecraft = Math.abs(spacecraft.getDistance() - cosmicObject.getDistance());
            if (distanceToSpacecraft < COLLISION_THRESHOLD) {
                spacecraft.lifeCapsules -= cosmicObject.getDamage();
                System.out.println("La nave ha sufrido daño debido a la colisión con un peligro cósmico.");
                break; // Salir del bucle, ya que la nave solo puede colisionar con un objeto a la vez
            }
        }
    }

    private void handleLifeCapsuleEvent() {
        // Si la distancia entre la nave y una cápsula de vida es menor que un cierto umbral,
        // la nave recolecta la cápsula y aumenta su cantidad de cápsulas de vida
        for (CosmicObject cosmicObject : cosmicObjects) {
            if (cosmicObject instanceof CapsuleObject) {
                int distanceToSpacecraft = Math.abs(spacecraft.getDistance() - cosmicObject.getDistance());
                if (distanceToSpacecraft < CAPSULE_THRESHOLD) {
                    CapsuleObject capsuleObject = (CapsuleObject) cosmicObject;
                    spacecraft.lifeCapsules += capsuleObject.getCapsules();
                    System.out.println("La nave ha recolectado una cápsula de vida.");
                    break; // Salir del bucle, ya que la nave solo puede recolectar una cápsula a la vez
                }
            }
        }
    }

    private void handleSpacecraftDestructionEvent() {
        // La nave es destruida si su cantidad de cápsulas de vida llega a cero
        if (spacecraft.lifeCapsules <= 0) {
            System.out.println("La nave ha sido destruida.");
        }
    }

    private void handleCosmicDangerDestructionEvent() {
        // Si la distancia entre la nave y un peligro cósmico es menor que un cierto umbral,
        // la nave destruye el peligro cósmico y reduce su cantidad de misiles
        for (CosmicObject cosmicObject : cosmicObjects) {
            if (cosmicObject instanceof CosmicDanger) {
                int distanceToSpacecraft = Math.abs(spacecraft.getDistance() - cosmicObject.getDistance());
                if (distanceToSpacecraft < DESTROY_THRESHOLD) {
                    spacecraft.missiles -= ((CosmicDanger) cosmicObject).getMissilesPenalty();
                    System.out.println("La nave ha destruido un peligro cósmico.");
                    break; // Salir del bucle, ya que la nave solo puede destruir un peligro cósmico a la vez
                }
            }
        }
    }
    public void simulateGame() {
        for (CosmicObject cosmicObject : cosmicObjects) {
            cosmicObject.interact(spacecraft);
        }
        simulateRandomEvents(); // Generar eventos aleatorios durante la simulación
        System.out.println("¡Evento final de la simulación!");
    }
}