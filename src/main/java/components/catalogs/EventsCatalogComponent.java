package components.catalogs;

import components.AbsComponent;
import data.EventsMenuData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.List;

public class EventsCatalogComponent extends AbsComponent {
    private final String eventsCatalogSelector = "div[class='dod_new-events__list js-dod_new_events']";
    public EventsCatalogComponent(WebDriver driver) {
        super(driver);
    }
    public void checkEventTileDate(){
        List<WebElement> eventsList = $$(By.cssSelector(eventsCatalogSelector));
        for(int i=1; i<=eventsList.size(); i++) {
            String eventTileSelector = eventsCatalogSelector + " a:nth-child(" + i + ")";
            LocalDate eventDate = new EventTileComponent(driver).getEventDate(eventTileSelector);
            LocalDate todayDate = LocalDate.now();
            Assertions.assertFalse(eventDate.isBefore(todayDate));
        }
    }
    public void checkEventTileCategory(EventsMenuData eventsMenuData){
        List<WebElement> eventsList = $$(By.cssSelector(eventsCatalogSelector));
        String categoryName = getCategoryName(eventsMenuData);
        for(int i=1; i<=eventsList.size(); i++) {
            Assertions.assertEquals(categoryName,new EventTileComponent(driver).getEventCategory());
        }
    }
    private String getCategoryName(EventsMenuData eventsMenuData){
        String result ="";

        switch (eventsMenuData){
            case OPENDOORS:
                result = eventsMenuData.getCategoryNameOnTile();
        }
        return result;
    }
}
