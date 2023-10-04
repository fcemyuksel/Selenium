package day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_isEnabled {
    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        int expectedLinkSayisi=147;

        List<WebElement> linklerListesi=driver.findElements(By.tagName("a"));
        int actualLinkSayisi=linklerListesi.size();
        if (expectedLinkSayisi==actualLinkSayisi){
            System.out.println("Link Sayisi Testi PASSED");

        }else {
            System.out.println("Link Sayisi Testi FAILD\n"+ "Sayfadaki Link Sayisi" +actualLinkSayisi);

        }

        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi=driver.findElement(By.id("sale_image"));
        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special Offer Elementi Passed");
        }else {
            System.out.println("Special Offer Elementi FAILD ");
        }

        //6-Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();





    }
}
