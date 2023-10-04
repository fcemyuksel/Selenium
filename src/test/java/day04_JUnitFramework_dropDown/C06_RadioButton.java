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

import java.time.Duration;

public class C06_RadioButton {


    WebDriver driver;
@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
}
@After
    public void tearDown(){
    driver.close();
}

@Test
    public void radioButtunTesti(){
    //a. Verilen web sayfasına gidin.
    //	     https://facebook.com

    driver.get("https://facebook.com");
    //	b. Cookies’i kabul edin
    //	c. Create an account buton’una basin
    driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

    //	d. Radio button elementlerini locate edin ve
    //	size uygun olani secin
    WebElement erkekButonu=driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
    erkekButonu.click();
    //	e. Sectiginiz radio button’un seçili,
    //	ötekilerin seçili olmadigini test edin
    WebElement kadinButonu=driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
    WebElement ozelButonu=driver.findElement(By.xpath("(//input[@name='sex'])[3]"));

    Assert.assertTrue(erkekButonu.isSelected());
    Assert.assertFalse(kadinButonu.isSelected());
    Assert.assertFalse(ozelButonu.isSelected());
}




}

