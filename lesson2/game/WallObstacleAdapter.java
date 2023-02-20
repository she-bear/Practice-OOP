package lesson2.game;

// адаптер нужен, чтобы связать стену и интерфейс Obstacle

public class WallObstacleAdapter implements Obstacle {

    private final Wall wall;

    public WallObstacleAdapter(Wall wall) {
        this.wall = wall;
    }

    // @Override показывает, что метод будет переопределен из родительского класса
    @Override
    public boolean pass(Participant participant) {
        return wall.pass(participant);
    }
}
