package day08_WebTables_ExcellOtomasyonu_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;
import java.util.List;

public class webTablesDeneme extends TestBase {

    @Test
    public void test01()  {
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2. Headers da bulunan basliklari yazdirin
        WebElement headersSatiri= driver.findElement(By.xpath("//*[@class='rt-thead -header']"));
        System.out.println("Basliklar: "+headersSatiri.getText());

        //  3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBasligi=driver.findElement(By.xpath("//*[@class='rt-thead -header']//*[@role='columnheader'][3]"));
        System.out.println("==========================");
        System.out.println("Ucuncu Sutun Basligi: "+ucuncuSutunBasligi.getText());


        //  4. Tablodaki tum datalari yazdirin
        WebElement tumBodyElementi=driver.findElement(By.xpath("//*[@class='rt-tbody']"));
        System.out.println("Tum Body: " +tumBodyElementi.getText());

        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> dataList=driver.findElements(By.xpath("//*[@role='rowgroup']//*[@class='rt-td']"));
        int sayac=0;
        for (WebElement each:dataList
             ) {
            if (!each.getText().isBlank()){
                sayac++;
            }
        }

        System.out.println("Tablodaki Bos Olmayan Hucre Sayisi: "+sayac);

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//*[@role='rowgroup']"));
        System.out.println("Tablodaki Satir Sayisi: "+satirlarListesi.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //webtableda sutun yapisi yok. bunun yerine herhangibir satirdaki data sayisi yazdirilir
        List<WebElement> birinciSatirDatalari=driver.findElements(By.xpath("//*[@role='rowgroup'][1]//*[@class='rt-td']"));
        System.out.println("Tablodaki sutun sayisi: "+birinciSatirDatalari.size());

        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolon=driver.findElements(By.xpath("//*[@role='rowgroup']//*[@class='rt-td'][3]"));
        

        ReusableMethods.bekle(2);



    }
}
