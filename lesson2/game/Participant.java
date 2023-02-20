package lesson2.game;

// что умеет делать участник
public interface Participant extends CanJump, CanRun, CanSwim {

    String getName();

}
