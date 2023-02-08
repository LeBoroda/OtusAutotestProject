package pages.testingcoursepages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AutomationWebTestingPage extends AbsTestingCoursePage{
    private final String courseNameSelector = "div[class='course-header2__title']";
    private final String courseDescriptionSelector = "h1[class='course-header2__subtitle']";
    private final String courseLengthSelector = "div[class='course-header2-bottom__content-items'] div:nth-child(1) div:nth-child(2) p:nth-of-type(1)";
    private final String courseFormatSelector = "div[class='course-header2-bottom__content-item container__col container__col_2 container__col_md-2 container__col_ssm-12'] div:nth-of-type(2) p";
    private final String notifyWhenCourseStartsLocator = "//div[@class='course-header2__new']//button[contains(text(),'Сообщить о старте набора')]";
    public AutomationWebTestingPage(WebDriver driver, String path) {
        super(driver, path);
    }
    @Override
    public void checkPageInformation(List<String> tileInfo){
        Assertions.assertEquals(tileInfo.get(0), $(By.cssSelector(this.courseNameSelector)).getText());
        Assertions.assertNotEquals("",$(By.cssSelector(this.courseDescriptionSelector)).getText());
        Assertions.assertNotEquals("",$(By.cssSelector(this.courseLengthSelector)).getText());
        if(waiter.waitForCondition(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(notifyWhenCourseStartsLocator))))){
            Assertions.assertNotEquals("", $(By.cssSelector(this.courseFormatSelector)).getText());
        }

    }
}
