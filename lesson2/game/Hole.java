package lesson2.game;

// класс Нора взаимодействует только с теми, кто умеет копать (CanDig)
public class Hole {

    private final int depth;

    public Hole(int depth) {
        this.depth = depth;
    }

    public boolean pass(CanDig canDig) {
        return canDig.getDig() >= depth;
    }
    
    
}
