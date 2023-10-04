package day03_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Before_AfterClass {

    // 3 ayri test method'u olusturup, asagidaki 3 gorevi bu method'larda yapin
    // 1- amazon anasayfaya gidip title'in "Amazon" icerdigini test edin
    // 2- Nutella aratip, arama sonuclarinin "Nutella" icerdigini test edin
    // 3- Ilk urune tiklayin, ilk urun sayfasi acildiginda,
    //    urun isminin "Nutella" icerdigini test edin

    /*
    Eger class icinde calistiracagimiz test methodlari
    belirli adimlarla ilerliyorsa bir test methodunun
    saglikli calismasi baska bir test methodunun calismasina
    bagli ise her methoddan sonra diriveri kapatip sonraki methodda
    acmak mantikli olmaz.
    Bunun yerine testlerin sirali calismasini saglamak icin tets01,
    test02, gibi isimler verşp dirvarin en basta olusturulması
    ve test methodlarının tamami calistirildiktan
    sonra kapatilmasi icin @Before ve @After notasyonlari yerine
    @BeforeClass ve @AfterClass notasyonlari kullanilir

     @BeforeClass ve @AfterClass notasyonlari kullanirken
     dikkat edilmesi gereken konu bu notasyonların static olmasi
     gereklidir.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
       driver.close();
    }
    @Test
    public void test01(){
        // 1- amazon anasayfaya gidip title'in "Amazon" icerdigini test edin

        driver.get("https://amazon.com");
        String expectedIcerik= "Amazon";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("amazon testi PASSED");
        }else {
            System.out.println("amazon testi FAILD");
        }
    }

    @Test
    public void test02(){
// 2- Nutella aratip, arama sonuclarinin "Nutella" icerdigini test edin

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonucElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedIcerik="Nutella";
        String actualAramaSonucu=aramaSonucElementi.getText();

        if (actualAramaSonucu.contains(expectedIcerik)){
            System.out.println("nutella arama testi PASSED");

        }else {
            System.out.println("nutella arama testi FAILD");
        }
    }

    @Test
    public void test03(){
        // 3- Ilk urune tiklayin, ilk urun sayfasi acildiginda,

        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"))
                .click();
        //    urun isminin "Nutella" icerdigini test edin

        String ilkUrunIsım=driver.findElement(By.xpath("//span[@id='productTitle']"))
                .getText();
        String expectedIcerik="Nutella";

        if (ilkUrunIsım.contains(expectedIcerik)){
            System.out.println("ilk urun testi Passed");
        }else {
            System.out.println("ilk urun testi FAILD");
        }
    }

}

