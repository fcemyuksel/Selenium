package day04_JUnitFramework_dropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_TestBaseKullanimi extends TestBase{

    //extends keyword icinde oldugumuz C07 classini
    //TestBase classinin child classi yapar
    //bu sayede C07 classindan TestBase classindaki tüm variable ve
    //methodlari dogrudan kullanabiliriz
    //static keyword'e dikkat edilmelidir

    @Test
    public void amazonTest(){

        //amazon ana sayfaya gidin

        driver.get("https://amazon.com");

        //nutella icin arama yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuclarinin Nutella icerdigini test edin
        WebElement sonucElementi=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String actualSonucYazisi=sonucElementi.getText();
        String expectedSonucYazisi="Nutella";

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));
    }
}
