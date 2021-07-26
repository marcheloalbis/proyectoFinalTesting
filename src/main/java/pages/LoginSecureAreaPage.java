package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

public class LoginSecureAreaPage {
    private WebDriver webDriver;
    private By secureAreaMessage = By.xpath("/html/body/div[2]/div/div/h4");
    private By secureAreaAlert = By.id("flash");

    public LoginSecureAreaPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public boolean isSecureAreaPageDisplayed(){
        try{
            webDriver.findElement(secureAreaMessage);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public String getSecureAreaMessage(){
        String alertDetail = webDriver.findElement(secureAreaAlert).getText();
        System.out.println(alertDetail);
        return alertDetail;

    }
}
