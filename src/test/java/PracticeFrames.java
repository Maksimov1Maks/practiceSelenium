import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PracticeFrames extends BaseTest{

    @Test
    public void test4() {
        base.openPage("https://chercher.tech/practice/frames-example-selenium-webdriver");
        driver.switchTo().frame("frame1");
        driver.findElement(By.xpath("//body//input")).sendKeys("TopicFrame1");

        WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@id='a']")).click();

        driver.switchTo().defaultContent();
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
        driver.switchTo().frame(frame2);
        new Select(driver.findElement(By.xpath("//select[@id='animals']"))).selectByVisibleText("Baby Cat");
    }
}
