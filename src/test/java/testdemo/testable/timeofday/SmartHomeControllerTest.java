package testdemo.testable.timeofday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartHomeControllerTest {

    @Test
    void actuateLigthsWhenMotionDetectedAndNight() {
        LocalDateTimeProvider localDateTimeProvider = new NightDateTimeProvider();
        SmartHomeController smartHomeController = new SmartHomeController(localDateTimeProvider,BackyardLightSwitcher.getInstance());
        BackyardLightSwitcher backyardLightSwitcher = BackyardLightSwitcher.getInstance();

        //Write rest of test...
        smartHomeController.actuateLights(true, backyardLightSwitcher::turnOn,backyardLightSwitcher::turnOff);

    }

}