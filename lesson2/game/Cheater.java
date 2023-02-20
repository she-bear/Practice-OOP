package lesson2.game;

public class Cheater extends BaseParticipant {


    // Integer.MAX_VALUE - самое большое значение для типа Int
    public Cheater(String name) {
        super(name, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

}
