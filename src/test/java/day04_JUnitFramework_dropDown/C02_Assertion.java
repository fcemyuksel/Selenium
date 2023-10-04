package day04_JUnitFramework_dropDown;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {
    int sayi1 = 210;
    int sayi2 = 100;


    @Test
    public void ciftSayiTesti() {

        Assert.assertTrue("sayi1 cift sayi degil", sayi1 % 2 == 0);


    }

    @Test
    public void karsilastirmaTesti() {

        Assert.assertTrue("sayi1 sayi2'den buyuk degil",sayi1 > sayi2);

        }


    @Test
    public void pozitifayiTesti() {

        Assert.assertTrue("sayi pozitiftir", sayi1 > 0);

    }
    @Test
    public void buyukolmamaTesti(){
        //sayi1'in sayi2'den buyuk olmadigini test edin
        // sayi1>sayi2 sonucunun false olmasi

        Assert.assertFalse("sayi1 sayi2'den buyuk",sayi1>sayi2);

        // eger sayi1'in sayi2'den kucuk oldugunu test edersek
        //sayi1<sayi2 ==> true olmali

    }
    @Test
    public void kucukTesti(){
        Assert.assertTrue(sayi1<sayi2);
    }
    @Test
    public void esitTesti(){
        Assert.assertEquals(sayi1,sayi2);
    }
    @Test
    public void esitDegilTesti(){
        Assert.assertNotEquals(sayi1,sayi2);
    }
}
