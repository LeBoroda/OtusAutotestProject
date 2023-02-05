package pages.testingcoursepages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class QAAutoJavaSpecPage extends AbsTestingCoursePage{
    private final String courseNameSelector = "h1[field='tn_text_1669786279403']";
    private final String courseDescriptionSelector = "div[field='tn_text_1613568032880']";
    private final String courseLengthSelector = "div [class='t396__elem tn-elem tn-elem__3306785901613568879568'] div[field='tn_text_1613568879568']";
    private final String courseFormatSelector = "div [class='t396__elem tn-elem tn-elem__3306785901613568950972'] div[field='tn_text_1613568950972']";
    public QAAutoJavaSpecPage(WebDriver driver, String path) {
        super(driver, path);
    }
    @Override
    public void checkPageInformation(List<String> tileInfo){
        String courseName = tileInfo.get(0).substring(tileInfo.get(0).indexOf("Q"));
        Assertions.assertEquals(courseName, $(By.cssSelector(this.courseNameSelector)).getText().replaceAll("\n"," "));
        Assertions.assertNotEquals("",$(By.cssSelector(this.courseDescriptionSelector)).getText());
        Assertions.assertEquals(tileInfo.get(1), $(By.cssSelector(this.courseLengthSelector)).getText().replaceAll("Длительность обучения: ",""));
        Assertions.assertNotEquals("", $(By.cssSelector(this.courseFormatSelector)).getText());
    }
}
