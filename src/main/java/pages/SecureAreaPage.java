package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecureAreaPage {
    private WebDriver webDriver;
    private By secureAreaMessage = By.xpath("/html/body/div[2]/div/div/h4");
    private By secureAreaAlert = By.id("flash");

    public SecureAreaPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public boolean isSecureAreaPageDisplayed(){
        WebElement element = webDriver.findElement(secureAreaMessage);
        return element.isDisplayed();
    }

    public String getSecureAreaMessage(){
        String alertDetail = webDriver.findElement(secureAreaAlert).getText();
        System.out.println(alertDetail);
        return alertDetail;

    }
}
