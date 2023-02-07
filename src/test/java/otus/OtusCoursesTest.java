package otus;

import components.popups.CookiesPopupComponent;
import components.NavigationBlock;
import components.catalogs.CoursesCatalogComponent;
import data.NavigationMenuData;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class OtusCoursesTest {

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
    public void testOtusTestingCourses(){
        new MainPage(driver)
                .open();
        new NavigationBlock(driver)
                .clickTestingNavButton(NavigationMenuData.TESTING);
        new CookiesPopupComponent(driver)
                .closeCookiesPopup();
        new CoursesCatalogComponent(driver)
                .checkNumberOfCourses(12)
                .checkAllCourseTiles();
    }

}
