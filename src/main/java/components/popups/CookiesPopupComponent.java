package components.popups;

import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CookiesPopupComponent extends AbsComponent {

    private final String cookiesPopupLocator = "//*[contains (text(),'Посещая наш сайт, вы принимаете')]";
    private final String cookiesAcceptButtonLocator = "//*[contains (text(),'Посещая наш сайт, вы принимаете')]//following::button";
    public CookiesPopupComponent(WebDriver driver) {
        super(driver);
    }
    public void closeCookiesPopup(){
        waiter.waitForVisibility(By.xpath(cookiesPopupLocator));
        $(By.xpath(cookiesAcceptButtonLocator)).click();
    }
}
