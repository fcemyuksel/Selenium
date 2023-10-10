package day04_JUnitFramework_dropDown;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C08_DropDownMenu extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //dropDown menude islem yapabilmek icin
        WebElement ddm=driver.findElement(By.xpath("(//select[@id='dropdown'])"));
        Select select=new Select(ddm);
        //	1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //select.selectByVisibleText("Option 1");
        select.selectByIndex(1);
        //select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());
        //	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //	4.Tüm dropdown değerleri(value) yazdırın
        System.out.println("===================");
        List<WebElement> optionsList=select.getOptions();
        for (WebElement each:optionsList){
            System.out.println(each.getText());
        }
        //	5. Dropdown’un boyutunun 4 olduğunu test edin
        int expectedListSize=4;
        int actulaListSize= optionsList.size();

        Assert.assertEquals(expectedListSize,actulaListSize);

        Thread.sleep(2000);

    }

}
