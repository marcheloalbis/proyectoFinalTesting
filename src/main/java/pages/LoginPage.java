package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver webDriver;

    private By linkTest = By.xpath("//*[@id=\"content\"]/ul/li[21]/a");
    private By userInput = By.id("username");
    private By passWordInput = By.id("password");
    private By loginButton = By.xpath("//*[@id=\"login\"]/button");
    private By errorMessage = By.id("flash");

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;

    }

    public void selectLink(){
        WebElement element = webDriver.findElement(linkTest);
        element.click();
    }

    public void typeUserName(String user){
        WebElement element = webDriver.findElement(userInput);
        element.sendKeys(user);
    }

    public void typePassWord(String passWord){
        WebElement element = webDriver.findElement(passWordInput);
        element.sendKeys(passWord);
    }

    public SecureAreaPage clickOnLoginButton(){
        WebElement element = webDriver.findElement(loginButton);
        element.click();
        return new SecureAreaPage(webDriver);
    }

    public SecureAreaPage loginAs(String user, String passWord){
        selectLink();
        typeUserName(user);
        typePassWord(passWord);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login");
        return clickOnLoginButton();
    }

    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
