package day04_JUnitFramework_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import java.time.Duration;

public class C05_CheckBox {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void checkBoxTesti() throws InterruptedException {

        //a. Verilen web sayfasına gidin.
        //	     https://the-internet.herokuapp.com/checkboxes
        //	b. Checkbox1 ve checkbox2 elementlerini locate edin.
        //	c. Checkbox1 seçili değilse onay kutusunu tıklayın
        //	d. Checkbox2 seçili değilse onay kutusunu tıklayın
        //	e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkBox1Elementi=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2Elementi=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if (!checkBox1Elementi.isSelected());
        checkBox1Elementi.click();
        Thread.sleep(2000);
        if (!checkBox2Elementi.isSelected());
        checkBox2Elementi.click();
        Thread.sleep(2000);
        if (checkBox1Elementi.isSelected()){
            checkBox1Elementi.click();
        }
        if (checkBox2Elementi.isSelected()){
            checkBox2Elementi.click();
        }
        Thread.sleep(2000);

        Assert.assertTrue(checkBox1Elementi.isSelected());
        Assert.assertTrue(checkBox2Elementi.isSelected());
    }
}
