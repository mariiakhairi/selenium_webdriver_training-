package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;


public class LoginToLitecartAdmin extends TestBase {

  @Test
  public void testLoginToLitecartAdmin() {
    driver.get("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
  }

}
