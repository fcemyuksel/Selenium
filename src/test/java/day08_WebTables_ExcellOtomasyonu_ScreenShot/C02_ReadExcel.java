package day08_WebTables_ExcellOtomasyonu_ScreenShot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    Sheet sayfa1;
    @Test
    public void excelTesti() throws IOException {
        String dosyaYolu="src/test/java/day08_WebTables_ExcellOtomasyonu_ScreenShot/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);


 //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        sayfa1=workbook.getSheet("Sayfa1");
        Row row= sayfa1.getRow(0);
        Cell cell=row.getCell(1);
        System.out.println(cell);
 //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucre=sayfa1.getRow(0).getCell(1).toString();
        System.out.println("Istenen Hucre: "+istenenHucre);
 //		- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedBaskent="Kabil";
        String actualBaskent=sayfa1.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedBaskent,actualBaskent);
 //		- Satir sayisini bulalim
        int satirSayisi=sayfa1.getLastRowNum(); //son satir indexini verir
        System.out.println("Excel'deki Sattir Sayisi: "+(satirSayisi+1));
 //		- Fiziki olarak kullanilan satir sayisini bulun
        int kullnilanSatirSayisi=sayfa1.getPhysicalNumberOfRows();
        System.out.println("kullanilan satir sayisi: "+kullnilanSatirSayisi);

//		sayfada Turkce baskent olarak "Bern" bulundugunu kontrol edin

        boolean bernVarMi=false;
        String turkceBaskentIsmi;

        for (int i = 0; i <= satirSayisi; i++) {
            turkceBaskentIsmi=sayfa1.getRow(i).getCell(3).toString();
            if (turkceBaskentIsmi.equals("Bern")){
                bernVarMi=true;
                break;
            }

        }
        Assert.assertTrue(bernVarMi);

        //bir method olusturun. istenen satir sutun numarasina ait
        //celldeki yaziyi yazdirin

        hucreYazdir(3,3);
        hucreYazdir(5,4);
        hucreYazdir(12,1);
        hucreYazdir(55,3);
        //hucreYazdir(66,9); NullPointerException::: bos olan hucreden dolayi
        //hucreYazdir(200,9); NullPointerException::: bos olan hucreden dolayi

    }
    public void hucreYazdir(int satirNo, int sutunNo){
        String istenenHucreYazi=sayfa1.getRow(satirNo-1).getCell(sutunNo-1).toString();
        System.out.println(satirNo+ ". satir, "+ sutunNo+". sutundaki bilgi: "+istenenHucreYazi);
    }


}
