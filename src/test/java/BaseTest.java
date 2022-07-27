import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = Base.createDriver();
    protected Base base = new Base(driver);

    @BeforeTest
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void close() {
        driver.quit();
    }

}
