package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage {
    private WebDriver webDriver;
    public static By linkTest = By.xpath("//*[@id=\"content\"]/ul/li[6]/a");
    public static By checkboxTest1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    public static By checkboxTest2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");

    public CheckboxPage(WebDriver webDriver){
        this.webDriver = webDriver;

    }

    public void selectLink(){
        WebElement element = webDriver.findElement(linkTest);
        element.click();
    }
    public void selectCheck(By checkbox){
        WebElement element = webDriver.findElement(checkbox);
        element.click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "checkbox");
    }
    
    public boolean isChecked(By checkbox){
        WebElement element = webDriver.findElement(checkbox);
        boolean isChecked=Boolean.valueOf(element.getAttribute("checked"));
       // isChecked =Boolean.valueOf(webDriver.findElement(checkbox).getAttribute("checked"));
        return isChecked;

    }

}
