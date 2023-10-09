package day09_screenShot_JsExecutor_TestNG;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_WebElementScreenShot extends TestBase {

    @Test
    public void test01(){
// amazon anasayfaya gidin
        driver.get("https://www.amazon.com");


// Nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin Nutella icerdigini test edin ve sonuc yazisini ss alin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik="Nutella";
        String actualSonucYazisi=sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        ReusableMethods.webElementScreenShotCek(sonucYaziElementi,"sonucYazi");
// ilk urune tiklayin

        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
         .click();
// urun isminin Nutella icerdigini test edin ve screenshot alin

        WebElement urunIsmiElementi= driver.findElement(By.xpath("//h1[@id='title']"));

        String expectedUrunIcerik="Nutella";
        String actualUrunIsmi=urunIsmiElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIcerik));

        ReusableMethods.webElementScreenShotCek(urunIsmiElementi,"ilkUrun");
    }
}
