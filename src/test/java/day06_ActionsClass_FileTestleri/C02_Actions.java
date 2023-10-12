package day06_ActionsClass_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void dragAndDropTesti() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeElementi=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHereElementi=dragMeElementi.findElement(By.xpath("//div[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi="Dropped!";
        WebElement droppedYazsiElementi=dragMeElementi.findElement(By.xpath("//div/p[text()='Dropped!']"));
        String actualYazi=droppedYazsiElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        Thread.sleep(2000);
    }
}
