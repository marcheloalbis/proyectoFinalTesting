package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRemovePage {
    protected WebDriver webDriver;
    private By linkAddRemove=By.xpath("//*[@id='content']/ul/li[2]/a");
    private By AddEle= By.xpath("//*[@id='content']/div/button");
    private By DeleteEle= By.className("added-manually");//By.xpath("//*[@id='elements']/button");


    public AddRemovePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void selectLink(){
        WebElement element = webDriver.findElement(linkAddRemove);
        element.click();
    }
    public void clickAddElement(){
        webDriver.findElement(AddEle).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "AddELement");
    }
    public void clickRemoveElement(){
        webDriver.findElement(DeleteEle).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "RemoveElement");
    }

    public boolean isAddRemovePageDisplayed(){
        try{
            webDriver.findElement(DeleteEle);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }


    }

}
