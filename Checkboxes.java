import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Avishek\\Desktop\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
         
	    driver.get("https://www.priceline.com/?tab=flights");
	    //driver.findElement(By.xpath("//*[@id=\'flight-search-form\']/div[4]/div/div[2]/div[1]/label/div/input")).click();  
	    //driver.findElement(By.xpath("//*[@id=\"flight-search-form\"]/div[4]/div/div[2]/div[2]/label/div/input")).click();  
	    WebElement HotelCheckbox =  driver.findElement(By.cssSelector("input[name*='Hotel']"));
	    HotelCheckbox.click();
	    if(HotelCheckbox.isEnabled()) {
	    	
	    	System.out.println("Hotel was checked");
	    	
	    }
	    
	    int checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
	    
	    
	  
	}

}
