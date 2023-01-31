
package tests;

import manager.ListenerTNG;
import model.Car;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;
@Listeners(ListenerTNG.class)
public class AddNewCarTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().withEmail("reshef1986@gmail.com").withPassword("Rr6146858!"));
            logger.info("Тесты запущенны в профели  ->>> reshef1986@gmail.com - Rr6146858!");
        }
    }

    @Test
    public void addNewCarSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Car car = Car.builder()
                .location("Haifa, Israel")
                .manufacture("BMW")
                .model("M5")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .clasS("C")
                .carRegNumber("555-00-"+i)
                .price("65")
                .about("very nice car")
                .build();

        logger.info("Машина создалась с такимми данными " + car.toString());

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("D:\\Qa36\\QA36_Ilcarro\\corvett.jpeg");
        logger.info("Картинка добавленна");
        app.getHelperCar().submit();
app.getHelperCar().pause(500);
        Assert.assertTrue(app.getHelperCar().isTitleMessageContains("Car added"));
        logger.info("Tests success");
    }
}

























/*package tests;

import model.Car;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
if(!app.getHelperUser().isLogged()){
    app.getHelperUser().login(new User().withEmail("reshef1986@gmail.com").withPassword("Rr6146858!"));
    app.getHelperCar().pause(500);
}
    }

    @Test
    public void addNewCarSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Haifa, Israel")
                .manufacture("BMW")
                .model("M5")
                .year("2020")
                .fuel("Petrol")
                .seats("4")
                .clasS("C")
                .carRegNumber("555-34-"+i)
                .price("65")
                .about("very nice car")
                .build();



        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("D:\\Qa36\\QA36_Ilcarro\\corvett.jpeg");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isTitleMessageContains("Car added"));


    }
}
*/