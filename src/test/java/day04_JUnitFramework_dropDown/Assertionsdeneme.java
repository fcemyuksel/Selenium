package day04_JUnitFramework_dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

import static day04_JUnitFramework_dropDown.C03_Assertions.driver;

public class Assertionsdeneme extends TestBase {

    int sayi1=34;
    int sayi2=25;
    @Test
    public void ciftSayiTest(){
        Assert.assertFalse("secilen tek sayidir: ", sayi2 % 2==0);
        Assert.assertTrue("secilen cift sayidir",sayi1 % 2==0);
    }

    @Test
    public void  sayiKarsilastirma(){

        Assert.assertTrue(sayi1>sayi2);
        //Assert.assertEquals(sayi1,sayi2);
    }



    @Test
    public void betbuyTesti() {
        driver.get("https://www.bestbuy.com/");
        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);

        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedTitle));

        //		○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisElementi=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francaisElementi.isDisplayed());
    }


    @Test
    public void youtubeTesti() throws InterruptedException {
        //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
        driver.get("https://www.youtube.com");

        String expectedUrl="https://www.youtube.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        Thread.sleep(2000);
        //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoElementi=driver.findElement(By.xpath("(//yt-icon[@id=\"logo-icon\"])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement seachBoxElementi=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(seachBoxElementi.isEnabled());
        }




        }


