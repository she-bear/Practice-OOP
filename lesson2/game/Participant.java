package lesson2.game;

// что умеет делать участник
// объединили три интерфейса и добавили функцию
public interface Participant extends CanJump, CanRun, CanSwim, CanDig {

    String getName();

}
