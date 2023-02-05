package pages;

import org.openqa.selenium.WebDriver;

public class TestingCoursesCatalogPage extends AbsPage{
    public TestingCoursesCatalogPage(WebDriver driver) {
        super(driver, "/catalog/courses?categories=testing");
    }
}
