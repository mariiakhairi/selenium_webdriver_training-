package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.compare;

public class CountrySortingTest {
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
    driver.findElements(By.xpath("//*[@id='app-']/a/span[2]")).get(2).click();
    Thread.sleep(5000);
    List<WebElement> countryList = driver.findElements(By.xpath(("//tbody/tr/td[5]")));
    for (int r = 0; r < countryList.size(); r++) {
      List<String> countries = new ArrayList<String>();
      countries.add(countryList.get(r).getText().toLowerCase());
      System.out.println(countries);
//      int len = countries.size();
//      for (int i = 0; i < len; i++)
//        for(int k = i+1 ; k < len ; k++){
//         compare(countries.get(i), countries.get(k))
//        }
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
