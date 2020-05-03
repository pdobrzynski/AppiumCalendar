package Tests.CalendarTests;

import Tests.BaseTest;
import Tests.Page.CalendarPage;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ChangeRecurrenceToEveryWeek extends BaseTest {

    @Test
    public void changeRecurrenceToEveryWeek() {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CalendarPage calendar = new CalendarPage(androidDriver, wait);

        calendar.activateCalendarApp();
        calendar.clickNewEvent();
        calendar.clickEditEventButton();
        calendar.clickChangeRecurrence();
        calendar.setRecurrenceToEveryWeek();
        calendar.clickSaveNewEvent();
        calendar.confirmChangesForEvent();


    }
}
