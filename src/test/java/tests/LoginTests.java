package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends  TestBase{


    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }else if (app.getHelperUser().loginFailed()){
            app.getHelperUser().submitAfterLogin();

        }



    }

 @Test
    public void loginSuccess () throws InterruptedException {
     app.getHelperUser().openLoginRegistrationForm();
     app.getHelperUser().fillLogin("reshef1986@gmail.com","Rr6146858!");
     app.getHelperUser().submitLogin();
     Thread.sleep(2000);
     app.getHelperUser().submitAfterLogin();
     Assert.assertTrue(app.getHelperUser().isLogged());
 }

    @Test
    public void loginSuccess2 () throws InterruptedException {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLogin("reshef1986@gmail.com","Rr6146858!");
        app.getHelperUser().submitLogin();
        Thread.sleep(2000);
        app.getHelperUser().submitAfterLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

 @Test
    public void loginWrongEmail() throws InterruptedException {
     app.getHelperUser().openLoginRegistrationForm();
     app.getHelperUser().fillLogin("reshef1986gmail.co","Rr6146858!");

     Assert.assertTrue(app.getHelperUser().isText());
 }

 @Test
    public void loginWrongPassword(){
         app.getHelperUser().openLoginRegistrationForm();
         app.getHelperUser().fillLogin("reshef1986@gmail.com","R");
         app.getHelperUser().submitLogin();

         Assert.assertFalse(app.getHelperUser().isLogged());
 }

 @Test
    public void loginUnregisterUser(){
     app.getHelperUser().openLoginRegistrationForm();
     app.getHelperUser().fillLogin("reshef11986@gmail.com","Rr6146858!");
     app.getHelperUser().submitLogin();

     Assert.assertFalse(app.getHelperUser().isLogged());
 }
}
