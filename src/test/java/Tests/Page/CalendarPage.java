package Tests.Page;


import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalendarPage {
    private static final By CLICK_CREATE_NEW_EVENT_BUTTON = By.xpath("//android.widget.TextView[@text='Nothing planned. Tap to create.']");
    private static final By JUMP_TO_TODAY_BUTTON = By.id("com.google.android.calendar:id/action_today");
    private static final By ENTER_TITLE_NEW_EVENT_FIELD = By.id("com.google.android.calendar:id/input");
    private static final By SAVE_NEW_EVENT_BUTTON = By.id("com.google.android.calendar:id/save");
    private static final By DONE_EDITING_BUTTON = By.id("com.google.android.calendar:id/save");
    private static final By NEW_CREATED_EVENT = By.xpath("//android.view.View[@index='1']");

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
    public void waitForLoadingApp() {
        waitForScreenToLoad(CLICK_CREATE_NEW_EVENT_BUTTON, 10);
    }
    public void clickCreateNewEvent() {
        androidDriver.findElement(CLICK_CREATE_NEW_EVENT_BUTTON).click();
    }
    public void enterTitleOfNewEvent() {
        waitForScreenToLoad(ENTER_TITLE_NEW_EVENT_FIELD, 5);
        androidDriver.findElement(ENTER_TITLE_NEW_EVENT_FIELD).click();
        androidDriver.findElement(ENTER_TITLE_NEW_EVENT_FIELD).sendKeys("Automated Test");
    }
    public void clickSaveNewEvent() {
        waitForScreenToLoad(SAVE_NEW_EVENT_BUTTON, 5);
        androidDriver.findElement(SAVE_NEW_EVENT_BUTTON).click();
    }
    public void checkIfNewEventIsCreated() throws InterruptedException {
        Thread.sleep(5000);
        boolean isNewEventDisplayed = androidDriver.findElement(NEW_CREATED_EVENT).isDisplayed();
        if (isNewEventDisplayed != true) {
            Assert.fail("New event wasn't created successfully");
        }
        else
        {
            System.out.println("New event created properly");
        }
    }
}
