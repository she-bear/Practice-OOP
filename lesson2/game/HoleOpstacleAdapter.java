package lesson2.game;

public class HoleOpstacleAdapter implements Obstacle {
    
    private final Hole hole;

    public HoleOpstacleAdapter(Hole hole) {
        this.hole = hole;
    }

    @Override
    public boolean pass(Participant participant) {
        return hole.pass(participant);
    }
}
