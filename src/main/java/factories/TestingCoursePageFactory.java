package factories;

import data.TestCoursePageVersionData;
import org.openqa.selenium.WebDriver;
import pages.testingcoursepages.*;

public class TestingCoursePageFactory {

    private final WebDriver driver;
    private final String path;

    public TestingCoursePageFactory(WebDriver driver, String path){
        this.driver = driver;
        this.path = path;
    }

    private String getPageWersion(String path){
        String result = path
                .toUpperCase()
                .replaceAll(" ","")
                .replaceAll("-","");
        result = result.substring((result.lastIndexOf("/")+1));
        return result;
    }
    public AbsTestingCoursePage createTestingCoursePage(String path){
        String pageVersion = getPageWersion(path);
        AbsTestingCoursePage testingCoursePage = null;
        switch (TestCoursePageVersionData.valueOf(pageVersion)){
            case QALEAD:
                testingCoursePage = new QaLeadPage(driver, path);
                break;
            case QAENGINEER:
                testingCoursePage = new QaEngineerPage(driver, path);
                break;
            case JAVAQAPRO:
                testingCoursePage = new JavaQAProPage(driver, path);
                break;
            case AVTOMATIZACIYAWEBTESTIROVANIYA:
            case JAVAQABASIC:
            case QAJS:
            case KOTLINQAENGINEER:
            case TESTAUTOMATIONOPENSTACK:
                testingCoursePage = new AutomationWebTestingPage(driver, path);
                break;
            case LOADQA:
            case QAGAME:
                testingCoursePage = new LoadQAPage(driver, path);
                break;
            case QAAUTOJAVASPECIALIZATION:
                testingCoursePage = new QAAutoJavaSpecPage(driver, path);
                break;
            case MANUALTESTING:
                testingCoursePage = new ManualTestingPage(driver, path);
                break;

        }
        return testingCoursePage;
    }

}
