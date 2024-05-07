public class Planet extends CosmicDanger {
    private boolean hasLife;

    public Planet(int distance, boolean hasLife) {
        super(distance, 0, null, hasLife ? 25 : 15, 25, 50); // Daño y penalidades específicas para planetas
        this.hasLife = hasLife;
    }

    public boolean hasLife() {
        return hasLife;
    }
}