package ru.stqa.training.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void myFirstTest() {
    driver.get("http://www.google.com");
    driver.get("https://www.google.com/search?q=webdriver&rlz=1C1SQJL_enAE853AE853&oq=webdriver&aqs=chrome..69i57j0l7.6849j1j8&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//img[@alt='Google']")).click();
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}