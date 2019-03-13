import java.io.File;

import java.io.IOException;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

public class RegistrationSkullcandy {

	public static void main(String[] args) throws IOException {

		// Setup Chrome driver replace the xxx with your location

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Avishek\\\\Desktop\\\\Selenium\\\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Put an Implicit wait,

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// get to the website

		driver.get("http://www.dailyskullcandy.com/registration.html");

		// refresh the page

		driver.navigate().refresh();

		driver.manage().window().maximize();

		// delete all the cookies.

		driver.manage().deleteAllCookies();

		// screenshot

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("C:\\\\\\\\Users\\\\\\\\Avishek\\\\\\\\Desktop\\\\\\\\Selenium\\\\\\\\screenshot.jpg"));

		// Do Stuff to test the registration screen

		// TextBoxes

		WebElement email = driver.findElement(By.id("email"));

		WebElement pwd1 = driver.findElement(By.id("pwd1"));

		WebElement pwd2 = driver.findElement(By.id("pwd2"));

		WebElement firstName = driver.findElement(By.id("FirstName"));

		WebElement middleName = driver.findElement(By.name("MidName"));

		WebElement lastName = driver.findElement(By.id("LastName"));

		WebElement jobRole = driver.findElement(By.name("JobRole"));

		WebElement phone = driver.findElement(By.name("Phone"));

		WebElement checkbox = driver.findElement(By.id("defaultCheck1"));
		
		WebElement checkboxLabel = driver.findElement(By.xpath("//label[contains(text(),'Test checkbox')]"));

		// Select boxes

		System.out.println("xxxxxxxxxxxxxxxxxxxx--ProbTypeStartHere");

		Select probTypeSelect = new Select(driver.findElement(By.id("ProbTypeID")));

		List<WebElement> probCount = probTypeSelect.getOptions();

		int iSize = probCount.size();

		for (int i = 0; i < iSize; i++) {

			String sValueProbType = probCount.get(i).getText();

			System.out.println(sValueProbType);

		}

		System.out.println("xxxxxxxxxxxxxxxxxxxx--ProbTypeEndHere");

		System.out.println("xxxxxxxxxxxxxxxxxxxx--LocationsStartHere");

		Select location = new Select(driver.findElement(By.id("LocationID")));

		List<WebElement> locationCount = location.getOptions();

		for (int j = 0; j < locationCount.size(); j++) {

			String sValueLocations = locationCount.get(j).getText();

			System.out.println(sValueLocations);

		}

		System.out.println("xxxxxxxxxxxxxxxxxxxx--LocationsEndHere--xxxxxxxxx");

		System.out.println("xxxxxxxxxxxxxxxxxxxx--AreasStartHere-xxxxxxxxxxx");

		Select areas = new Select(driver.findElement(By.id("AreaID")));

		List<WebElement> areasElements = areas.getOptions();

		for (int j = 0; j < areasElements.size(); j++) {

			String sarea = areasElements.get(j).getText();

			System.out.println(sarea);

		}

		System.out.println("xxxxxxxxxxxxxxxxxxxx-AreasEndHere");

		System.out.println("xxxxxxxxxxxxxxxxxxxx--GuestTypeStartHere");

		Select guestType = new Select(driver.findElement(By.id("GuestTypeID")));

		List<WebElement> guesTypeOpts = guestType.getOptions();

		for (int i = 0; i < guesTypeOpts.size(); i++) {

			String guestTypes = guesTypeOpts.get(i).getText();

			System.out.println(guestTypes);

		}

		System.out.println("xxxxxxxxxxxxxxxxxxxx-GuesttypeEndHere--xxxxxxxxxxxxxxxxxxxx-");

		// Create the form

		email.sendKeys("avishekuprety@something.com");

		pwd1.sendKeys("something");

		pwd2.sendKeys("something");

		firstName.sendKeys("Avishek");

		middleName.sendKeys("N/A");

		lastName.sendKeys("Uperty");

		if (!checkbox.isSelected())

		{

			checkbox.click();
			checkboxLabel.getText();
			
			System.out.println("checkbox was checked");

		}

		probTypeSelect.selectByIndex(2);

		location.selectByIndex(1);

		areas.selectByIndex(1);

		jobRole.sendKeys("Test Dude");

		phone.sendKeys("97045388855");

		guestType.selectByIndex(0);

	}
	

}
