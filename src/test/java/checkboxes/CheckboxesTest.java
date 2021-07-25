package checkboxes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import pages.LoginPage;
import pages.SecureAreaPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void testCheckBoxes(){
        CheckboxPage checkboxPage= new CheckboxPage(webDriver);
        checkboxPage.selectLink();
        checkboxPage.selectCheck(CheckboxPage.checkboxTest1);
        checkboxPage.selectCheck(CheckboxPage.checkboxTest2);
    }
}
