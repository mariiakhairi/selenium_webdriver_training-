package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GeoZoneTest {
  private WebDriver driver;


  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAdminMenu() throws Exception {
    gotoTestPage("http://localhost/litecart/admin/login.php");
    login();
    Thread.sleep(2000);
    driver.findElements(By.xpath("//li[@id='app-']/a/span[2]")).get(5).click();
    driver.findElement(By.linkText("United States of America")).click();
    List<WebElement> geoZone = driver.findElements(By.cssSelector("table.dataTable option[selected]"));
    for (int i = 1; i < geoZone.size(); i=i+2) {
      String g = geoZone.get(i).getAttribute("textContent").toLowerCase();
      for (int j = i + 2; j < geoZone.size() - 1; j=j+2) {
        String m = geoZone.get(j).getAttribute("textContent").toLowerCase();
        if (g.compareTo(m) < 0) {
          System.out.println(g + " is sorted correctly before " + m);
        }
      }
    }
    driver.findElements(By.xpath("//*[@id='app-']/a/span[2]")).get(5).click();
    Thread.sleep(2000);
    driver.findElement(By.linkText("Canada")).click();
    List<WebElement> geoZone2 = driver.findElements(By.cssSelector("table.dataTable option[selected]"));
    for (int i = 1; i < geoZone2.size(); i=i+2) {
      String k = geoZone2.get(i).getAttribute("textContent").toLowerCase();
      for (int j = i + 2; j < geoZone2.size() - 1; j=j+2) {
        String l = geoZone2.get(j).getAttribute("textContent").toLowerCase();
        if (k.compareTo(l) < 0) {
          System.out.println(k + " is sorted correctly before " + l);
        }
      }
    }
  }


  private void login() {
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
  }

  private void gotoTestPage(String url) {
    driver.get(url);
  }

  public boolean isElementPresent(WebDriver driver, By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public boolean areElementsPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
