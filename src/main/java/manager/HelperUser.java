package manager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void submit() {
        click(By.xpath("//button[text()='Y’alla!']"));
        // click(By.xpath("//button[@type='submit']"));

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

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("[formcontrolname='firstName']"),user.getName());
        type(By.cssSelector("[formcontrolname='lastName']"),user.getLastName());
        type(By.cssSelector("[formcontrolname='email']"),user.getEmail());
        type(By.cssSelector("[formcontrolname='password']"), user.getPassword());


    }

    public void checkPolicy() {
       WebElement e= wd.findElement(By.cssSelector("#terms-of-use"));
        int x = wd.findElement(By.cssSelector("#terms-of-use")).getLocation().getX();
        int y = wd.findElement(By.cssSelector("#terms-of-use")).getLocation().getY();
        System.out.println(x);
        System.out.println(y);
        Actions cliiick = new Actions(wd);
        cliiick.moveToElement(e,20,10).click().build().perform();

    }
}
