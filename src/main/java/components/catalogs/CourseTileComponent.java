package components.catalogs;

import components.AbsComponent;
import factories.TestingCoursePageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CourseTileComponent extends AbsComponent {
    private final String tileCourseInfoLocator = "//h6//following::div[2]//child::div";
    private final String tileCourseNameLocator = "//h6//child::div[1]";

    public CourseTileComponent(WebDriver driver) {
        super(driver);
    }

    public void checkCourseTile(String tileLocator, String pagePath) {
        String nameLocator = tileLocator + tileCourseNameLocator;
        String infoLocator = tileLocator + tileCourseInfoLocator;
        List<String> tileInfoList = getCourseTileInfo(nameLocator, infoLocator);
        $(By.xpath(tileLocator)).click();

        new TestingCoursePageFactory(driver, pagePath)
                .createTestingCoursePage(pagePath)
                .checkPageInformation(tileInfoList);
    }
    public List<String> getCourseTileInfo(String nameLocator, String infoLocator){

        String info = $(By.xpath(infoLocator)).getText();
        List<String> tileInfo = new ArrayList<>();
        tileInfo.add($(By.xpath(nameLocator)).getText());
        tileInfo.add(info.substring(info.indexOf("·")+1).trim());

        return tileInfo;
    }
}

