package components;

import data.NavigationMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBlock extends AbsComponent{
    public String navMenuItemSelector = "#categories_id a[title='%s']";
    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    public void clickTestingNavButton(NavigationMenuData navigationMenuData){
        String navButtonSelector = String.format(navMenuItemSelector, navigationMenuData.getName());
        $(By.cssSelector(navButtonSelector)).click();
    }


}
