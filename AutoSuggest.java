mport org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\xxxx\\Desktop\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement autocompleteBox = driver.findElement(By.id("autocomplete"));
		autocompleteBox.sendKeys("ind");
		Thread.sleep(2000);
		autocompleteBox.sendKeys(Keys.DOWN);
		autocompleteBox.sendKeys(Keys.DOWN);
		System.out.println(autocompleteBox.getAttribute("value"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Spt = "return document.getElemenById(\"autocomplete\")).value;";
		String text = (String) js.executeScript(Spt);
		System.out.println(text);
		int i = 0;
		while (!text.equalsIgnoreCase("India")) {

			i++;

			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

			text = (String) js.executeScript(Spt);

			System.out.println(text);

			if (i > 5) {

				break;

			}

		}

	}

}
