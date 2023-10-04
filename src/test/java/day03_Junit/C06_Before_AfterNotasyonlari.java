package day03_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class C06_Before_AfterNotasyonlari {
 // 3 test methodu olusturun
    //3 method da ayri ayri google, youtube ve amazona gidip
    //Titlelarda google, youtube ve amazon gectigini test edip
    //sayfayi kapatin

    /*
    bir test calisirken her test methıdundan once calismasini istediginiz
    ortak method varsa her methodda tekrar yazmak yerine
    @Before notasyonuna sahip ayri bir method yazilabilir
     @Before notasyonuna sahip methodlar bagimsiz calistirilamaz
     bulunduklari classtaki tüm @Test notasyonuna sahip methodlardan once calisirlar

     Ayni sekilde test notasyonuna sahip her methoddan sonra calismasini
     istedigimiz kodlar icin de
     @After notasyonuna sahip tearDown()

     Before ve After methodları sayesinde test methodlari
     daha anlasilir olur
     */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
     @Test
        public void googleTest() throws InterruptedException {

         driver.get("https://www.google.com");
         String expectedIcerik="Google";
         String actualTitle=driver.getTitle();
         if (actualTitle.contains(expectedIcerik)){
             System.out.println("google testi PASSED");
         }else {
             System.out.println("google testi FAILD "+actualTitle);
         }



     }
    @Test
    public void youtubeTest() throws InterruptedException {

        driver.get("https://www.youtube.com");
        String expectedIcerik="google";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("youtube testi PASSED");
        }else {
            System.out.println("youtube testi FAILD"+actualTitle);
        }

    }
    @Test
    public void amazonTest() throws InterruptedException {

        driver.get("https://www.amazon.com");
        String expectedIcerik="google";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("amazon testi PASSED");
        }else {
            System.out.println("amazon testi FAILD"+actualTitle);
        }

    }

}