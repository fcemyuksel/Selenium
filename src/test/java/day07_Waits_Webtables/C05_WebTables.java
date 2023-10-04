package day07_Waits_Webtables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C05_WebTables extends TestBase {
    @Test
    public void amazonWeTableTesti() throws InterruptedException {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        //3.Web table tum body’sini yazdirin
        WebElement tumBodyElementi=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBodyElementi.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirElementList=driver.findElements(By.xpath("//tbody/tr"));
        int exopectedSatirSayisi=7;
        int actualSatirSayisi=satirElementList.size();
        Assert.assertEquals(exopectedSatirSayisi,actualSatirSayisi);
        //5.Tum satirlari yazdirin
        System.out.println("=======================");
        for (int i = 0; i < satirElementList.size(); i++) {
            System.out.println(i+1+ ". satir     :"+ satirElementList.get(i).getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        // WebTable'da sutun bilgisi yoktur
        //herbir satir icindeki datalar vardır
        //sutun sayisini bulabilmek icin bir satirdaki data sayisina bakabiliriz
        List<WebElement> birinciSatirDatalariList=driver
                .findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutunSayisi=13;
        int actualSutunSayisi=birinciSatirDatalariList.size();

        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);
        //7. 5.sutunu yazdirin
        //WebTable'da sutun yapisi yoktur
        //bunun yerine her satirdaki 5. datayi alip bir liste olusturabiliriz
        List<WebElement> besinciSutunListesi=driver.findElements(By.xpath("//tbody/tr[1]/td[5]"));
        System.out.println("====5. Sutun");
        for (WebElement each: besinciSutunListesi
             ) {
            System.out.println(each.getText());
        }
        Thread.sleep(2000);
        //8.Satir ve sutun sayisini parametre olarak alip,
        // hucredeki bilgiyi döndüren bir method olusturun
        System.out.println("================================");
        System.out.println(hucredekiBilgi(7,5));

        Thread.sleep(2000);
    }

    public String hucredekiBilgi(int satirNo,int sutunNo){
        //tbody/tr[1]/td[7]

        String dinamikXpath="tbody/tr["+satirNo+ "]/td["+sutunNo+ "]";
        WebElement istenenDataElementi=driver.findElement(By.xpath(dinamikXpath));
        return istenenDataElementi.getText();
    }
}