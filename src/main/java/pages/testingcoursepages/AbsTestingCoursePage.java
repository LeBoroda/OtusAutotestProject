package pages.testingcoursepages;

import org.openqa.selenium.WebDriver;
import pages.AbsPage;

import java.util.List;

public abstract class AbsTestingCoursePage extends AbsPage {
    public AbsTestingCoursePage(WebDriver driver, String path) {
        super(driver, path);
    }
    public void checkPageInformation(List<String> info) {

    }
}