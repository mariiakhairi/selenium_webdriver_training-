package ru.stqa.training.selenium;


import org.junit.Test;
import org.openqa.selenium.By;

public class MyFirstTest extends TestBase {

  @Test
  public void myFirstTest() {
    driver.get("http://www.google.com");
    driver.get("https://www.google.com/search?q=webdriver&rlz=1C1SQJL_enAE853AE853&oq=webdriver&aqs=chrome..69i57j0l7.6849j1j8&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.xpath("//img[@alt='Google']")).click();
  }

}