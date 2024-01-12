package Denemeler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Beymen {
    Sheet sayfa1;

    @Test
    public void test01() throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.beymen.com/");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("(//*[@class='icon icon-close'])[2]")).click();


        // sayfaya giris kontrol
        WebElement hesabimElement = driver.findElement(By.xpath("//a[@title='Hesabım']"));
        Assert.assertTrue(hesabimElement.isDisplayed());


        driver.findElement(By.xpath("//header[@class='o-header']")).click();

        String dosyaYolu = "src/test/java/Denemeler/Beymen.xlsx";
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(dosyaYolu);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        WebElement searchBoxelement = driver.findElement(By.xpath("//input[@id='o-searchSuggestion__input' and @placeholder='Ürün, Marka Arayın']"));

        sayfa1 = workbook.getSheet("Sayfa1");
        Row row = sayfa1.getRow(0);
        Cell cell = row.getCell(0);

        searchBoxelement.sendKeys(cell.getStringCellValue());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@class='o-header__search--close -hasButton']")).click();
        Thread.sleep(1000);


        row = sayfa1.getRow(0);
        Thread.sleep(1000);

        cell = row.getCell(1);
        Thread.sleep(1000);
        searchBoxelement.sendKeys(cell.getStringCellValue()+ Keys.ENTER);

        // Sonuca göre sergilenen ürünlerden rastgele bir ürünü seç
        // Sonuca göre sergilenen ürünleri al
        List<WebElement> productList = driver.findElements(By.xpath("//*[@id=\"productList\"]/div/*"));
        productList.size();

        // Rastgele bir ürün seç
        Random random = new Random();
        int randomIndex = random.nextInt(productList.size());
        WebElement selectedProduct = productList.get(randomIndex);
        Thread.sleep(2000);
        // Seçilen ürünü tıkla
        selectedProduct.click();

        List<WebElement> bedenElementi=driver.findElements(By.xpath("//span[@class='m-variation__item']"));
        boolean control=true;
        int index=0;
        if(bedenElementi.size()>0){
            while (control){
                WebElement secilenBeden=bedenElementi.get(index);
                String classValue=secilenBeden.getAttribute("class");
                if (!classValue.contains("disabled")){
                    control=false;
                }
            }

            bedenElementi.get(index).click();
        }else {
            bedenElementi=driver.findElements(By.xpath("//span[@class='m-variation__item -criticalStock']"));
         index=0;
         bedenElementi.get(index).click();
        }

        Thread.sleep(3000);
        //- Seçilen ürün sepete eklenir.
        WebElement sepeteEkleElementi=driver.findElement(By.xpath("//button[@id='addBasket']"));
        sepeteEkleElementi.click();
        Thread.sleep(3000);
        //- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        WebElement sepetimElementi=driver.findElement(By.xpath("//*[@class='icon icon-cart icon-cart-active']"));
        sepetimElementi.click();
        Thread.sleep(3000);

        //------------------------------- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.-------------------------

        //List<WebElement> secilenUrunAdi=driver.findElements(By.xpath("//*[@class='o-productDetail__title']"));
       // for (WebElement each:secilenUrunAdi){
        //    System.out.println(each.getText());
       // }


        WebElement secilenUrunBilgisi=driver.findElement(By.xpath("//span[@class='o-productDetail__description']"));
        System.out.println(secilenUrunBilgisi.getText());
        WebElement secilenUrunFiyat=driver.findElement(By.xpath("//*[@id='priceNew']"));
        System.out.println(secilenUrunFiyat.getText());
        WebElement sepettekiUrunFiyati=driver.findElement(By.xpath("//span[@class='m-productPrice__salePrice']"));
        String input1 = secilenUrunFiyat.getText();
        String input2 = sepettekiUrunFiyati.getText();

        String sadeceSayilar1= input1.replaceAll("\\D","");
        String sadeceSayilar2= input2.replaceAll("\\D","");

        System.out.println(sadeceSayilar1);
        System.out.println(sadeceSayilar2);
        int sayi1 = Integer.parseInt(sadeceSayilar1);
        int sayi2 = Integer.parseInt(sadeceSayilar2);

        double sonuc = (double)(sayi1 + sayi2)  / 100 ;

        System.out.println(sonuc + " €"); // 26.7






        //System.out.println(secilenUrunBilgisi.getText());
        System.out.println(secilenUrunFiyat.getText());
        System.out.println(bedenElementi);
        //sayfa1.getRow(1).createCell(2).s
        Thread.sleep(2000);
        // Yeni bir satır ekleyerek bilgileri yaz
        FileOutputStream fileOutputStream=new FileOutputStream(dosyaYolu);

        //int rowCount = sayfa1.getPhysicalNumberOfRows();
        //Row row2 = sayfa1.createRow(rowCount);
        // Ürün bilgisi
        //Cell cellProductName = row.createCell(2);
        //cellProductName.setCellValue(selectedProduct.getText());
        //Thread.sleep(2000);
        // Tutar bilgisi
        //Cell cellProductPrice = row.createCell(3);
        sayfa1.getRow(1).createCell(4).setCellValue(1);
        // 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(4).setCellValue(2);
        // 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(4).setCellValue(54);
        // Dosyayi kaydedelim
        workbook.write(fileOutputStream);
        //Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
        //cellProductPrice.setCellValue(selectedProduct.getCssValue());

        // Dosyayı kaydet
        try (FileOutputStream fileOut = new FileOutputStream("src/test/java/Denemeler/Beymen.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Rastgele ürün bilgileri Excel dosyasına yazıldı.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='quantitySelect0-key-0']"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("2");
        String expectedAdet="2 adet";
        String actualAdet=dropDownMenu.getText();
        Assert.assertEquals(expectedAdet,actualAdet);

        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
        WebElement silElementi=driver.findElement(By.xpath("//button[@id='removeCartItemBtn0-key-0']"));
        silElementi.click();
        WebElement bosSepetElementi=driver.findElement(By.xpath("//*[text()='Sepetinizde Ürün Bulunmamaktadır']"));
        Assert.assertTrue(bosSepetElementi.isDisplayed());


    }


}
