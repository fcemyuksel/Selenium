package day06_ActionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C09_FileUploadTesti extends TestBase {

    @Test
    public void fileUploadTesti() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        System.out.println(System.getProperty("user.dir"));
        //Bilgisayardaki kullanici ana dosyasinin dosya yolu:C:\Users\ASUS\IdeaProjects\Selenium
        System.out.println(System.getProperty("user.dir"));
        //C:\Users\ASUS\IdeaProjects\Selenium
        // deneme.txt dosya yolu:
        //C:\Users\ASUS\IdeaProjects\Selenium\src\test\java\day06_ActionsClass_FileTestleri\deneme.txt
        //src/test/java/day06_ActionsClass_FileTestleri/deneme.txt

        String dinamikDosyaYolu=System.getProperty("user.dir")+"/src/test/java/day06_ActionsClass_FileTestleri/deneme.txt";

        //Yuklemek istediginiz dosyayi secelim.
        WebElement fileUploadYolu=driver.findElement(By.id("file-upload"));
        fileUploadYolu.sendKeys(dinamikDosyaYolu);
        Thread.sleep(3000);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileUploadYazisi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadYazisi.isDisplayed());
        Thread.sleep(5000);

    }
}
