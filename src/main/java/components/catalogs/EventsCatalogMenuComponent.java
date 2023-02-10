package components.catalogs;

import components.AbsComponent;
import data.EventsMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventsCatalogMenuComponent extends AbsComponent {
    private final String menuButtonSelector = ".dod_new-events-dropdown.js-dod_new_events-dropdown span";
    private final String openMenuSelector = "div[class*='dod_new-events-dropdown_opened']";
    private final String menuItemSelectorTemplate = "%s a[href$='%s/']";
    public EventsCatalogMenuComponent(WebDriver driver) {
        super(driver);
    }
    private String getMenuSelector(EventsMenuData eventsMenuData){
        String resultSelector = "";
        switch (eventsMenuData){
            case OPENDOORS:
                resultSelector = String.format(menuItemSelectorTemplate,openMenuSelector, eventsMenuData.getName());
        }
        return resultSelector;
    }
    public void clickEventsMenu(EventsMenuData eventsMenuData){
        $(By.cssSelector(menuButtonSelector)).click();
        waiter.waitForVisibility(By.cssSelector(openMenuSelector));
        $(By.cssSelector(getMenuSelector(eventsMenuData))).click();
        new EventTileComponent(driver);
    }
}
