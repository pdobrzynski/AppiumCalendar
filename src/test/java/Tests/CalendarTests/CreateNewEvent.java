package Tests.CalendarTests;

import Tests.BaseTest;
import Tests.Page.CalendarPage;
import org.junit.Test;

public class CreateNewEvent extends BaseTest {

    @Test
    public void createNewEvent() throws InterruptedException {

        CalendarPage calendar = new CalendarPage(androidDriver, wait);

        calendar.activateCalendarApp();
        calendar.waitForLoadingApp();
        calendar.clickCreateNewEvent();
        calendar.enterTitleOfNewEvent();
        calendar.clickSaveNewEvent();
        calendar.checkIfNewEventIsCreated();


    }

}
