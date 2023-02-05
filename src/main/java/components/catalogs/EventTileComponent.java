package components.catalogs;

import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class EventTileComponent extends AbsComponent {

    private final String dateSelectorTemplate = " span[class='dod_new-event__icon dod_new-event__calendar-icon']+span";
    private final String categoryNameSelector = "div[class='dod_new-type__text']";
    public EventTileComponent(WebDriver driver) {
        super(driver);
    }

    public LocalDate getEventDate(String tileSelector){
        String tileDateSelector = tileSelector+dateSelectorTemplate;
        String[] eventStringDate = $(By.cssSelector(tileDateSelector)).getText().split(" ");
        String dayNumber = eventStringDate[0];
        if(Integer.parseInt(dayNumber)<10)
            dayNumber = String.format("%s%s","0",dayNumber);
        String stringDate = String.format("2023-%s-%s",getMonthNumber(eventStringDate[1]) , dayNumber);
        return LocalDate.parse(stringDate);
    }

    public String getEventCategory(){
        return $(By.cssSelector(categoryNameSelector)).getText();
    }

    private String getMonthNumber(String monthName){
        switch (monthName) {
            case "января":
               return  "01";
            case "февраля":
                return "02";
            case "марта":
                return "03";
            case "апреля":
                return "04";
            case "мая":
                return "05";
            case "июня":
                return "06";
            case "июля":
                return "07";
            case "августа":
                return "08";
            case "сентября":
                return "09";
            case "октября":
                return "10";
            case "ноября":
                return "11";
            default:
                return "12";
        }
    }
}
