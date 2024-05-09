package GameObject;

public class CosmicDanger extends CosmicObject {
    protected Spacecraft spacecraft; // Agregar esta línea
    private int lifeCapsulesPenalty;
    private int missilesPenalty;
    
    public int getLifeCapsulesPenalty() {
        return lifeCapsulesPenalty;
    }

    public void setLifeCapsulesPenalty(int lifeCapsulesPenalty) {
        this.lifeCapsulesPenalty = lifeCapsulesPenalty;
    }

    public int getMissilesPenalty() {
        return missilesPenalty;
    }

    public void setMissilesPenalty(int missilesPenalty) {
        this.missilesPenalty = missilesPenalty;
    }

    public CosmicDanger(int distance, int speed, Spacecraft spacecraft, int damage, int lifeCapsulesPenalty, int missilesPenalty) {
        this.distance = distance;
        this.speed = speed;
        this.spacecraft = spacecraft;
        this.damage = damage;
        this.lifeCapsulesPenalty = lifeCapsulesPenalty;
        this.missilesPenalty = missilesPenalty;
    }
}