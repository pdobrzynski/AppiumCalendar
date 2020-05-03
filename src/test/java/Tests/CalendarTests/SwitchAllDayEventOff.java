package Tests.CalendarTests;

import Tests.BaseTest;
import Tests.Page.CalendarPage;
import org.junit.Test;

import java.util.concurrent.TimeUnit;


public class SwitchAllDayEventOff extends BaseTest {

    @Test
    public void switchAllDayEventOff() {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CalendarPage calendar = new CalendarPage(androidDriver, wait);

        calendar.activateCalendarApp();
        calendar.clickChangedEvent();
        calendar.clickEditEventButton();
        calendar.switchAllDayToOff();
        calendar.clickSaveNewEvent();
        calendar.closeEventBackToCalendar();

    }
}
