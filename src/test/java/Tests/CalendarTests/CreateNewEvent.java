package Tests.CalendarTests;

import Tests.BaseTest;
import Tests.Page.CalendarPage;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CreateNewEvent extends BaseTest {

    @Test
    public void createNewEvent() throws InterruptedException {

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        CalendarPage calendar = new CalendarPage(androidDriver, wait);

        calendar.activateCalendarApp();
        calendar.clickCreateNewEvent();
        calendar.enterTitleOfNewEvent();
        calendar.clickSaveNewEvent();
        calendar.checkIfNewEventIsCreated();

    }

}
