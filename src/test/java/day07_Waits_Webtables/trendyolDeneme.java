package day07_Waits_Webtables;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class trendyolDeneme extends TestBase {

    // Trendyol TestCase
    @Test
    public void test01() throws InterruptedException {

    //1."https://www.trendyol.com/" Sayfasına git.
    driver.get("https://www.trendyol.com/");
    String ilkSayfaWHD=driver.getWindowHandle();

    WebElement kvkkOnayElementi=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
    kvkkOnayElementi.click();
    Thread.sleep(2000);
    //2.Mouse mizi "Erkek"  Katagorisinin üzerine bekletelim.
        Actions actions=new Actions(driver);
        WebElement erkekKategori=driver.findElement(By.xpath("//a[@href=\"/butik/liste/2/erkek\"]"));
        actions.moveToElement(erkekKategori).perform();
    //3."Tişört" sekmesine tıklayalım.
        WebElement tisortElementi=driver.findElement(By.xpath("//*[@href=\"/erkek-t-shirt-x-g2-c73\"]"));
        tisortElementi.click();
    //4."Çıkan  2. ürüne" Tıklayalım.
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@class=\"overlay\"]")).click();
        //Thread.sleep(2000);
       List<WebElement> ikinciUrun= driver.findElements(By.xpath("//div[@class='p-card-chldrn-cntnr card-border']"));
       ikinciUrun.get(0).click();
       Set<String> pencereler=driver.getWindowHandles();
        String ikinciSayfaWhd="";
        for (String each:pencereler
             ) {
            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWhd=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWhd);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Anladım']")).click();
    //5."AC&Co / Altınyıldız Classics Erkek Siyah %100 Pamuk Slim Fit" Yazısının görünür olduğunu test edelim.
        String expectedYazi="Erkek Siyah %100 Pamuk Slim Fit Dar Kesim Bisiklet";
        String actualYazi= String.valueOf(driver.findElement(By.xpath("//span[contains(text(),'Erkek Siyah %100 Pamuk Slim Fit Dar Kesim Bisiklet')]")));
        Assert.assertTrue(actualYazi.contains(expectedYazi));
    //6."Renk seçeneklerinin üzerinde" mousemizi gezdirelim.
        Thread.sleep(4000);

       //driver.findElement(By.xpath("//div[@class=\"campaign-button bold\"]")).click();
      List<WebElement> renklerElementi= driver.findElements(By.xpath("//div[@class=\"slicing-attributes\"]/section//a"));

      for (int i = 0; i < renklerElementi.size(); i++) {
                actions.moveToElement(renklerElementi.get(i)).perform();
      }
        Thread.sleep(2000);

    //7."Beden" sekmesinden L bedeni seçelim.
    driver.findElement(By.xpath("//div[normalize-space()='L']")).click();

        Thread.sleep(1000);
        //8."SEPETE EKLE" Butonuna tıklayalım.
        driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']")).click();
        Thread.sleep(3000);
        //9."Sepetim" Butonuna tıklayalım.
        driver.findElement(By.xpath("(//*[text()='Sepetim'])[1]")).click();
        Thread.sleep(1000);

    //10.Alttaki "Sepeti Onayla" Butonuna tıklayalım.
        driver.findElement(By.xpath("(//*[text()='Sepeti Onayla'])[2]")).click();
        Thread.sleep(1000);

    //11. uye giris bilgilerini doldur
        WebElement girisYapUyeOlElementi=driver.findElement(By.xpath("//*[text()='Giriş Yap / Üye Ol']"));
        girisYapUyeOlElementi.click();
        WebElement uyeOlButonElementi=driver.findElement(By.xpath("//button[@class='q-secondary q-button-medium q-button tab button right active']"));

        Faker faker=new Faker();

        WebElement emailElementi=driver.findElement(By.xpath("//input[@id=\"login-email\"]"));
        emailElementi.click();
        actions.sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();
        Thread.sleep(1000);
        WebElement erkekSecenekElementi=driver.findElement(By.xpath("//button[@class='q-secondary q-button-medium q-button tab button right active']"));
        erkekSecenekElementi.click();
        Thread.sleep(1000);
        WebElement onayKutusuElementi=driver.findElement(By.xpath("//div[@name=\"personal-data-error\"]"));
        onayKutusuElementi.click();
        Thread.sleep(1000);
        WebElement captchaElementi=driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        captchaElementi.click();
        Thread.sleep(1000);
        WebElement sonUyeOlButonElementi=driver.findElement(By.xpath("//button[@data-testid='submit-button']"));
        sonUyeOlButonElementi.click();
        Thread.sleep(2000);
}
}