package orangeHRM;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHRM {

        /*
    Homework – 4
    https://opensource-demo.orangehrmlive.com/
    ( Username : Admin | Password : admin123 )
    Enter username
    Enter password
    Click login
    Verify that the text “Welcome Paul”
    After Paul one symbol there so click on symbol for logout.
    Verify that the below text.
    LOGIN Panel  */


    WebDriver driver;

    @Before

    public void navigateToOrangeHRM() {

        String baseUrl = "https://opensource-demo.orangehrmlive.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Enter user name and password and click login button
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test

    public void verifyUserLoginSuccessfully() {

        String expectedMessage = "Welcome Paul";

        WebElement message = driver.findElement(By.id("welcome"));
        String actualMessage = message.getText();

        Assert.assertEquals("user not able to Login successfully ", expectedMessage, actualMessage);

    }

    @Test

    public void verifyUserLodOutSuccessfully(){

        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        String expectedText="LOGIN Panel";

        WebElement text=driver.findElement(By.id("logInPanelHeading"));

        String actualText=text.getText();

        Assert.assertEquals("User should not logout successfully",expectedText,actualText);

    }

    @After

    public void tearDown() {

        driver.quit();
    }
}
