package day09_screenShot_JsExecutor_TestNG;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_scroolIntoWiew extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //amazon ana sayfaya gidin
        driver.get("https://wwwamazon.com");
        //"Back to tap" linki gorununceye kadar asagi inin
        WebElement backToTapElementi= driver.findElement(By.xpath("//*[@*='navFooterBackToTopText']"));
        ReusableMethods.bekle(3);
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",backToTapElementi);


        //"Back to tap" elementinin screenshotunu
        ReusableMethods.bekle(5);
        ReusableMethods.webElementScreenShotCek(backToTapElementi,"backToTap");
        //"Back to tap" a tiklayip sayfa basina donun
        jse.executeScript("arguments[0].click();",backToTapElementi);
        ReusableMethods.bekle(2);

        //tum sayfa screenshot alin
        ReusableMethods.tumSayfaFotografCek(driver,"basaDonus");
        ReusableMethods.bekle(2);

        jse.executeScript("alert('yasasinnnn');");

        ReusableMethods.bekle(3);
    }
}
