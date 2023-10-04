package day01_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_IlkTest {
    public static void main(String[] args) throws InterruptedException {





        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //4. Sayfa basligini(title) yazdirin
        System.out.println("sayfa basligi: " +driver.getTitle());
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String expectedIcerik="Amazon";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("title testi passed");
        }else {
            System.out.println("Title " +expectedIcerik +"expected Icermiyor ");
        }
        //6. Sayfa adresini(url) yazdirin
        System.out.println("sayfa Url'i: " +driver.getCurrentUrl());
        //7. Sayfa url’inin “amazon” icerdigini test edin.
        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url " + expectedUrl+ " kelimesini iceriyor");
        }else {
            System.out.println("Url " + expectedUrl+ " kelimesini icermiyor");
        }
        //8. Sayfa handle degerini yazdirin
        System.out.println("sayfanin window handle degeri: " +driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin

        String beklenenIcerik="alisveris";
        String gorunenIcerik=driver.getPageSource();

        if (gorunenIcerik.contains(beklenenIcerik)){
            System.out.println("HTML icerik testi passed");
        }else {
            System.out.println("sayfa kaynak kodlari "+ beklenenIcerik+ "kelimesini icermiyor.Test Faild ");
        }
        //10. Sayfayi kapatin.
        Thread.sleep(3000);
        driver.close();


    }
}
