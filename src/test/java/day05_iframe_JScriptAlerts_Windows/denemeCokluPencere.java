package day05_iframe_JScriptAlerts_Windows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class denemeCokluPencere extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.hepsiburada.com/");

        driver.findElement(By.xpath("//*[text()='Kabul et']")).click();

        WebElement otoBahceElement=driver.findElement(By.xpath("//*[text()='Oto, Bahçe, Yapı Market']"));
        String ilkSayfaWhd= driver.getWindowHandle();
        System.out.println(ilkSayfaWhd);
        Actions actions=new Actions(driver);
        actions.moveToElement(otoBahceElement).perform();
        //Thread.sleep(1000);

        driver.findElement(By.xpath("//*[text()='4 Mevsim']")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@src=\"https://productimages.hepsiburada.net/s/63/222-222/110000004459244.jpg\"]")).click();

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());

        String ikinciSayfaWhd="";
        Set<String> whdList=driver.getWindowHandles();

        for (String each:whdList
             ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }

        System.out.println("ilk sayfa whd: "+ilkSayfaWhd);
        System.out.println("ikinci sayfa whd: "+ikinciSayfaWhd);

        driver.switchTo().window(ikinciSayfaWhd);
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='button effective icon icon-plus']")).click();
        driver.findElement(By.xpath("//button[@class='button effective icon icon-plus']")).click();
        driver.findElement(By.xpath("//button[@class='button effective icon icon-plus']")).click();
        driver.findElement(By.xpath("//button[@class='button big with-icon']")).click();

        driver.findElement(By.xpath("//*[text()='Sepete git']")).click();

        driver.findElement(By.xpath("//*[text()='Alışverişi tamamla']")).click();





    }


}
