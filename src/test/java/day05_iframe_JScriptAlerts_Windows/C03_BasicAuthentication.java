package day05_iframe_JScriptAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {
    @Test

    public void test01() throws InterruptedException {
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //Thread.sleep(5000);
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : admin
        // 	password      : admin
        //
        //4- Basarili sekilde sayfaya girildigini dogrulayin
        //WebElement congratsElementi=driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]"));
        WebElement congratsElementi=driver.findElement(By.tagName("p"));

        Assert.assertTrue(congratsElementi.isDisplayed());
        //Thread.sleep(5000);
    }
}
