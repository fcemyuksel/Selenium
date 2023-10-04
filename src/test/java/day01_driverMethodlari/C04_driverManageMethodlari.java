package day01_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_driverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        System.out.println("maximize yapmadan onceki size: "+driver.manage().window().getSize());
        System.out.println("maximize yapmadan onceki position: "+driver.manage().window().getPosition());
        driver.manage().window().maximize();
        System.out.println("maximize yapmadan sonraki size: "+driver.manage().window().getSize());
        System.out.println("maximize yapmadan sonraki position: "+driver.manage().window().getPosition());


        driver.manage().window().fullscreen();
        System.out.println("fullscreen yapmadan sonraki size: "+driver.manage().window().getSize());
        System.out.println("fullscreen yapmadan sonraki position: "+driver.manage().window().getPosition());

        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(600,600));

        System.out.println("setsize yapmadan sonraki size: "+driver.manage().window().getSize());
        System.out.println("setposition yapmadan sonraki position: "+driver.manage().window().getPosition());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
        Testimizi calistirken sayfamizin yuklenmesi
        ilk basta uzun surebilir. ayrica driverin sayfada kullanacagi web
        elementlerini bulmasi zaman alabilir.
        implicitlyWait bu tur islemler icin driverin beklemesini istedigimiz max sureyi belirtir
        driver her bir islem icin yazdigimiz max sure kadar bekleyebilir
        max sure icinde islemi yapamazsa hata verir.

        her test methodu basina bunu eklemek gereklidir.
         */


        driver.get("https://elifsaritasyuksel.com/");
        driver.findElement(By.xpath("//li[@id='menu-item-5838']//a[contains(text(),'Özgeçmiş')]")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Vanderbilt Üniversitesi']")).click();


        Thread.sleep(3000);
        driver.close();




    }


}
