package pages.testingcoursepages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ManualTestingPage extends AbsTestingCoursePage{
    private final String courseNameLocator = "//*[@id='__next']/div[2]/div[2]/div[1]/div/div[2]/div[1]/h3";
    private final String courseDescriptionLocator = "//*[@id='__next']/div[2]/div[2]/div[1]/div/div[2]/div[1]/h3//following::ul";
    private final String courseFormatLocator = "//h3[contains(text(),'Формат обучения')]";

    public ManualTestingPage(WebDriver driver, String path) {
        super(driver, path);
    }
    @Override
    public void checkPageInformation(List<String> tileInfo){
        try {
            Assertions.assertEquals(tileInfo.get(0), $(By.xpath(this.courseNameLocator)).getText());
        } catch (Exception ignored){

        }
        Assertions.assertEquals(tileInfo.get(0), $(By.xpath(this.courseNameLocator)).getText());
        Assertions.assertNotEquals("",$(By.xpath(this.courseDescriptionLocator)).getText());
        Assertions.assertNotEquals("", $(By.xpath(this.courseFormatLocator)).getText());
    }
}
