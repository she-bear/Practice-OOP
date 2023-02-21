package lesson2.game;

public class Cat extends BaseParticipant {

    // кот в конструктор не принимает swim
    public Cat(String name, int jump, int run, int dig) {
        // но вызывает родительский конструктор и передаёт в swim -1
        super(name, jump, run, -1, dig);
    }

}
