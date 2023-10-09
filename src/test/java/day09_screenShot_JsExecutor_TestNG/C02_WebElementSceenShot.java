package day09_screenShot_JsExecutor_TestNG;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_WebElementSceenShot extends TestBase {
@Test
    public void test01() throws IOException {

    //amazon ana sayfaya gidin
    driver.get("https://www.amazon.com");
    //nutella icin arama yapin
    WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
    aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
    //sonuclarin nutella icersigini test edin
    WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
    String expectedIcerik="Nutella";
    String actualSonucYazisi=sonucYaziElementi.getText();
    Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    //rapora eklemek uzere sonuc yazisi goruntusunu ekleyin

    //1. adim:fotografini cekmek istedigimiz webElementi locate edin
    //          biz zaten sonuc yazi elementini locate etmiştik
    //2. adim: fotografi kaydedecegimiz dosyayi olusturun

    File sonucYazisiFotografi=new File("target/screenshots/sonucYazisi.png");
    //3. adim: webelementi kullanaak screenshot olusturun ve
    //geceici dosya

    File geciciDosya=sonucYaziElementi.getScreenshotAs(OutputType.FILE);

    //4.adim: gecici dosyayi asil dosyya kaydededlim

    FileUtils.copyFile(geciciDosya,sonucYazisiFotografi);
}


}
