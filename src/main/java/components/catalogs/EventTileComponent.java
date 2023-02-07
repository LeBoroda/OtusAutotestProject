package components.catalogs;

import components.AbsComponent;
import data.CalendarData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class EventTileComponent extends AbsComponent {

    private final String dateSelectorTemplate = " span[class='dod_new-event__icon dod_new-event__calendar-icon']+span";
    private final String categoryNameSelector = "div[class ='dod_new-events__list js-dod_new_events'] div[class='dod_new-type__text']";
    private final String nowOnlineSelector = "span[class = 'dod_new-online-translation__status-text']";

    public EventTileComponent(WebDriver driver) {
        super(driver);
    }

    public LocalDate getEventDate(String tileSelector) {
        LocalDate result = null;
        String tileDateSelector = tileSelector + dateSelectorTemplate;
        String[] eventStringDate = $(By.cssSelector(tileDateSelector)).getText().split(" ");
        String dayNumber = eventStringDate[0];
        if (Integer.parseInt(dayNumber) < 10)
            dayNumber = String.format("%s%s", "0", dayNumber);
        String stringDate = String.format("2023-%s-%s", getMonthNumber(eventStringDate[1]), dayNumber);
        result = LocalDate.parse(stringDate);
        return result;
    }

    public String getEventCategory() {
        return $(By.cssSelector(categoryNameSelector)).getText();
    }

    private String getMonthNumber(String monthName) {
        String result = "";
        for (CalendarData month : CalendarData.values()) {
            if (month.getName().equals(monthName)) {
                return month.getNumber();
            }
        }
        return result;
    }
}
