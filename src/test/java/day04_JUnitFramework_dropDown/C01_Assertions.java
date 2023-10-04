package day04_JUnitFramework_dropDown;

import org.junit.Test;

public class C01_Assertions {
    int sayi1=10;
    int sayi2=20;
    /*
    JUnit bir tet methocu calistirirken hicbir hata
    almiyorsa testi PASSED olarak isaretler

    testin FAILD olabilmesi icin test methodu calisirken
    exeption olusturulmalidir
     */

    @Test
    public void ciftSayiTesti(){
        if (sayi1 %2==0){
            System.out.println("cift sayi testi PASSED");
        }else {
            System.out.println("cift sayi testi FAILD");
        }
    }
    @Test
    public void karsilastirmaTesti(){
        if (sayi1>sayi2){
            System.out.println("karsilastirma testi PASSED");
        }else {
            System.out.println("karsilastirma testi FAILD");
        }

    }
    @Test
    public void pozitifayiTesti(){
        if (sayi1>0){
            System.out.println("pozitif sayi testi PASSED");
        }else {
            System.out.println("pozitif sayi testi FAILD");
        }

    }
}
