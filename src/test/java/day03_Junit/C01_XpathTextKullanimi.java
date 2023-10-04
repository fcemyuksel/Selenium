package day03_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XpathTextKullanimi {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        Thread.sleep(3000);
        WebElement deleteButonElementi=driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButonElementi.isDisplayed()){
            System.out.println("delete buton testi PASSED");
        }else {
            System.out.println("delete buton testi FAILD");
        }
        Thread.sleep(3000);
        //4- Delete tusuna basin
        deleteButonElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement adRomoveElementi=driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (adRomoveElementi.isDisplayed()){
            System.out.println("Add Remove elementi testi PASSED");
        }else {
            System.out.println("Add Remove elementi testi FAILD");
        }
        Thread.sleep(3000);
        driver.close();

    }
}
