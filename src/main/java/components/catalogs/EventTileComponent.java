package components.catalogs;

import components.AbsComponent;
import data.CalendarData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class EventTileComponent extends AbsComponent {

    private final String dateSelectorTemplate = " .dod_new-event__calendar-icon.dod_new-event__icon+span";
    private final String categoryNameSelector = ".dod_new-events__list.js-dod_new_events div[class='dod_new-type__text']";
    private final String nowOnlineSelector = " span[class = 'dod_new-online-translation__status-text']";

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

    public LocalDate getCurrentEventDate(String tileSelector){
        LocalDate result = null;
        String tileDateSelector = tileSelector+nowOnlineSelector;
        String eventDate = $(By.cssSelector(tileDateSelector)).getText();
        if(eventDate.equals("Сейчас в эфире"))
            result = LocalDate.now();
        return result;
    }

    public String getEventCategory() {
        return $(By.cssSelector(categoryNameSelector)).getText();
    }

    private String getMonthNumber(String monthName) {
        Stream<CalendarData> calDat = Arrays.stream(CalendarData.values());
        return calDat.filter(month -> month.getName().equals(monthName)).findFirst().get().getNumber();
    }
}
