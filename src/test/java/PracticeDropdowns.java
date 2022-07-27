import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeDropdowns extends BaseTest{

    @Test
    public void test2() {
        base.openPage("https://chercher.tech/practice/dropdowns");
        WebElement el1 = driver.findElement(By.xpath("//select[@id='first']"));
        new Select(el1).selectByVisibleText("This is visible text");

        WebElement el2 = driver.findElement(By.xpath("//select[@id='animals']"));
        new Select(el2).selectByVisibleText("Avatar");

        WebElement el3 = driver.findElement(By.xpath("//select[@id='order-same']"));
        new Select(el3).selectByValue("Apple");

        WebElement el4 = driver.findElement(By.xpath("//select[@id='order-changed']"));
        new Select(el4).selectByValue("Google");

        WebElement el5 = driver.findElement(By.xpath("//select[@id='second']"));
        new Select(el5).selectByVisibleText("Burger");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='checkme']")).click();
        driver.findElement(By.xpath("//a[normalize-space(.)='Sample link']")).click();
        Boolean el6 = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Google")));
    }
}
