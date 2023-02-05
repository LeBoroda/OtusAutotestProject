package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EventsPage extends AbsPage{
    public EventsPage(WebDriver driver) {
        super(driver, "/events/near/");
    }

    public void scrollPage(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        try {
            long lastHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");

            while (true) {
                jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(1000);

                long newHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
