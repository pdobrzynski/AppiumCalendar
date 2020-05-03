package Tests.CalendarTests;

import Tests.BaseTest;
import Tests.Page.CalendarPage;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class SwitchAllDayEventOn extends BaseTest {

    @Test
    public void switchAllDayEventOff() {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CalendarPage calendar = new CalendarPage(androidDriver, wait);

        calendar.activateCalendarApp();
        calendar.clickNewEvent();
        calendar.clickEditEventButton();
        calendar.switchAllDayToOn();
        calendar.clickSaveNewEvent();
        calendar.closeEventBackToCalendar();

    }
}
