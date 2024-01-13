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

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DenemeBeymen {
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

        //yazilan kelime silinir
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
        Thread.sleep(1000);
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

        WebElement secilenUrunBilgisi=driver.findElement(By.xpath("//*[@class='o-productDetail__title']"));
        System.out.println(secilenUrunBilgisi.getText());
        WebElement secilenUrunFiyat=driver.findElement(By.xpath("//*[@id='priceNew']"));
        System.out.println(secilenUrunFiyat.getText());
        String input1 = secilenUrunFiyat.getText();
        // Yazılacak metin
        String metin = secilenUrunBilgisi.getText();
        String metin1=secilenUrunFiyat.getText();

        Thread.sleep(1000);
        //- Seçilen ürün sepete eklenir.
        WebElement sepeteEkleElementi=driver.findElement(By.xpath("//button[@id='addBasket']"));
        sepeteEkleElementi.click();
        Thread.sleep(1000);
        //- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
        WebElement sepetimElementi=driver.findElement(By.xpath("//*[@class='icon icon-cart icon-cart-active']"));
        sepetimElementi.click();
        Thread.sleep(1000);

        // Dosya yolu ve adını belirtin
        String dosyaYolu1 = "src/test/java/Denemeler/Beymen.txt";


        try {
            // FileWriter ile dosyayı aç
            FileWriter dosyaYazici = new FileWriter(new File(dosyaYolu1), true);

            // BufferedWriter kullanarak daha efektif yazma işlemi yap
            BufferedWriter yazici = new BufferedWriter(dosyaYazici);

            // Metni dosyaya yaz
            yazici.write(metin);
            yazici.newLine(); // Yeni satıra geç
            yazici.write(metin1);
            yazici.newLine();

            // Dosyayı kapat
            yazici.close();

            System.out.println("Metin dosyaya başarıyla yazıldı.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazma hatası: " + e.getMessage());
        }
        Thread.sleep(1000);





        WebElement sepettekiUrunFiyati=driver.findElement(By.xpath("//span[@class='m-productPrice__salePrice']"));

        String input2 = sepettekiUrunFiyati.getText();

        String sadeceSayilar1= input1.replaceAll("\\D","");
        String sadeceSayilar2= input2.replaceAll("\\D","");
        Thread.sleep(1000);

        int tutar1 = Integer.parseInt(sadeceSayilar1);
        int tutar2 = Integer.parseInt(sadeceSayilar2)/100;
        System.out.println(tutar1);
        System.out.println(tutar2);
        Assert.assertEquals(tutar2,tutar1);

        //Assert.assertEquals(sayi1,sayi2);

        // Dosyayı kaydet
        try (FileOutputStream fileOut = new FileOutputStream("src/test/java/Denemeler/Beymen.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Rastgele ürün bilgileri dosyaya yazıldı.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='quantitySelect0-key-0']"));
        Select select=new Select(dropDownMenu);
        select.selectByIndex(1);
        String expectedAdet="2 adet";
        String actualAdet=select.getFirstSelectedOption().getText();
        System.out.println(actualAdet);
        Assert.assertEquals(expectedAdet,actualAdet);

        //- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.
        WebElement silElementi=driver.findElement(By.xpath("//button[@id='removeCartItemBtn0-key-0']"));
        silElementi.click();
        WebElement bosSepetElementi=driver.findElement(By.xpath("//*[text()='Sepetinizde Ürün Bulunmamaktadır']"));
        Assert.assertTrue(bosSepetElementi.isDisplayed());


        driver.close();
    }


}
