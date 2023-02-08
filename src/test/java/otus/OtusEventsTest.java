package otus;

import components.HeaderMenuComponent;
import components.catalogs.EventsCatalogComponent;
import components.catalogs.EventsCatalogMenuComponent;
import components.popups.HeaderMenuPopup;
import data.EventsMenuData;
import data.menu.HeaderSubSubMenuEventsData;
import data.menu.HeaderMenuItemsData;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;
import pages.MainPage;

public class OtusEventsTest {

    private WebDriver driver;
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void init() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().createDriver();
    }
    @AfterEach
    public void close(){
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void testOtusEvents(){
        new MainPage(driver)
                .open();

        HeaderMenuPopup headerMenuPopup = new HeaderMenuPopup(driver);
        headerMenuPopup
                .popUpShouldNotBeVisible(HeaderMenuItemsData.LEARNING);

        new HeaderMenuComponent(driver)
                .moveToHeaderItem(HeaderMenuItemsData.LEARNING);

        headerMenuPopup
                .popUpShouldBeVisible(HeaderMenuItemsData.LEARNING);
        headerMenuPopup
                .clickMenuItemByName(HeaderSubSubMenuEventsData.EVENTS);

        new EventsPage(driver)
                .scrollPage();

        EventsCatalogComponent eventsCatalog = new EventsCatalogComponent(driver);
        eventsCatalog
                .checkEventTileDate();

        new EventsCatalogMenuComponent(driver)
                .clickEventsMenu(EventsMenuData.OPENDOORS);

        eventsCatalog
                .checkEventTileCategory(EventsMenuData.OPENDOORS);
    }
}
