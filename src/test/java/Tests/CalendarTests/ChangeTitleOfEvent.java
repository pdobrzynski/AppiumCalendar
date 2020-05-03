package Tests.CalendarTests;

import Tests.BaseTest;
import Tests.Page.CalendarPage;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ChangeTitleOfEvent extends BaseTest {

    @Test
    public void changeTitleOfEvent() {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CalendarPage calendar = new CalendarPage(androidDriver, wait);

        calendar.activateCalendarApp();
        calendar.clickNewEvent();
        calendar.clickEditEventButton();
        calendar.changeTitleOfEvent();
        calendar.closeEventBackToCalendar();
        calendar.clickNewEvent();
        calendar.checkIfTitleOfEventChanged();
        calendar.closeEventBackToCalendar();

    }
}
