package components.catalogs;

import components.AbsComponent;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CoursesCatalogComponent extends AbsComponent {
    private final String coursesCatalogLocator = "//div[contains(text(), 'Каталог')]//ancestor::section//child::a";
    private final String expandButtonLocator = "//button[contains(.,'Показать еще')]";
    private List<WebElement> testingCoursesList = new ArrayList<>();
    public CoursesCatalogComponent(WebDriver driver) {
        super(driver);
    }
    void expandCatalogue(){
        $(By.xpath(expandButtonLocator)).click();
    }

    public CoursesCatalogComponent checkNumberOfCourses(int expectedNumber){
        if(expectedNumber>10){
            expandCatalogue();
        }
        testingCoursesList = $$(By.xpath(coursesCatalogLocator));
        Assertions.assertEquals(expectedNumber, testingCoursesList.size());
        return this;
    }

    public void checkAllCourseTiles(){
        for(int i=1; i<=testingCoursesList.size(); i++){
            String tileLocator = String.format("%s[%d]", coursesCatalogLocator, i);
            if(i>10){
                expandCatalogue();
                waiter.waitForCondition(ExpectedConditions.attributeContains(By.xpath(tileLocator),"href", tileLocator));
                waiter.waitForCondition(ExpectedConditions.elementToBeClickable(By.xpath(tileLocator)));
            }
            String hrefAttribute = $(By.xpath(tileLocator)).getAttribute("href");
            new CourseTileComponent(driver).checkCourseTile(tileLocator, hrefAttribute);
            driver.navigate().back();
        }
    }

}
