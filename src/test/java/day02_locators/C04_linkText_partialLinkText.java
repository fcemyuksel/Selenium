package day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_linkText_partialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        //gift cards linkine tıklayalım

        //driver.findElement(By.linkText("Gift Cards")).click();
        //linkText String olarak yazildigindan büyük kücük harf
        //bosluk vs cok onemlidir.

        driver.findElement(By.partialLinkText("Cards")).click();
       // driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
        Thread.sleep(5000);
        driver.close();

    }
}
