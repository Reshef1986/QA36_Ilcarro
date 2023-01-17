package tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();

        }


    }

    @Test
    public void loginSuccess()  {

        app.getHelperUser().openFormLogin();

        app.getHelperUser().fillLoginForm("reshef1986@gmail.com", "Rr6146858!");
        app.getHelperUser().submit();

        System.out.println(app.getHelperUser().getMessage());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");

    }

    @Test
    public void loginSuccessModel()  {

        User user = new User().withEmail("reshef1986@gmail.com").withPassword("Rr6146858!");

        app.getHelperUser().openFormLogin();

        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        System.out.println(app.getHelperUser().getMessage());
       Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        
    }

    @Test
    public void loginWrongEmail() {

        User user = new User().withEmail("reshef1986gmail.com").withPassword("Rr6146858!");

        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        System.out.println(app.getHelperUser().getErrorText());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void loginWrongPassword() {
        User user = new User().withEmail("reshef1986@gmail.com").withPassword("R");
        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        System.out.println(app.getHelperUser().getMessage());
        Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
    }

    @Test(enabled = false)
    public void loginUnregisterUser() {

    }

    @AfterMethod

    public void postCondition()  {
app.getHelperUser().pause(2000);
        app.getHelperUser().closeDialogContainer();

    }


}
