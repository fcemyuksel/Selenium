package day05_iframe_JScriptAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C05_CokluPencereKullanimi extends TestBase {
@Test
    public void test01() throws InterruptedException {
    //amazon'a gidelim
    driver.get("https://www.amazon.com");
    String iilkSayfaWhd=driver.getWindowHandle();

    System.out.println(driver.getWindowHandle()); //5396CF097D185762F36EC45D1F546CA5
    System.out.println(driver.getWindowHandles()); //[5396CF097D185762F36EC45D1F546CA5]

    //yeni bir tab acarak youtube'a gidelim

    driver.switchTo().newWindow(WindowType.TAB);
    Thread.sleep(3000);
    driver.get("https://www.youtube.com");
    String ikinciSayfaWhd=driver.getWindowHandle();
    System.out.println(driver.getWindowHandle()); //121CF9A3696196B66D29518C40977BDF
    System.out.println(driver.getWindowHandles()); //[AE1A96BBA212B3A06BB128261F066089, 7492BA957FD9FC21BF3B840E5B9E6359, 121CF9A3696196B66D29518C40977BDF]


    Thread.sleep(3000);
    //yeni bir sayfa acarak arabam.com'a gidin

    driver.switchTo().newWindow(WindowType.WINDOW)
            .get("https://www.arabam.com");
    String ucuncuSayfaWhd=driver.getWindowHandle();
    Thread.sleep(3000);
    System.out.println(driver.getWindowHandle()); //63BF4363827292DE242D8B6D6EDF4829
    System.out.println(driver.getWindowHandles()); //[47747377564EEA8014BCF168EC4CCE4A, 63BF4363827292DE242D8B6D6EDF4829]

    //amazonun acik oldugu sayfaya gidin
    //ve title'in amazon icerdigini test edin
    //an itibari ile driver'imiz arabam.com sayfasinda
    //gecis icin amazon'un acik oldugu sayfanın window handel degeri lazim
    driver.switchTo().window(iilkSayfaWhd);
    String expectedTitleIcerik="Amazon";
    String actualTitle=driver.getTitle();
    Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

    //youtube'un acik oldugu sayfaya gidin
    //ve url'in youtube icerdigini test edin
    driver.switchTo().window(ikinciSayfaWhd);
    String expectedUrlIcerik="youtube";
    String actualUrl=driver.getCurrentUrl();
    Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));


    //arabam.com'un acik oldugu sayfaya gidin
    //ve logonun göründügünü test edin
    driver.switchTo().window(ucuncuSayfaWhd);
    WebElement logoElementi=driver.findElement(By.xpath("//img[@alt='arabam.com']"));
    Assert.assertTrue(logoElementi.isDisplayed());

}

}
