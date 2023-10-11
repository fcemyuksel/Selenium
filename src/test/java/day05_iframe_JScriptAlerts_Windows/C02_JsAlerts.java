package day05_iframe_JScriptAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.TestBase_BeforeClass;

public class C02_JsAlerts extends TestBase_BeforeClass {
    //1. Test

    @Test
    public void test01() throws InterruptedException {
        //	-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get(" https://the-internet.herokuapp.com/javascript_alerts");
       // Thread.sleep(2000);
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();
       // Thread.sleep(2000);
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi="I am a JS Alert";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        //Thread.sleep(2000);

  }

    //2.Test
    @Test
    public void test02() throws InterruptedException {
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //Thread.sleep(2000);
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();
        //Thread.sleep(2000);
        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();
        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='result']"));
        String expectedSonucYazisi="You clicked: Cancel";
        String actualSonucYazisi=sonucYazisi.getText();
        //Thread.sleep(2000);
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    //3.Test
    @Test
    public void test03() throws InterruptedException {
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       // Thread.sleep(2000);
        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();
        //Thread.sleep(2000);
        //	- Cikan prompt ekranina "Cem" yazdiralim
        driver.switchTo().alert().sendKeys("Cem");
        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();
        //	- Cikan sonuc yazisinin Cem icerdigini test edelim
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='result']"));
        String expectedSonucYazisi="Cem";
        String actualSonucYazisi=sonucYazisi.getText();
       // Thread.sleep(2000);
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));

    }


}
