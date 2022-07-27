import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    private static WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\hromdriver\\NewChrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }
}
