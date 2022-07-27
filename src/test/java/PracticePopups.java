import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;

public class PracticePopups extends BaseTest{

    @Test
    public void test3() {

        base.openPage("https://chercher.tech/practice/popups#");
        driver.findElement(By.xpath("//input[@name='alert']")).click();
        Alert alert = (new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()));
        alert.accept();

        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='confirmation']"))).click();
        Alert confirmation = (new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()));
        confirmation.dismiss();

        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='prompt']"))).click();
        Alert prompt = (new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()));
        prompt.sendKeys("I am prompt");
        prompt.accept();

        Actions actions = new Actions(driver);
        WebElement el1 = driver.findElement(By.xpath("//button[normalize-space(.)='Sub Menu [Hover On Me]']"));
        WebElement el2 = driver.findElement(By.xpath("//a[normalize-space(.)='Google']"));
        actions.moveToElement(el1).moveToElement(el2).click().build().perform();
        Assert.assertEquals(driver.getTitle(),"Google");
        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(),"Practice handling Alerts");

        WebElement el3 = driver.findElement(By.xpath("//input[@id='double-click']"));
        actions.doubleClick(el3).build().perform();
        Alert alertDoubleClick = (new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent()));
        alertDoubleClick.accept();

        driver.findElement(By.xpath("//a[normalize-space(.)='I am broken link']")).click();
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[normalize-space(.)='The resource requested could not be found on this server!']"),"The resource requested could not be found on this server!"));
        driver.navigate().back();
        Assert.assertEquals(driver.getTitle(),"Practice handling Alerts");

        driver.findElement(By.xpath("//input[@value='Open New Window']")).click();
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        Assert.assertEquals(driver.getTitle(),"Google");
        driver.close();
        driver.switchTo().window(handles.get(0));
        Assert.assertEquals(driver.getTitle(),"Practice handling Alerts");

        driver.findElement(By.xpath("(//input[@id='textbar'])[2]")).sendKeys("John");
        new Select(driver.findElement(By.xpath("//select[@id='first']"))).selectByVisibleText("Iphone");
    }
}
