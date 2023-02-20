package lesson2.game;

public class StandardParticipant extends BaseParticipant {
    // обычный участник не умеет копать
    public StandardParticipant(String name, int jump, int run, int swim) {
        super(name, jump, run, swim, -1);
    }

}
