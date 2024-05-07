import java.util.ArrayList;
import java.util.List;

public class Spacecraft extends CosmicObject {
    protected int lifeCapsules;
    protected int missiles;
    private int speed;
    private int distance;
    private List<CosmicObject> cosmicObjects;

    private int INTERACTION_DISTANCE_THRESHOLD;
    private static final int MAX_SPEED = 30000;
    private static final int MAX_DISTANCE = 1000000;

    public Spacecraft(int lifeCapsules, int missiles, int speed, int distance) {
        this.lifeCapsules = lifeCapsules;
        this.missiles = missiles;
        this.speed = speed;
        this.distance = distance;
        this.cosmicObjects = new ArrayList<>(); // Inicializar la lista
    }

    public int getDistance() {
        return distance;
    }

    public int getLifeCapsules() {
        return lifeCapsules;
    }

    public int getMissiles() {
        return missiles;
    }

    @SuppressWarnings("unused")
    public void captureObject(CosmicObject object) {
        int objectDistance = object.getDistance();
        if (objectDistance <= 6000) {
            // Capturar objeto
            if (object instanceof Planet) {
                Planet planet = (Planet) object;
                if (planet.hasLife()) {
                    this.lifeCapsules += 5;
                } 
            } else if (object instanceof Asteroid) {
                Asteroid asteroid = (Asteroid) object;
                if (this.distance <= 6000 && this.speed >= 20000) {
                    // Destruir asteroide
                    this.missiles -= 60;
                } else {
                    // Penalización por intentar destruir asteroide sin cumplir condiciones
                    this.lifeCapsules -= 20;
                    this.missiles -= 40;
                }
            } else if (object instanceof BlackHole) {
                BlackHole blackHole = (BlackHole) object;
                if (this.distance <= 4000 && this.speed >= 28000) {
                    // Destruir hoyo negro
                    this.missiles -= 80;
                } else {
                    // Penalización por intentar destruir hoyo negro sin cumplir condiciones
                    this.lifeCapsules -= 30;
                    this.missiles -= 50;
                }
            }
        } else {
            // Penalización por intentar capturar objeto sin cumplir condiciones
            this.lifeCapsules -= 3;
        }
    }

    @SuppressWarnings("unused")
    public void interact(List<CosmicObject> cosmicObjects) {
        for (CosmicObject cosmicObject : cosmicObjects) {
            // Implementa la lógica de interacción aquí
            int distanceToCosmicObject = Math.abs(this.distance - cosmicObject.getDistance());
            
            if (distanceToCosmicObject <= INTERACTION_DISTANCE_THRESHOLD) {
                // Realiza acciones específicas según el tipo de objeto cósmico
                if (cosmicObject instanceof Planet) {
                    Planet planet = (Planet) cosmicObject;
                    if (planet.hasLife()) {
                        this.lifeCapsules += 5;
                    }
                } else if (cosmicObject instanceof Asteroid) {
                    Asteroid asteroid = (Asteroid) cosmicObject;
                    // Lógica de interacción con asteroides
                } else if (cosmicObject instanceof BlackHole) {
                    BlackHole blackHole = (BlackHole) cosmicObject;
                    // Lógica de interacción con agujeros negros
                }
                // Registrar la interacción en el registro de eventos del juego
                System.out.println("Interacción con " + cosmicObject.getClass().getSimpleName() + " en distancia: " + distanceToCosmicObject);
            } else {
                // Emitir un mensaje indicando que el objeto cósmico está fuera de rango de interacción
                System.out.println(cosmicObject.getClass().getSimpleName() + " está fuera de rango de interacción.");
            }
        }
    }

    @Override
    public void move() {
        // Actualizar la posición basada en la velocidad actual
        distance += speed;
    
        // Ajustar el umbral de interacción en función de la velocidad actual
        INTERACTION_DISTANCE_THRESHOLD = calculateInteractionThreshold(speed);
    
        // Verificar si la velocidad excede un límite máximo y tomar acciones en consecuencia
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED; // Limitamos la velocidad al máximo permitido
            // Emitir una advertencia o mensaje indicando que la velocidad máxima ha sido alcanzada
            System.out.println("¡Advertencia! Velocidad máxima alcanzada.");
        }
    
        // Verificar si la distancia ha excedido un límite máximo y tomar acciones en consecuencia
        if (distance > MAX_DISTANCE) {
            distance = MAX_DISTANCE; // Limitamos la distancia al máximo permitido
            // Emitir una advertencia o mensaje indicando que se ha alcanzado la distancia máxima
            System.out.println("¡Advertencia! Has llegado al límite del espacio conocido.");
        }
    }
    
    // Método para calcular dinámicamente el umbral de interacción
    private int calculateInteractionThreshold(int speed) {
        // Calcula el umbral como un porcentaje de la velocidad actual
        return (int) (speed * 0.1); // Por ejemplo, podríamos usar el 10% de la velocidad como umbral
    }
    
    @SuppressWarnings("unused")
    @Override
    public void interact(Spacecraft spacecraft) {
        for (CosmicObject cosmicObject : cosmicObjects) {
            // Implementa la lógica de interacción aquí
            int distanceToCosmicObject = Math.abs(this.distance - cosmicObject.getDistance());
            
            if (distanceToCosmicObject <= INTERACTION_DISTANCE_THRESHOLD) {
                // Realiza acciones específicas según el tipo de objeto cósmico
                if (cosmicObject instanceof Planet) {
                    Planet planet = (Planet) cosmicObject;
                    if (planet.hasLife()) {
                        this.lifeCapsules += 5;
                    }
                } else if (cosmicObject instanceof Asteroid) {
                    Asteroid asteroid = (Asteroid) cosmicObject;
                    // Lógica de interacción con asteroides
                } else if (cosmicObject instanceof BlackHole) {
                    BlackHole blackHole = (BlackHole) cosmicObject;
                    // Lógica de interacción con agujeros negros
                }
                // Registrar la interacción en el registro de eventos del juego
                System.out.println("Interacción con " + cosmicObject.getClass().getSimpleName() + " en distancia: " + distanceToCosmicObject);
            } else {
                // Emitir un mensaje indicando que el objeto cósmico está fuera de rango de interacción
                System.out.println(cosmicObject.getClass().getSimpleName() + " está fuera de rango de interacción.");
            }
        }
    }
}