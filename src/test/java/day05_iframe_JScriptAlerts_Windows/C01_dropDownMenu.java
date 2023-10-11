package day05_iframe_JScriptAlerts_Windows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C01_dropDownMenu extends TestBase_BeforeClass {

    Select select;
        @Test
    public void test01(){
                //● https://www.amazon.com/ adresine gidin.

            driver.get("https://www.amazon.com/");

            //- Test 1
            //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
            WebElement menuElementi=driver.findElement(By.xpath("//select[@*='Search in']"));
            select=new Select(menuElementi);

            int expectedKategoriSayisi=45;

            List<WebElement> kategoriList=select.getOptions();
            int actualKategoriSayisi=kategoriList.size();
            Assert.assertEquals(expectedKategoriSayisi,actualKategoriSayisi);

        }
    @Test
        public void test02(){
        //-Test 2
        //	1. Kategori menusunden Books secenegini  secin
        WebElement menuElementi=driver.findElement(By.xpath("//select[@*='Search in']"));
        select=new Select(menuElementi);
        select.selectByVisibleText("Books");
        //	2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        //	3. Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisiElementi.getText());
        //	4. Sonucun Java kelimesini icerdigini test edin

        String expectedSonucIcerik="Java";
        String actualSonucYazisi=sonucSayisiElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));


}



}
