public class CapsuleObject extends InterestObject {
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