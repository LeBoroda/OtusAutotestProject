package components.catalogs;

import components.AbsComponent;
import data.EventsMenuData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.List;

public class EventsCatalogComponent extends AbsComponent {
    private final String scheduledEventsCatalogSelector = "div[class='dod_new-events__list js-dod_new_events']";
    private final String onlineEventsCatalogSelector = "section[class='dod_new-events dod_new-online-translations js-online-translations']";
    public EventsCatalogComponent(WebDriver driver) {
        super(driver);
    }
    public void checkEventTileDate(){
        checkScheduledEventTileDate(scheduledEventsCatalogSelector);
        checkCurrentEventTileDate(onlineEventsCatalogSelector);
    }
    public void checkScheduledEventTileDate(String eventsSelector){
        List<WebElement> eventsList = $$(By.cssSelector(eventsSelector));
        for(int i=1; i<=eventsList.size(); i++) {
            String eventTileSelector = eventsSelector + " a:nth-child(" + i + ")";
            LocalDate eventDate = new EventTileComponent(driver).getEventDate(eventTileSelector);
            LocalDate todayDate = LocalDate.now();
            Assertions.assertFalse(eventDate.isBefore(todayDate));
        }
    }
    public void checkCurrentEventTileDate(String onlineEventsSelector){
        boolean isAnythingOnline = waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(onlineEventsCatalogSelector)));
        if(isAnythingOnline){
            List<WebElement> eventsList = $$(By.cssSelector(onlineEventsSelector));
            for(int i=1; i<=eventsList.size(); i++) {
                String eventTileSelector = onlineEventsSelector + " a:nth-child(" + i + ")";
                LocalDate eventDate = new EventTileComponent(driver).getEventDate(eventTileSelector);
                LocalDate todayDate = LocalDate.now();
                Assertions.assertFalse(eventDate.isEqual(todayDate));
            }
        }
    }
    public void checkEventTileCategory(EventsMenuData eventsMenuData){
        List<WebElement> eventsList = $$(By.cssSelector(scheduledEventsCatalogSelector));
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
