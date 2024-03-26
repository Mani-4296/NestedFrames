package herokuapp.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// Navigate to the URL
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");

		// Click the "Click Here" button
		WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
		clickHereButton.click();

		// Switch to the newly opened window
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}

		// Verify that the text "New Window" is present on the page
		WebElement newWindowText = driver.findElement(By.tagName("h3"));
		if (newWindowText.getText().equals("New Window")) {
			System.out.println("Text 'New Window' is present");
		} else {
			System.out.println("Text 'New Window' is not present");
		}

		// Close the new window
		//driver.close();

		// Switch back to the original window
		driver.switchTo().window(driver.getWindowHandles().iterator().next());

		// Verify that the original window is active
		if (driver.getTitle().equals("The Internet")) {
			System.out.println("Switched back to the original window");
		} else {
			System.out.println("Failed to switch back to the original window");
		}

		// Close the browser instance
		//driver.quit();
	}

}
