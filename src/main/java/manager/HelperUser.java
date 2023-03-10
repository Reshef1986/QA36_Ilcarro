package manager;

import model.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }


    public void openFormLogin()  {

        click(By.cssSelector("[ng-reflect-router-link='login']"));
    }

    public void fillLoginForm(String email, String password) {
       type(By.cssSelector("[type='email']"),email);
       type(By.cssSelector("[type='password']"),password);

   }
    public void fillLoginForm(User user) {
        type(By.cssSelector("[type='email']"), user.getEmail());
        type(By.cssSelector("[type='password']"), user.getPassword());

    }


    public String erorText (){
        getElementText(By.cssSelector(".error"));
        return  getElementText(By.cssSelector(".error"));
    }

    public String getMessage() {
        return wd.findElement(By.cssSelector("div.dialog-container>h2")).getText();
    }

    public void closeDialogContainer() {
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public boolean isLogged() {
        //return isElementPresent(By.xpath("//button[text()=' Logout ']"));
        return isElementPresent(By.xpath("(//a[normalize-space()='Logout'])[1]"));
    }

    public void logout() {
        // click(By.xpath("//button[text()=' Logout ']"));
        click(By.cssSelector("div.header a:nth-child(5)"));
    }
    public void  refresh(){
wd.navigate().refresh();
    }
    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonNotActive() {
        // return isElementPresent(By.cssSelector("button[disabled]"));
        return !wd.findElement(By.cssSelector("button[disabled]")).isEnabled();
    }
    public boolean isLoginButtonNotActive() {
        // return isElementPresent(By.cssSelector("button[disabled]"));
        return !wd.findElement(By.cssSelector("//a[text()=' Log in ']")).isEnabled();
    }

    public void openRegistrationForm() {
        click(By.cssSelector("[href^='/registration']"));
    }
    public  void openLetTheCarWorkForm(){
        click(By.id("1"));
    }

    public void fillRegistrationForm(User user) {
        pause(3000);
        type(By.cssSelector("[formcontrolname='firstName']"),user.getName());
        type(By.cssSelector("[formcontrolname='lastName']"),user.getLastName());
        type(By.cssSelector("[formcontrolname='email']"),user.getEmail());
        type(By.cssSelector("[formcontrolname='password']"), user.getPassword());


    }

    public void checkPolicy() {
        if(!wd.findElement(By.id("terms-of-use")).isSelected()) {
            click(By.cssSelector(".checkbox-container"));
        }

        WebElement e= wd.findElement(By.cssSelector("#terms-of-use"));
         /*
        int x = wd.findElement(By.cssSelector("#terms-of-use")).getLocation().getX();
        int y = wd.findElement(By.cssSelector("#terms-of-use")).getLocation().getY();

        System.out.println(x);
        System.out.println(y);
        */
        Actions checkPolicy = new Actions(wd);
        pause(500);
        checkPolicy.moveToElement(e,20,10).click().release().perform();
        pause(500);

    }
    public void checkPolicyXY(){

        Dimension size = wd.manage().window().getSize();
        System.out.println("Window Height "+ size.getHeight());
        System.out.println("Window Width "+ size.getWidth());

        WebElement label =wd.findElement(By.cssSelector("label[for='terms-of-use']"));

        Rectangle rect = label.getRect();
        int xOffset = rect.getWidth()/2;

        Actions actions = new Actions(wd);
        pause(1000);
        actions.moveToElement(label,-xOffset,0).click().release().perform();

    }
    public void checkPolicyJS(){
        JavascriptExecutor js=(JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').checked=true;");
    }

    public void login(User user) {
        openFormLogin();
        fillLoginForm(user);
        submit();
        closeDialogContainer();
    }
}
