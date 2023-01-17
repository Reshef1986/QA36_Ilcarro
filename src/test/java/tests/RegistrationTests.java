package tests;

import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();

        }
        if (app.getHelperUser().isYallaButtonNotActive()){
            app.getHelperUser().refresh();
        }

    }
    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000);
        User user = new User().withName("Sasha").withLastName("Zakharov").withEmail("reshef1986"+i+"@mail.com").withPassword("Rr6146858!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
Assert.assertTrue(app.getHelperUser().isLogged());

    }
    @Test
    public void registrationWrongEmail(){
        User user = new User().withName("Sasha").withLastName("Zakharov").withEmail("reshef1986mail.com").withPassword("Rr6146858!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().erorText(),"Wrong email format\n" +
                "Wrong email format");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }
    @Test
    public void registrationWrongPassword(){

        User user = new User().withName("Sasha").withLastName("Zakharov").withEmail("reshef1986@mail.com").withPassword("R");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();
        System.out.println(app.getHelperUser().erorText());
        Assert.assertEquals(app.getHelperUser().erorText(),"Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }

    @AfterMethod
    public void postCondition(){


        app.getHelperUser().closeDialogContainer();
    }


}

