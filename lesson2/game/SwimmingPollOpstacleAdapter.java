package lesson2.game;

public class SwimmingPollOpstacleAdapter implements Obstacle {
    
    private final SwimmingPoll swimmingpoll;

    public SwimmingPollOpstacleAdapter(SwimmingPoll swimmingpoll) {
        this.swimmingpoll = swimmingpoll;
    }

    @Override
    public boolean pass(Participant participant) {
        return swimmingpoll.pass(participant);
    }
}
