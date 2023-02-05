package pages.testingcoursepages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoadQAPage extends AbsTestingCoursePage{
    private final String courseNameSelector = "h1[class='course-header2__title']";
    private final String courseDescriptionSelector = "div[class='course-header2__admin-text']";
    private final String courseLengthSelector = "div.course-header2-bottom__content-item.container__col.container__col_4.container__col_md-4.container__col_ssm-12 > div.course-header2-bottom__content-item-text > div > p.course-header2-bottom__item-text";
    private final String courseFormatSelector = "div[class='course-header2-bottom__content-item container__col container__col_2 container__col_md-2 container__col_ssm-12'] div:nth-of-type(2) p";

    public LoadQAPage(WebDriver driver, String path) {
        super(driver, path);
    }
    @Override
    public void checkPageInformation(List<String> tileInfo){
        Assertions.assertEquals(tileInfo.get(0), $(By.cssSelector(this.courseNameSelector)).getText());
        Assertions.assertNotEquals("",$(By.cssSelector(this.courseDescriptionSelector)).getText());
        Assertions.assertEquals(tileInfo.get(1), $(By.cssSelector(this.courseLengthSelector)).getText());
        Assertions.assertNotEquals("", $(By.cssSelector(this.courseFormatSelector)).getText());
    }
}
