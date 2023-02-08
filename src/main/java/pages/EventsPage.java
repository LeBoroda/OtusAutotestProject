package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EventsPage extends AbsPage {
    public EventsPage(WebDriver driver) {
        super(driver, "/events/near/");
    }

    public void scrollPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String loaderSelector = "div[class*='dod_new-loader-wrapper_visible']";

        long lastHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");

        for (int i = 0; i < 100; i++) {
            jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loaderSelector)));
            waiter.waitForCondition(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loaderSelector))));
            long newHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
    }
}
