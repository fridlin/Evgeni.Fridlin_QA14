

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.google.co.il/search?q=google&rlz=1C1NHXL_enIL768IL768&oq=goo&aqs=chrome.4.69i60l4j0j69i65.3189j0j4&sourceid=chrome&ie=UTF-8");
    driver.findElement(By.linkText("Google")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("lst-ib")).clear();
    driver.findElement(By.id("lst-ib")).sendKeys("webdriver");
    driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Что такое Selenium WebDriver? / Хабрахабр")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_2 | ]]
    driver.findElement(By.xpath("//yatag[@id='eobyqjwq']/yatag/yatag[3]/table/tbody/tr/td/yatag/yatag[2]/yatag/yatag/yatag")).click();
    driver.findElement(By.linkText("Товар куплен или услуга найдена")).click();
    driver.findElement(By.xpath("//yatag[@id='eobyqjwq']/yatag/yatag[3]/table/tbody/tr[2]/td/yatag/yatag[2]/yatag/yatag/yatag")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Товар куплен или услуга найдена')])[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
