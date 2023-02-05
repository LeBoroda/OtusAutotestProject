package components;

import data.menu.HeaderMenuItemsData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenuComponent extends AbsComponent{
    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }

    public void moveToHeaderItem(HeaderMenuItemsData headerMenuItemsData){
        String selector = String.format("[data-name='%s'].header3__nav-item", headerMenuItemsData.getName());
        actions
                .moveToElement($(By.cssSelector(selector)))
                .build()
                .perform();
    }

}
