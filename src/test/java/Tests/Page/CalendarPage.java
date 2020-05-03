package Tests.Page;


import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalendarPage {

    private static final By CLICK_CREATE_NEW_EVENT_BUTTON = By.xpath("//android.widget.TextView[@text='Nothing planned. Tap to create.']");
    private static final By TITLE_OF_THE_EVENT_FIELD = By.id("com.google.android.calendar:id/title");
    private static final By ENTER_TITLE_NEW_EVENT_INPUT = By.id("com.google.android.calendar:id/input");
    private static final By SAVE_NEW_EVENT_BUTTON = By.id("com.google.android.calendar:id/save");
    private static final By DONE_EDITING_BUTTON = By.id("com.google.android.calendar:id/done");
    private static final By NEW_CREATED_EVENT = By.xpath("//android.view.View[@index='1']");
    private static final By ALL_DAY_CHANGED_NAME_EVENT = By.xpath("//android.view.View[@content-desc=\"All day: Changed Name\"]");
    private static final By MORE_OPTIONS_BUTTON = By.xpath("//android.widget.ImageButton[@content-desc=\"More options\"]");
    private static final By DELETE_EVENT_BUTTON = By.xpath("//android.widget.TextView[@text='Delete']");
    private static final By DELETE_ALL_FOLLOWING_EVENTS = By.xpath("//android.widget.CheckedTextView[@text='This and following events']");
    private static final By CONFIRM_DELETE_EVENT_BUTTON = By.id("android:id/button1");
    private static final By EDIT_EVENT_BUTTON = By.xpath("//android.widget.Button[@content-desc=\"Edit\"]/android.widget.ImageView");
    private static final By ALL_DAY_SWITCH = By.id("com.google.android.calendar:id/all_day_switch");
    private static final By EVENT_COLOR_BUTTON = By.id("com.google.android.calendar:id/color_text");
    private static final By YELLOW_COLOR_OF_EVENT = By.xpath("//android.widget.TextView[@text='Banana']");
    private static final By SET_RECURRENCE_BUTTON = By.id("com.google.android.calendar:id/recurrence_icon");
    private static final By SET_RECURRENCE_TO_EVERY_DAY = By.xpath("//android.widget.TextView[@text='Every day']");
    private static final By SET_RECURRENCE_TO_EVERY_WEEK = By.xpath("//android.widget.TextView[@text='Every week']");
    private static final By SET_RECURRENCE_TO_EVERY_MONTH = By.xpath("//android.widget.TextView[@text='Every month']");
    private static final By SET_RECURRENCE_TO_EVERY_YEAR = By.xpath("//android.widget.TextView[@text='Every year']");
    private static final By CLOSE_EVENT_BACK_TO_CALENDAR = By.xpath("//android.widget.Button[@content-desc=\"Close\"]/android.widget.ImageView");
    private static final By CONFIRM_CHANGES_FOR_ALL_FOLLOWING_EVENTS = By.xpath("//android.widget.TextView[@text='Change this and all following events']");
    private static final By SET_RECURRENCE_TO_CUSTOM = By.xpath("//android.widget.TextView[@text='Custom…']");
    private static final By CUSTOM_RECURRENCE_SATURDAY = By.xpath("//android.widget.ToggleButton[@text='SAT']");
    private static final By CUSTOM_RECURRENCE_SUNDAY = By.xpath("//android.widget.ToggleButton[@text='SUN']");


    public AndroidDriver androidDriver;

    public WebDriverWait wait;

    public CalendarPage(AndroidDriver androidDriver, WebDriverWait wait) {
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public void waitForScreenToLoad(By element, int seconds){

        WebDriverWait wait = new WebDriverWait(androidDriver, seconds);
        wait.until(ExpectedConditions.visibilityOf((androidDriver.findElement(element))));
    }
    public void activateCalendarApp() {
        androidDriver.activateApp("com.google.android.calendar");

    }

    public void clickCreateNewEvent() {
        androidDriver.findElement(CLICK_CREATE_NEW_EVENT_BUTTON).click();
    }

    public void clickChangedEvent() {
        androidDriver.findElement(ALL_DAY_CHANGED_NAME_EVENT).click();
    }

    public void enterTitleOfNewEvent() {
        waitForScreenToLoad(ENTER_TITLE_NEW_EVENT_INPUT, 5);
        androidDriver.findElement(ENTER_TITLE_NEW_EVENT_INPUT).click();
        androidDriver.findElement(ENTER_TITLE_NEW_EVENT_INPUT).sendKeys("Automated Test");
    }

    public void clickSaveNewEvent() {
        waitForScreenToLoad(SAVE_NEW_EVENT_BUTTON, 5);
        androidDriver.findElement(SAVE_NEW_EVENT_BUTTON).click();
    }

    public void checkIfNewEventIsCreated() throws InterruptedException {
        Thread.sleep(2000);
        boolean isNewEventDisplayed = androidDriver.findElement(NEW_CREATED_EVENT).isDisplayed();

        if (isNewEventDisplayed != true) {
            Assert.fail("New event wasn't created successfully.");
        }
        else
        {
            System.out.println("New event created properly.");
        }
    }

    public void clickNewEvent() {
        androidDriver.findElement(NEW_CREATED_EVENT).click();
    }

    public void clickMoreOptions() throws InterruptedException {
        Thread.sleep(2000);
        androidDriver.findElement(MORE_OPTIONS_BUTTON).click();
    }
    public void clickDeleteEvent() {
        androidDriver.findElement(DELETE_EVENT_BUTTON).click();
        androidDriver.findElement(DELETE_ALL_FOLLOWING_EVENTS).click();
        androidDriver.findElement(CONFIRM_DELETE_EVENT_BUTTON).click();
    }

    public void checkIfEventIsDeleted() throws InterruptedException {
        Thread.sleep(2000);
        boolean isNewEventDeleted = androidDriver.findElement(CLICK_CREATE_NEW_EVENT_BUTTON).isDisplayed();

        if (isNewEventDeleted != true) {
            Assert.fail("New event wasn't deleted successfully.");
        }
        else
        {
            System.out.println("New event deleted properly.");
        }
    }

    public void clickEditEventButton() {
        androidDriver.findElement(EDIT_EVENT_BUTTON).click();
    }

    public void switchAllDayToOn() {
        androidDriver.findElement(ALL_DAY_SWITCH).click();
        String isAllDaySwitchOn = androidDriver.findElement(ALL_DAY_SWITCH).getText();
        Assert.assertEquals("ON", isAllDaySwitchOn);
    }

    public void switchAllDayToOff() {
        androidDriver.findElement(ALL_DAY_SWITCH).click();
        String isAllDaySwitchOff = androidDriver.findElement(ALL_DAY_SWITCH).getText();
        Assert.assertEquals("OFF", isAllDaySwitchOff);
    }

    public void clickChangeEventColor() {
        String colorBeforeChange = androidDriver.findElement(EVENT_COLOR_BUTTON).getText();
        androidDriver.findElement(EVENT_COLOR_BUTTON).click();
        androidDriver.findElement(YELLOW_COLOR_OF_EVENT).click();
        String colorAfterChange = androidDriver.findElement(EVENT_COLOR_BUTTON).getText();
        Assert.assertNotEquals(colorBeforeChange, colorAfterChange);
    }

    public void clickChangeRecurrence() {
        androidDriver.findElement(SET_RECURRENCE_BUTTON).click();
    }

    public void setRecurrenceToEveryDay() {
        androidDriver.findElement(SET_RECURRENCE_TO_EVERY_DAY).click();
        boolean isRecurrenceSetToEveryDay = androidDriver.findElement(SET_RECURRENCE_TO_EVERY_DAY).isDisplayed();

        if (isRecurrenceSetToEveryDay != true) {
            Assert.fail("Recurrence is not set to 'Every day'.");
        }
    }

    public void setRecurrenceToEveryWeek() {
        androidDriver.findElement(SET_RECURRENCE_TO_EVERY_WEEK).click();
        boolean isRecurrenceSetToEveryWeek = androidDriver.findElement(SET_RECURRENCE_TO_EVERY_WEEK).isDisplayed();

        if (isRecurrenceSetToEveryWeek != true) {
            Assert.fail("Recurrence is not set to 'Every week'.");
        }
    }

    public void setRecurrenceToEveryMonth() {
        androidDriver.findElement(SET_RECURRENCE_TO_EVERY_MONTH).click();
        boolean isRecurrenceSetToEveryMonth = androidDriver.findElement(SET_RECURRENCE_TO_EVERY_MONTH).isDisplayed();

        if (isRecurrenceSetToEveryMonth != true) {
            Assert.fail("Recurrence is not set to 'Every month'.");
        }
    }

    public void setRecurrenceToEveryYear() {
        androidDriver.findElement(SET_RECURRENCE_TO_EVERY_YEAR).click();
        boolean isRecurrenceSetToEveryYear = androidDriver.findElement(SET_RECURRENCE_TO_EVERY_YEAR).isDisplayed();

        if (isRecurrenceSetToEveryYear != true) {
            Assert.fail("Recurrence is not set to 'Every year'.");
        }
    }

    public void setRecurrenceToWeekendOnly() {
        androidDriver.findElement(SET_RECURRENCE_TO_CUSTOM).click();
        char ch='"';

        String isSatChecked = androidDriver.findElement(CUSTOM_RECURRENCE_SATURDAY).getAttribute("checked");
        if ((ch + isSatChecked + ch).equals("\"false\"")) {
            androidDriver.findElement(CUSTOM_RECURRENCE_SATURDAY).click();
        } else {
            System.out.println("Saturday is already checked.");
        }
        String isSunChecked = androidDriver.findElement(CUSTOM_RECURRENCE_SUNDAY).getAttribute("checked");
        if ((ch + isSunChecked + ch).equals("\"false\"")) {
            androidDriver.findElement(CUSTOM_RECURRENCE_SUNDAY).click();
        } else {
            System.out.println("Sunday is already checked.");
        }
        androidDriver.findElement(DONE_EDITING_BUTTON).click();

    }

    public void closeEventBackToCalendar() {
        androidDriver.findElement(CLOSE_EVENT_BACK_TO_CALENDAR).click();
    }

    public void confirmChangesForEvent() {
        androidDriver.findElement(CONFIRM_CHANGES_FOR_ALL_FOLLOWING_EVENTS).click();
    }

    public void changeTitleOfEvent() {
        androidDriver.findElement(ENTER_TITLE_NEW_EVENT_INPUT).click();
        androidDriver.findElement(ENTER_TITLE_NEW_EVENT_INPUT).clear();
        androidDriver.findElement(ENTER_TITLE_NEW_EVENT_INPUT).sendKeys("Changed Name");
        androidDriver.findElement(SAVE_NEW_EVENT_BUTTON).click();
    }
    public void checkIfTitleOfEventChanged() {
        String isTitleChanged = androidDriver.findElement(TITLE_OF_THE_EVENT_FIELD).getText();
        Assert.assertEquals("Changed Name", isTitleChanged);
    }

}
