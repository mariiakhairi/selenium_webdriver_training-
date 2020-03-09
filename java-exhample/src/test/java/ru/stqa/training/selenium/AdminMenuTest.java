package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminMenuTest {
  private WebDriver driver;


  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAdminMenu() throws Exception {
    gotoTestPage();
    login();
    for (int a=0; a<33; a=a+2 ) {
      driver.findElements(By.xpath("//*[@id='app-']/a/span")).get(a).click();
      Thread.sleep(2000);
      isElementPresent(By.xpath("//*[@id='content']/h1"));
      if (areElementsPresent(By.xpath("//ul[@class='docs']/li"))){
        List<WebElement> subItem = driver.findElements(By.xpath("//ul[@class='docs']/li"));
        for (int j=0; j<subItem.size(); j++){
          driver.findElements(By.xpath("//ul[@class='docs']/li")).get(j).click();
          isElementPresent(By.xpath("//*[@id='content']/h1"));
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

  private void gotoTestPage() {
    driver.get("http://localhost/litecart/admin/login.php");
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
