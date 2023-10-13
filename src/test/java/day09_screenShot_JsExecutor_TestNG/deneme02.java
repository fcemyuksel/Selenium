package day09_screenShot_JsExecutor_TestNG;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class deneme02<Set> extends TestBase {
    @Test
    public void test01(){
        //1- https://forum.shiftdelete.net/ adresine gidin
        driver.get("https://forum.shiftdelete.net/");

        //2- Youtube videosunun ortasındaki play logosuna tıklayın.
        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@class='latestVideoEmbed']"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        //3- videoda sağ alttaki youtube logosuna tıklayın.
        driver.findElement(By.xpath("//*[@aria-label=\"www.youtube.com sitesinde izle\"]")).click();
        //4- Yeni sayfa açıldığını test edin
        String ilkSayfaWhd= driver.getWindowHandle();
        String ikinciSayfaWhd="";
        java.util.Set<String> whdSeti=driver.getWindowHandles();
        for (String each:whdSeti
             ) {
            if (!each.equals(ilkSayfaWhd)){
                each=ikinciSayfaWhd;
            }
        }
        driver.switchTo().window(ikinciSayfaWhd);



        //5- İlk Sayfaya dönerek bu sayfada arama kutusunun görünür olduğunu test edin.
        driver.switchTo().window(ilkSayfaWhd);
        WebElement aramaKutusu=driver.findElement(By.xpath("(//input[@placeholder='Ara...'])[2]"));
        System.out.println(aramaKutusu.isEnabled());
    }
}
