package Tests.CalendarTests;

import Tests.BaseTest;
import Tests.Page.CalendarPage;
import org.junit.Test;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DeleteEvent extends BaseTest {

    @Test
    public void deleteEvent() throws InterruptedException {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CalendarPage calendar = new CalendarPage(androidDriver, wait);

        calendar.activateCalendarApp();
        calendar.clickNewEvent();
        calendar.clickMoreOptions();
        calendar.clickDeleteEvent();
        calendar.checkIfEventIsDeleted();

    }
}
