package testdemo.testable.timeofday;

import java.time.LocalDateTime;

public class SmartHomeController {

    public LocalDateTime lastMotionTime;
    private LocalDateTimeProvider localDateTimeProvider;
    private BackyardLightSwitcher backyardLightSwitcher;

    //This makes us backward compatible for older clients.
    @Deprecated
    public SmartHomeController() {
        localDateTimeProvider = new ActualLocalDateTime();
        backyardLightSwitcher = BackyardLightSwitcher.getInstance();
    }

    public SmartHomeController(LocalDateTimeProvider localDateTimeProvider, BackyardLightSwitcher backyardLightSwitcher) {
        this.localDateTimeProvider = localDateTimeProvider;
        this.backyardLightSwitcher = backyardLightSwitcher;
    }

    //This is a public api, can't change signature of method
    public void actuateLights(boolean motionDetected, Runnable turnOn, Runnable turnOff)
    {
        //LocalDateTime time = LocalDateTime.now();
        LocalDateTime time = localDateTimeProvider.getDateTime();

        // Update the time of last motion.
        if (motionDetected)
        {
            lastMotionTime = time;
        }

        // If motion was detected in the evening or at night, turn the light on.
        String timeOfDay = TimeOfDay.getTimeOfDay(time);
        if (motionDetected && (timeOfDay.equals("Evening") || timeOfDay.equals("Night")))
        {
           //backyardLightSwitcher.turnOn();
           turnOn.run();
        }
        else if ( (timeOfDay.equals("Morning") || timeOfDay.equals("Noon")))
        {
            //backyardLightSwitcher.turnOff();
            turnOff.run();
        }
    }
}
