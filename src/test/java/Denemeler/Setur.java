package Denemeler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Setur {

    public WebDriver driver;
    public final String baseURL = "https://www.setur.com.tr/";

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(baseURL);
    }

    @Test
    public void testSeturPage() throws InterruptedException, IOException {
        // Setur URL'sini kontrol et
        assertEquals(baseURL, driver.getCurrentUrl());

        Thread.sleep(5000);

        //reklam popup kapat
        driver.findElement(By.xpath("//span[@class='ins-close-button']")).click();
        Thread.sleep(5000);
        //kvkk izin ver
        driver.findElement(By.xpath("//*[text()='Tümüne izin ver']")).click();

        // Ana sayfadaki otel tabinin default olarak geldiğini kontrol et
        WebElement hotelIntroduction = driver.findElement(By.xpath("//span[@class='sc-363be8ce-0 gvnHSD']"));
        assertTrue(hotelIntroduction.isDisplayed());

        // "Nereye gideceksiniz" alanına "Antalya" yaz
        WebElement destinationInput = driver.findElement(By.xpath("//input[@class='sc-bde938b1-0 kLxiFo']"));
        destinationInput.sendKeys("Antalya");
        destinationInput.click();

        Thread.sleep(2000);

        //En üstteki Antalya seçeneğine tıkla
        WebElement antalyaOption = driver.findElement(By.xpath("(//*[text()='Antalya'])[1]"));
        antalyaOption.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_UP).perform();
        boolean nisanBulundu = false;
        driver.findElement(By.xpath("//*[text()='Giriş - Çıkış Tarihleri']")).click();

        WebElement tumBodyElementi=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBodyElementi.getText());

        for (int i = 0; i < 3; i++) { // 3 ay boyunca dön
            WebElement nextMonthButton = driver.findElement(By.xpath("(//*[@id=\"__next\"]//button[2])[2]"));
            actions.moveToElement(nextMonthButton).click().perform();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
/*
        WebElement nisanAyiElementi = driver.findElement(By.xpath("//*[text()='Nisan 2024']"));
        String arananAy = nisanAyiElementi.getText();
        Thread.sleep(2000);

        if (arananAy.contains("Nisan")) {
            nisanBulundu = true;
            return;
        } else {
        }
*/

       //1 nisan ile 7 nisan araligini sec
        driver.findElement(By.xpath("(//td[@style='width: 33px; height: 32px;'])[61]")).click();
        driver.findElement(By.xpath("(//td[@style='width: 33px; height: 32px;'])[67]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[text()='1 Oda, 2 Yetişkin   ']")).click();
        driver.findElement(By.xpath("(//button[@class='sc-423a98f0-1 fYtyaG'])[2]")).click();

        // ara butonu gorunurlugu test edilir ve tiklanir
        WebElement araElementi=driver.findElement(By.xpath("//button[@class='sc-8de9de7b-0 dYTYAP']"));
        araElementi.isDisplayed();
        araElementi.click();
        Thread.sleep(3000);
        //acilan url icindeki "antalya" icerdigini kontrol et
        URL url=new URL("https://www.setur.com.tr/antalya-otelleri?in=2024-06-30&out=2024-07-06&room=3&isBooker=true");
        HttpURLConnection hr=(HttpURLConnection) url.openConnection();
        System.out.println(hr.getResponseCode());
        Thread.sleep(3000);
        if (hr.getResponseCode()==200){
            InputStream inputStream=hr.getInputStream();
            StringBuffer stringBuffer=new StringBuffer();
            //BufferedReader bufferedReader=new BufferedReader()
        }
        Scanner s = null;
        try {
            s = new Scanner(url.openConnection().getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (s.hasNextLine())
            System.out.println(s.nextLine());


    }

        @After
        public void tearDown () {
            // WebDriver'ı kapat

                //driver.quit();

        }
    }

