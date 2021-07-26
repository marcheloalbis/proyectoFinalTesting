package addRemoveTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemovePage;


public class AddRemoveTest extends BaseTest {

    @Test
    public void testSuccessfulAddElement(){
     AddRemovePage addRemovePage = new AddRemovePage(webDriver);
     addRemovePage.selectLink();
     addRemovePage.clickAddElement();
     Assert.assertTrue(addRemovePage.isAddRemovePageDisplayed());

    }
    @Test
    public void testSuccessfulRemoveElement(){
        AddRemovePage addRemovePage = new AddRemovePage(webDriver);
        addRemovePage.selectLink();
        addRemovePage.clickAddElement();
        addRemovePage.clickRemoveElement();
        Assert.assertFalse(addRemovePage.isAddRemovePageDisplayed());


    }

}
