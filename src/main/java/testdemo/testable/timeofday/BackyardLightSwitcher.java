package testdemo.testable.timeofday;

public class BackyardLightSwitcher {
    private BackyardLightSwitcher(){}

    private static final BackyardLightSwitcher singelton = new BackyardLightSwitcher();

    public static BackyardLightSwitcher getInstance() {
        return singelton;
    }

    public void turnOn() {

    }

    public void turnOff() {

    }
}
