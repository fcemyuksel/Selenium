package day07_Waits_Webtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class hepsiBuradaDeneme extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // hepsiburada.com sitesine gidiniz.
        driver.get("https://www.hepsiburada.com");
        WebElement cerezElementi=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cerezElementi.click();
        String ilkSayfaWhd= driver.getWindowHandle();
        //Kategorilerden Elektronik kısmından dizüstü bilgisayara tıkla
        Actions actions=new Actions(driver);
        WebElement elektronikElementi=driver.findElement(By.xpath("(//span[@class=\"sf-MenuItems-UHHCg2qrE5_YBqDV_7AC\"])[1]"));
        actions.moveToElement(elektronikElementi).perform();
        Thread.sleep(3000);
        WebElement bilgisayarElementi=driver.findElement(By.xpath("//a[normalize-space()='Bilgisayar/Tablet']"));
        actions.moveToElement(bilgisayarElementi).perform();
        Thread.sleep(2000);
        WebElement dizustuBilgisayar=driver.findElement(By.xpath("//a[@class='sf-ChildMenuItems-KdzkrxSVhcwDy3od0Yre item-1854']"));
        dizustuBilgisayar.click();
        Thread.sleep(2000);
        //Sıralamalardan çok satanlara tıkla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        WebElement siralamaElementi=driver.findElement(By.xpath("//label[@class='horizontalSortingBar-Ce404X9mUYVCRa5bjV4D']"));
        siralamaElementi.click();
        Thread.sleep(3000);
        WebElement cokSatanlarElementi=driver.findElement(By.xpath("//div[contains(text(),'Çok satanlar')]"));
        cokSatanlarElementi.click();
        Thread.sleep(3000);
        //marka olarak Apple markasını seç
        //List<WebElement> markalar=driver.findElements(By.id("markalar"));
        //markalar.get(0);


        Thread.sleep(3000);
        //İlk çıkan ürüne git
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        WebElement appleElementi=driver.findElement(By.xpath("//div[@class='content-CjbQoEcUlPW8lzvdKEij'][normalize-space()='Apple']"));
        appleElementi.click();
        driver.navigate().refresh();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement ilkUrunElementi= driver.findElement(By.xpath("//*[text()=' MacBook Air M1 Çip 8GB 256GB SSD macOS 13\" QHD Taşınabilir Bilgisayar Uzay Grisi MGN63TU/A']"));
        ilkUrunElementi.click();
        Set<String> pencereler=driver.getWindowHandles();
        String ikinciSayfaWhd="";
        for (String each:pencereler
        ) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWhd);
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //ilk çıkan ürüne gittikten sonra ek hizmet ekleye tıkla
        Thread.sleep(4000);
        WebElement ekHizmetElementi=driver.findElement(By.xpath("//*[@class='customerAccount-AddRemoveButton-3PRnW']"));
        ekHizmetElementi.click();
        //ürünü sepete ekle
        WebElement sepeteEkleElementi=driver.findElement(By.xpath("//button[@class='button big with-icon']"));
        sepeteEkleElementi.click();
        Thread.sleep(2000);
        //sepete git ve sıklıkla birlikte alınanlardan çıkan ilk ürünü sepete ekle.

        WebElement sikliklaAlinan=driver.findElement(By.xpath("(//img[@width='222'])[1]"));

        actions.moveToElement(sikliklaAlinan).perform();
        WebElement sepeteEkle=driver.findElement(By.xpath("//div[text()='Sepete ekle']"));
        sepeteEkle.click();

        Thread.sleep(2000);

        //Sepete Git butonuna tıkla
        WebElement sepeteGitElementi=driver.findElement(By.xpath("//*[text()='Sepete git']"));
        sepeteGitElementi.click();
        Thread.sleep(2000);
        //Sepetteki ürünün para birimi değerini consolda yazdır
        WebElement paraBirimi=driver.findElement(By.xpath("//span[@class='currency_3gyoe']"));
        System.out.println("Gorunen para birimi: "+paraBirimi.getText());
        //Browserı kapat.
    }
}
