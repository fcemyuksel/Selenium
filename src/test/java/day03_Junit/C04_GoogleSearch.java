package day03_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         //8- Sayfayi kapatin

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedIcerik="Google";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("title testi passed");
        }else {
            System.out.println("title testi faild");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubuguElementi=driver.findElement(By.id("ApjFqb"));
        aramaCubuguElementi.sendKeys("Nutella"+ Keys.ENTER);

        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucElementi=driver.findElement(By.id("results-stats"));
        System.out.println(sonucElementi.getText());

        //7- Yaklaşık 197.000.000 sonuç bulundu (0,35 saniye)  oldugunu test edin

        String sonucYazisi=sonucElementi.getText();
        int ilkBoslukIndexi=sonucYazisi.indexOf(" ");
        int ikinciBoslukIndexi=sonucYazisi.indexOf(" ",ilkBoslukIndexi+1);

        String  sonucSayiStr=sonucYazisi.substring(ilkBoslukIndexi,ikinciBoslukIndexi)
                        .replaceAll("\\D","");

        int sonucSayisi = Integer.parseInt(sonucSayiStr);
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        if (sonucSayisi>10000000){
            System.out.println("Sonuc sayisi testi PASSED");
        }else{
            System.out.println("Sonuc sayisi testi FAILED");
        }

        //8- Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();
    }
}
