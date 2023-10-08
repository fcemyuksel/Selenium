package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye) throws InterruptedException {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void tumSayfaFotografCek(WebDriver driver,String screenShotIsmi){

        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;

        //dosya adini dinamik yapalim
        // target\screenshots\tumSayfaSS.png
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter istenenFormat=DateTimeFormatter.ofPattern("yyMMddHHmm");
        localDateTime.format(istenenFormat);

        String dinamikDosyaAdi="target\\screenshots\\"+screenShotIsmi+
                localDateTime.format(istenenFormat)+".png";
        File tumSayfaSS=new File(dinamikDosyaAdi);
        File geciciDosya= takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        screenshot dosyasi icin hep ayni ismi kullanirsak
        tum fotograflar hep ayni isimle kaydedileceginden
        tek bir dosya olur. son cekilen her fotograf eskilerinin uzeine kaydolur

        cekilen tum fotograflarin kayolmasi ve istenilen
        isimde olmasi icin dosya adini dinamik yapalim
        1. methodun cagrildigi yerde bir fotograf ismi yazilsin
        2. methodda dosya ismine tarih etikesi ekleyelim.

         */
    }
}
