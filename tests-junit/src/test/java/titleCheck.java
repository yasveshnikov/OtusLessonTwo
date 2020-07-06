import com.sun.org.apache.xpath.internal.operations.Equals;
import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class titleCheck {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(titleCheck.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
        driver.get(cfg.url());
        logger.info("Открыта страница отус");
    }

    @Test
    public void titleEquals() {
        String title = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        assertEquals(title, driver.getTitle());
        logger.info("Проверка title");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}