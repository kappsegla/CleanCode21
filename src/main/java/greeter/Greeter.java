package greeter;

public class Greeter {

    private TimeProvider timeProvider;
    public Greeter(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String greet() {
        if(timeProvider.currentTime().getHour() < 12)
            return "God morgon.";
        else if( timeProvider.currentTime().getHour() >= 18)
            return "God kväll.";
        return "God dag.";
    }
}
