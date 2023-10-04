package day03_Junit;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Ignore;
import org.junit.Test;

public class C05_TestNotasyonu {

    /*
    @Test notasyonu, methodlara bagimsiz olarak calistirabilme yetenegi katar
    testlerin bagimsi olarak calisabilmesi framework uzerinde bu
    test methodalrından olusan farklı test gruplarini istedigimiz
    zamanlarda calistirma imkani tanir

    Testlerin buyukluklerine gore su sekilde siralayabiliriz

    Test Suit (Birden fazla icerir)
    - Smoke Test
    -Entegrasyon Testi
    -End2End Testing
    Test: Bir amac icin biraraya getirilmis
         Test classları, Test methodları veya Packegelardan olusur
        Ornegin bizim smoke testi icin
        -day01 packegedaki tüm classlar
         -day02 den C01 ve C03
        -day03 deki C05classındaki test01 ve test02 methodları calissin diyebilriz.

     ayni test methodlari classlar veya packegelar birden
     fazla test icin calistirilabilir

     JUnit testlerin bagimsiz calistirilmasşna şmkan tanir
     Ancak siralamayi kontrol etmez
     bizim kontrol etmemize de imkan tanimaz

     JUnit test notasyonu kullanan methodlarin static olarak
     isaretlnmesine izin vermez

     */
    @Test //Test methodu
    public void test01(){
        System.out.println("test01 calisti");
    }
    @Test @Ignore
    public void test02(){
        System.out.println("test02 calisti");
    }
    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }
}
