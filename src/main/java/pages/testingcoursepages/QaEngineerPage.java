package pages.testingcoursepages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class QaEngineerPage extends AbsTestingCoursePage{

    private final String courseNameLocator = "//div[@id='__next']//following::section[2]//child::h1[1]";
    private final String courseDescriptionLocator = "//div[@id='__next']//following::section[2]//child::h1[1]//following::div[1]";
    private final String courseLengthLocator = "//div[@id='__next']//following::section[2]/child::div[3]//div[3]/p";
    private final String courseFormatLocator = "//div[@id='__next']//following::section[2]/child::div[3]//div[4]/p";
    public QaEngineerPage(WebDriver driver, String path) {
        super(driver, path);
    }

    @Override
    public void checkPageInformation(List<String> tileInfo){
        Assertions.assertEquals(tileInfo.get(0), $(By.xpath(this.courseNameLocator)).getText());
        Assertions.assertNotEquals("",$(By.xpath(this.courseDescriptionLocator)).getText());
        Assertions.assertEquals(tileInfo.get(1), $(By.xpath(this.courseLengthLocator)).getText());
        Assertions.assertNotEquals("", $(By.xpath(this.courseFormatLocator)).getText());
    }

}
