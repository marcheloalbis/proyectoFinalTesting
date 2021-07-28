package checkboxes;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import org.testng.Assert;

public class CheckboxesTest extends BaseTest {

    @Test
    public void testCheckBoxes1(){
        CheckboxPage checkboxPage= new CheckboxPage(webDriver);
        checkboxPage.selectLink();
        checkboxPage.selectCheck(CheckboxPage.checkboxTest1);
        Assert.assertTrue(checkboxPage.isChecked(CheckboxPage.checkboxTest1));
    }

    @Test
    public void testCheckBoxes2(){
        CheckboxPage checkboxPage= new CheckboxPage(webDriver);
        checkboxPage.selectLink();
        checkboxPage.selectCheck(CheckboxPage.checkboxTest2);
        Assert.assertFalse(checkboxPage.isChecked(CheckboxPage.checkboxTest2));
    }
}
