package lesson2.game;

// препятствие
public interface Obstacle {

    // можно передать любой класс, имплементирующий интерфейс Participant
    boolean pass(Participant participant);

}
