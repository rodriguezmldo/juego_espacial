import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class CosmicObject {
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

class Spacecraft extends CosmicObject {
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

class CosmicDanger extends CosmicObject {
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

class Asteroid extends CosmicDanger {
    public Asteroid(int distance) {
        super(distance, 0, null, 30, 30, 60); // Daño y penalidades específicas para asteroides
    }
}

class Planet extends CosmicDanger {
    private boolean hasLife;

    public Planet(int distance, boolean hasLife) {
        super(distance, 0, null, hasLife ? 25 : 15, 25, 50); // Daño y penalidades específicas para planetas
        this.hasLife = hasLife;
    }

    public boolean hasLife() {
        return hasLife;
    }
}

class BlackHole extends CosmicDanger {
    public BlackHole(int distance) {
        super(distance, 0, null, 35, 35, 80); // Invocar el constructor de la superclase
    }
}

abstract class InterestObject extends CosmicObject {
    protected int capsules;
    protected int distanceLimit;

    public InterestObject(int speed, int capsules, int distanceLimit) {
        this.speed = speed;
        this.capsules = capsules;
        this.distanceLimit = distanceLimit;
    }

    @Override
    public void move() {
        // Implementación del movimiento del objeto de interés
    }

    @Override
    public void interact(Spacecraft spacecraft) {
        System.out.println("Interacción con objeto de interés en distancia: " + distance);
        if (spacecraft != null) {
            spacecraft.lifeCapsules += capsules;
            System.out.println("¡La nave espacial ha capturado el objeto de interés!");
        } else {
            System.out.println("¡Error! La referencia a la nave espacial es nula.");
        }
    }
}

class CapsuleObject extends InterestObject {
    public CapsuleObject(int distance, int capsules) {
        super(distance, capsules, 2000); // No es necesario pasar la velocidad
    }

    // Agregar el método getCapsules() para obtener el número de cápsulas
    public int getCapsules() {
        return capsules;
     }

    @Override
    public void interact(Spacecraft spacecraft) {
        System.out.println("Interacción con cápsula en distancia: " + distance);
        if (spacecraft != null) {
            spacecraft.lifeCapsules += capsules;
            System.out.println("¡La nave espacial ha capturado la cápsula!");
        } else {
            System.out.println("¡Error! La referencia a la nave espacial es nula.");
        }
    }
}

class GameManager {
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


public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        // Crear la nave espacial y los objetos cósmicos para cada nivel
        System.out.println();
        Spacecraft spacecraft = new Spacecraft(2000, 8000, 12000, 0);
        List<CosmicObject> level1Objects = new ArrayList<>();
        level1Objects.add(new Planet(3000 + random.nextInt(10000), true)); // Distancia aleatoria
        level1Objects.add(new CapsuleObject(3000 + random.nextInt(10000), 15)); // Distancia aleatoria
    
        List<CosmicObject> level2Objects = new ArrayList<>();
        level2Objects.add(new Asteroid(3000 + random.nextInt(10000))); // Distancia aleatoria
        level2Objects.add(new CapsuleObject(3000 + random.nextInt(10000), 15)); // Distancia aleatoria
    
        List<CosmicObject> level3Objects = new ArrayList<>();
        level3Objects.add(new BlackHole(3000 + random.nextInt(10000))); // Distancia aleatoria
        level3Objects.add(new CapsuleObject(3000 + random.nextInt(10000), 15)); // Distancia aleatoria
    
        // Simular cada nivel del juego varias veces
        for (int i = 0; i < 3; i++) { // Ejecutar cada nivel 3 veces
            GameManager level1GameManager = new GameManager(spacecraft, level1Objects);
            GameManager level2GameManager = new GameManager(spacecraft, level2Objects);
            GameManager level3GameManager = new GameManager(spacecraft, level3Objects);
    
            // Bucle de juego
            System.out.println("Simulación del Nivel 1:");
            level1GameManager.simulateGame();
            System.out.println("\nSimulación del Nivel 2:");
            level2GameManager.simulateGame();
            System.out.println("\nSimulación del Nivel 3:");
            level3GameManager.simulateGame();
        }
    }    
}
