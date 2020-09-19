package com.eviltester.webdriver;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;



public class MyFirstTest {
 @Test
    public void startWebDriver(){
  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     driver.navigate().to("http://seleniumsimplified.com");
     Assertions.assertTrue(driver. getTitle().startsWith("Selenium Simplified"));
     driver.close();
     driver.quit();
 }
}
