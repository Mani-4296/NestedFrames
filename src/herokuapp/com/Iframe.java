package herokuapp.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");

		// switching to the frame
		driver.switchTo().frame("mce_0_ifr");

		// locating the field and entering the value
		WebElement txtbox = driver.findElement(By.className("mce-content-body"));
		txtbox.clear();
		txtbox.sendKeys("Hello People");

		driver.close();

	}

}
