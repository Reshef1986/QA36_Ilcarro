package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
        click(By.cssSelector("a[ng-reflect-router-link='login'"));

    }
    public void fillLogin(String email ,String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);

    }


    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//a[normalize-space()='Logout']"));
        return list.size()>0;
    }

    public void logOut() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }

    public void submitLogin() {
        click(By.cssSelector("[type='submit']"));
    }

    public void submitAfterLogin() {
        click(By.cssSelector("button[type='button']"));
    }

    public boolean loginFailed() {
        List<WebElement> list = wd.findElements(By.cssSelector("button[type='button']"));
        return list.size()>0;

    }

    public boolean isText() {
        wd.findElement(By.cssSelector(".error")).getText().contains("It'snot look like email");
        return true;
    }
}
