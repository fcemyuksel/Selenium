package day05_iframe_JScriptAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
       WebElement anIframeElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElementi.isEnabled());
        System.out.println(anIframeElementi.getText());
        //kullanmak istedigimiz webelement iframe icindeyse
        //direkt kullanamayiz. once iframe'i locate edip, iFrame'e gecis yapmaliyiz
        WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);
        WebElement textBoxElementi=driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();
        Thread.sleep(3000);
        //	- Text Box’a “Merhaba Dunya!” yazin.
        textBoxElementi.sendKeys("Merhaba Dunya!");

        /*
        bir web sayfasınıın icinde bulunan iframe'e gecis yaptiktan sonra
        yeniden ana sayfaya gecis yapmak gerekir
         */

        //	- TextBox’in altinda bulunan “Elemental Selenium” linkini
        //	textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi=driver.findElement(By.linkText("Elemental Selenium"));

        System.out.println(elementalSeleniumElementi);

        Thread.sleep(3000);
    }
}
