package day05_iframe_JScriptAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C06_KontrolsuzCokluPencere extends TestBase {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWhd=driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openingYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=openingYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        System.out.println(driver.getWindowHandle()); //C9DFD2393085E23933C45FB78055EC4A
        System.out.println(driver.getWindowHandles());//[C9DFD2393085E23933C45FB78055EC4A]
        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getWindowHandle()); //2A20DECB82736920939CC645F4C651F8
        System.out.println(driver.getWindowHandles());
        //[2A20DECB82736920939CC645F4C651F8, C21CF71AF282F8F5A82B54851E7E2955]

        String ikinciSayfaWhd="";
        Set<String> whdSeti=driver.getWindowHandles();
        /*
        ikinci sayfa bizim kontrolumuz disinda c,acilinca
        driver otomatik olarak ikinci sayfaya GECMEZ

        ikinci sayfa acildiktan sonra
        driver.getWindowHandle()==>hala ilk sayfanin window handle degerini verir
        driver.getWindowHandles()==>ise acik olan iki sayfanin window handle
        degerlerini bir set olarak verir

        set indexi desteklemedigi icin
        bir foreach loop yardimi ile setteki 2 whd'ni
        ilk sayfanin whd ile karsilastiracaksiniz
        ilk sayfanin whd'ne esit olmayan Whd'ne ESİT OLMAYANI, ikinci
        sayfanin whd olarak atayacagiz
         */

        for (String each:whdSeti){
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }
        System.out.println("ilk sayfa whd: " +ilkSayfaWhd);
        System.out.println("ikinci sayfa whd:" +ikinciSayfaWhd);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWhd);
        String expectedikinciSayfaTitle="New Window";
        String actualIkinciSatfaTitle=driver.getTitle();
        Assert.assertEquals(actualIkinciSatfaTitle,expectedikinciSayfaTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedIkinciSayfaYazi="New Window";
        String actualIkinciSayfaYazi=newWindowYaziElementi.getText();
        Assert.assertEquals(expectedIkinciSayfaYazi,actualIkinciSayfaYazi);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWhd);
        String expectedIlkSayfaTitle="The Internet";
        String actualIlkSayfaTitle=driver.getTitle();
        Assert.assertEquals(expectedIlkSayfaTitle,actualIlkSayfaTitle);

    }
}
