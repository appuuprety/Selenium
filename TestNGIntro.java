import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class TestNG {
    public String baseUrl = "http://www.dailyskullcandy.com/registration.html";
    String driverPath = "C:\\\\\\\\Users\\\\\\\\Avishek\\\\\\\\Desktop\\\\\\\\Selenium\\\\\\\\chromedriver.exe";
    public WebDriver driver ; 
     @AfterTest                           
      public void terminateBrowser(){
          driver.close();
      }
     @BeforeTest                            
      public void launchBrowser() {
          System.out.println("launching chorme browser"); 
          System.setProperty("webdriver.chrome.driver", driverPath);
          driver =  new ChromeDriver();
          driver.get(baseUrl);
      }
      @Test                                
      public void verifyHomepageTitle() {
          String expectedTitle = "Regist";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
     }
      
}
