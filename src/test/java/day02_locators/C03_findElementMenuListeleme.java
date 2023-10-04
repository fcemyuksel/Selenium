package day02_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findElementMenuListeleme {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       /* 1- Bir test class’i olusturun ilgili ayarlari yapin
        2- https://www.automationexercise.com/ adresine gidin
        3- Category bolumundeki elementleri locate edin
        4- Category bolumunde 3 element oldugunu test edin
        5- Category isimlerini yazdirin
        6-Sayfayikapatin*/


        driver.get("https://www.automationexercise.com/");
        List<WebElement> categoryList=driver.findElements(By.className("panel-title"));
        int expectedCategorySayisi=3;
        int actualCategorySayisi=categoryList.size();

        if (expectedCategorySayisi==actualCategorySayisi){
            System.out.println("Kategori sayi testi PASSED");
        }else {
            System.out.println("Kategori sayi testi FAILD");
        }


        System.out.println(categoryList);
        for (WebElement eachElement:categoryList){
            System.out.println(eachElement.getText());
        }

        Thread.sleep(3000);
        driver.close();

    }
}
