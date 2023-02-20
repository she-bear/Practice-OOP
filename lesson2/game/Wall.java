package lesson2.game;

// после введения адаптера WallObstacleAdapter убрана зависимость стены (Wall) от участника (Participant)
// теперь стену может использовать всё, что умеет прыгать (CanJump)

public class Wall {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    // стена работает с любым участником, который умеет прыгать
    public boolean pass(CanJump canJump) {
        return canJump.getJump() >= height;
    }

}
