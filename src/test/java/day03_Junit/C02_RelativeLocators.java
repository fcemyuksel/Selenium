package day03_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Berlin’i  3 farkli relative locator ile locate edin

        WebElement sailorElementi=driver.findElement(By.id("pid11_thumb"));
        WebElement NYCElementi=driver.findElement(By.id("pid3_thumb"));
        WebElement bostonElementi=driver.findElement(By.id("pid6_thumb"));
        //tagi img olup sailorun üstündeti element
        WebElement berlin1= driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi));

        WebElement berlin2=driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).below(NYCElementi));

        WebElement berlin3=driver.findElement(RelativeLocator.with(By.id("pid6_thumb")).toRightOf(bostonElementi));

        //3 )Relative locator’larin dogru calistigini test edin
        if (berlin1.getAttribute("id").equals("pid7_thumb")){
            System.out.println("berlin1 locator calisiyor");
        }else {
            System.out.println("berlin1 locator calismiyor");
        }

        Thread.sleep(2000);
        driver.close();


    }
}
