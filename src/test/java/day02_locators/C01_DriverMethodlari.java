package day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

       /*
ChromeDriver kullanarak, facebook sayfasina gidin ve
sayfa basliginin (title) “facebook” oldugunu dogrulayin
(verify), degilse dogru basligi yazdirin.
Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin,
icermiyorsa “actual” URL’i yazdirin.
https://www.walmart.com/ sayfasina gidin.
Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
Tekrar “facebook” sayfasina donun
Sayfayi yenileyin
Sayfayi tam sayfa (maximize) yapin
Browser’i kapatin
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com/");
        String expectedTitle= "facebook";
        String actualTitle=driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Facebook title testi passed");
        }else {
            System.out.println("Facebook sayfasinda title facebook icermiyor, test Faild." + "\n Actual title: "+ actualTitle);
        }

        String expectedUrlIcerik="facebook";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Facebook Url test PASSED");
        }else {
            System.out.println("Facebook sayfasinde Url facebook icermiyor, test FAILD");
        }
            driver.navigate().to("https://www.walmart.com/");

            String expectedTitleIcerik=   "Walmart.com";
            actualTitle=driver.getTitle();

            if (actualTitle.contains(expectedTitleIcerik)){
                System.out.println("istenen icerigi barindiriyor, test PASSED");
            }else {
                System.out.println("Walmart titlei icermiyor, test FAILD\n"+ "Actual Title: "+actualTitle);
            }

        Thread.sleep(3000);
            driver.close();
        }
    }


