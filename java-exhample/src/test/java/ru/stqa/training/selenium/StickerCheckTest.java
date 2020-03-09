package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StickerCheckTest {
  private WebDriver driver;


  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAdminMenu() throws Exception {
    gotoTestPage("http://localhost/litecart/en/");
    Thread.sleep(5000);
    List<WebElement> allGoods = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
    for (int a = 0; a < allGoods.size(); a++) {
      WebElement oneGood = allGoods.get(a).findElement(By.xpath("//*[@class='box']/div/ul/li/a/div/div"));
      System.out.println("Element found" + oneGood);
    }
  }


  private void gotoTestPage(String url) {
    driver.get(url);
  }


  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

}
