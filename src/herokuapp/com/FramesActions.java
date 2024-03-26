package herokuapp.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FramesActions {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        // Switch to the top frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

        // Verify that there are three frames on the page
        WebElement frameLeft = driver.findElement(By.cssSelector("frame[name='frame-left']"));
        WebElement frameMiddle = driver.findElement(By.cssSelector("frame[name='frame-middle']"));
        WebElement frameRight = driver.findElement(By.cssSelector("frame[name='frame-right']"));

        // Switch to the left frame
        driver.switchTo().frame(frameLeft);

        // Verify that the left frame has a text "LEFT"
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Left frame text: " + leftFrameText);
        // Assuming the text is an exact match
        assert leftFrameText.equals("LEFT");

        // Switch back to the top frame
        driver.switchTo().parentFrame();

        // Switch to the middle frame
        driver.switchTo().frame(frameMiddle);

        // Verify that the middle frame has a text "MIDDLE"
        String middleFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Middle frame text: " + middleFrameText);
        // Assuming the text is an exact match
        assert middleFrameText.equals("MIDDLE");

        // Switch back to the top frame
        driver.switchTo().parentFrame();

        // Switch to the right frame
        driver.switchTo().frame(frameRight);

        // Verify that the right frame has a text "RIGHT"
        String rightFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Right frame text: " + rightFrameText);
        // Assuming the text is an exact match
        assert rightFrameText.equals("RIGHT");

        // Switch back to the top frame
       driver.switchTo().defaultContent();
        
        // Switch to the bottom frame
        WebElement bottomFrame = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));
        driver.switchTo().frame(bottomFrame);
       // driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));

        
        // Verify that the bottom frame has a text "BOTTOM"
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Bottom frame text: " + bottomFrameText);
        // Assuming the text is an exact match
        assert bottomFrameText.equals("BOTTOM");

        // Switch back to the top frame
        driver.switchTo().defaultContent();

        // Verify that the page title is "Frames"
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);
        // Assuming the title is an exact match
        assert pageTitle.equals("Frames");

        //Close the browser
        driver.quit();
    }

	}
