package day06_ActionsClass_FileTestleri;

import org.junit.Test;

public class C07_DosyaErisim {
    @Test
    public void dosyaTesti(){

        System.out.println(System.getProperty("user.home"));
   //C:\Users\Dell

    /*
    Selenium bilgisayarimiza ulasamaz ve
    bilgisayarimizdaki dosyalari test edemez

    Bilgisayarimizdaki dosyalara ilgili islemler icin
    javadan yardim alabiliriz

    Javanin bilgisayardaki bir dosyaya ulasabilesi icin ise
    dosya youna ihtiyac vardır

    Testimiz birden fazla bilgisayarda calisacaksa
    her bilgisayarin dosya yapisi farkli olacagindan dosya
    testleri hata verebilir

    bu hataların onuna gecmek icin
    dosya yollarimizi dinamik yapmak gerekir

    dosya yolunu 2 parcaya ayiralim
    1- sadece benim bilgisayarima ozel kisim
    2- herkeste ortak olan kisim

    C:\Users\Dell           \sample.png
     */

        String dinamikDosyaYolu=System.getProperty("user.home")+ "\\sample.png";
    }
}
