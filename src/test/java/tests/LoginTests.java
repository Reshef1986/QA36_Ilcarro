package tests;

import manager.ListenerTNG;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenerTNG.class)
public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Мне требовалась сделать выход");

        }


    }

    @Test
    public void loginSuccess()  {
logger.info("Лигин с допустиммыми данными : reshef1986@gmail.com - Rr6146858!");
        app.getHelperUser().openFormLogin();

        app.getHelperUser().fillLoginForm("reshef1986@gmail.com", "Rr6146858!");
        app.getHelperUser().submit();

        System.out.println(app.getHelperUser().getMessage());
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
logger.info("Tests success");
    }

    @Test
    public void loginSuccessModel()  {
        logger.info("Лигин с допустиммыми данными : reshef1986@gmail.com - Rr6146858!");
        User user = new User().withEmail("reshef1986@gmail.com").withPassword("Rr6146858!");

        app.getHelperUser().openFormLogin();

        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        System.out.println(app.getHelperUser().getMessage());
       Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Tests success");
    }

    @Test
    public void loginWrongEmail() {
        logger.info("Лигин с недопустиммым имелом : reshef1986gmail.com - Rr6146858!");
        User user = new User().withEmail("reshef1986gmail.com").withPassword("Rr6146858!");

        app.getHelperUser().openFormLogin();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        System.out.println(app.getHelperUser().getErrorText());
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
        logger.info("Tests success");
    }

    @Test
    public void loginWrongPassword() {
        logger.info("Лигин с недопустиммым маленьким паролем  : reshef1986gmail.com - R");
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
