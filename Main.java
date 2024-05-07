import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
