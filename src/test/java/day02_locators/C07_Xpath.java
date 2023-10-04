package day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Xpath {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2-  https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com/");
        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedIcerik ="Spend less";
        //6-  Gift Cards sekmesine basin
        driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
        //7-  Birthday butonuna basin
        driver.findElement(By.xpath("(//span[text()='Birthday'])[2]")).click();
        //8-  Best Seller bolumunden ilk urunu tiklayin
        //once best seller linkine tiklayalim
        driver.findElement(By.xpath("(//span[@class = 'nav-a-content'])[2]")).click();
        //simdi ilk urunu tiklayalim
        driver.findElement(By.xpath("(//div[@class='a-section a-spacing-mini _cDEzb_noop_3Xbw5'])[1]")).click();
        //9-  Gift card details’den 25 $’i  secin
       WebElement secimbutonu25=driver.findElement(By.xpath("//button[@id='a-autoid-0-announce']"));
        secimbutonu25.click();
        //10-Urun ucretinin 25$ oldugunu test edin



        driver.findElement(By.xpath("//button[@id='a-autoid-0-announce']")).isDisplayed();
        //11-Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();
    }
}
