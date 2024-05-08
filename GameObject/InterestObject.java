package GameObject;

public abstract class InterestObject extends CosmicObject {
    protected int capsules;
    protected int distanceLimit;

    public InterestObject(int speed, int capsules, int distanceLimit) {
        this.speed = speed;
        this.capsules = capsules;
        this.distanceLimit = distanceLimit;
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