package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {
  protected WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    FirefoxOptions options = new FirefoxOptions().setLegacy(true);
    options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\firefox-sdk\\bin\\firefox.exe")));
    driver = new FirefoxDriver(options);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
