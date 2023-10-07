package day08_WebTables_ExcellOtomasyonu_ScreenShot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        //ayarlamalari yapip sayfa2'ye gidin
        String dosyaYolu="src/test/java/day08_WebTables_ExcellOtomasyonu_ScreenShot/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa2=workbook.getSheet("Sayfa2");

        //sayfada kullanilan son satir indexinin 23 oldugunu test edin

        int expectedSonSatirIndexi=23;
        int actualSonSatirIndexi=sayfa2.getLastRowNum();
        Assert.assertEquals(expectedSonSatirIndexi,actualSonSatirIndexi);
        //sayfada aktif olarak kullanilan satir sayisinin 8 oldugunu test edin

        int expectedAktifSatirSayisi=8;
        int actualAktifSatirSayisi=sayfa2.getPhysicalNumberOfRows();

        Assert.assertEquals(expectedAktifSatirSayisi,actualAktifSatirSayisi);

    }
}
