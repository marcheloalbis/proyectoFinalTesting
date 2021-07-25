package base;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import report.ReportManager;

public abstract class BaseTest {
    protected WebDriver webDriver;
    private String url = "https://the-internet.herokuapp.com/";
    private String browser = "chrome";

    @BeforeSuite
    public static void setUpSuite() throws Exception {
        ReportManager.init("C:\\Reports", "LoginSite");
    }

    @BeforeMethod
    public void setUp(ITestResult iTestResult) throws Exception {
        ReportManager.getInstance().startTest(iTestResult.getMethod().getMethodName());

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new Exception(browser + " no soportado");
        }
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        try {
            switch (iTestResult.getStatus()){
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if(iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null){
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.FAIL, "Failure Image");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(webDriver != null)
                webDriver.quit();
        }
    }

    @AfterSuite
    public static void tearDownSuite(){
        ReportManager.getInstance().flush();
    }
}
