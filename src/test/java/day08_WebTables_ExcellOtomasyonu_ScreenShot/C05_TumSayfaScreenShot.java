package day08_WebTables_ExcellOtomasyonu_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_TumSayfaScreenShot extends TestBase {
    @Test
    public void nutellaTesti() throws IOException, InterruptedException {

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
        //rapora ekran goruntusunu ekleyin

        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //2. adim
        File tumSayfaFotograf=new File("target/screenshots/tumSayfaSS.png");

        //3. takeScreenshot objesini kullanarak fotografi cekin
        //ileride kullanilmak uzere gecici bir dosyaya kaydedin
       File geciciDosya=takesScreenshot.getScreenshotAs(OutputType.FILE);

        //4. gecici dosyayi resmi kaydetmek uzere hazirladigimiz dosyaya kaydedelim
        FileUtils.copyFile(geciciDosya,tumSayfaFotograf);

        ReusableMethods.bekle(3);
    }
}
