package day04_JUnitFramework_dropDown;

import org.junit.Test;
import utilities.TestBase;

public class C07_TestBaseKullanimi extends TestBase{

    @Test
    public void amazonTest(){

        //amazon ana sayfaya gidin

        driver.get("https://amazon.com");
    }
}
