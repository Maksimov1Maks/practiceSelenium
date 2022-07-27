import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class PracticeExplicitlyWait extends BaseTest{

    @Test
    public void test1() {
        base.openPage("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.xpath("//button[normalize-space(.)='Click me, to Open an alert after 5 seconds']")).click();
        Alert alert = (new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.alertIsPresent()));
        alert.accept();

        driver.findElement(By.xpath("//button[normalize-space(.)='Change Text to Selenium Webdriver']")).click();
        Boolean el1 = (new WebDriverWait(driver,Duration.ofSeconds(12)).until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//h2[normalize-space(.)='site']"),"site")));
        WebElement el2 = driver.findElement(By.xpath("//h2[normalize-space(.)='Selenium Webdriver']"));
        Assert.assertEquals(el2.getText(),"Selenium Webdriver");

        driver.findElement(By.xpath("//button[normalize-space(.)='Display button after 10 seconds']")).click();
        WebElement el3 = (new WebDriverWait(driver,Duration.ofSeconds(12)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(.)='Enabled']"))));
        el3.click();
        Boolean el4 = (new WebDriverWait(driver,Duration.ofSeconds(12)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[normalize-space(.)='Enabled']"))));

        driver.findElement(By.xpath("//button[normalize-space(.)='Enable button after 10 seconds']")).click();
        WebElement el5 = (new WebDriverWait(driver,Duration.ofSeconds(12)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(.)='Button']"))));
        el5.click();

        driver.findElement(By.xpath("//button[normalize-space(.)='Check Checkbox after 10 seconds']")).click();
        Boolean el6 = (new WebDriverWait(driver,Duration.ofSeconds(12)).until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//input[@id='ch']"),true)));
    }
}
