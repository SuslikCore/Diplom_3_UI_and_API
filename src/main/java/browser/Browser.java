package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Browser {

    protected WebDriver driver;

    public WebDriver initDriver() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");
        BrowserType browserType = BrowserType.valueOf(browserProperty);

        switch (browserType){
            case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    initImplicityWait();
                break;
            case YANDEX:
                    System.setProperty("webdriver.chrome.driver", "D:/YandexDriver/yandexdriver.exe");
                    ChromeOptions yandexProperties = new ChromeOptions();
                    driver = new ChromeDriver(yandexProperties);
                    driver.manage().window().maximize();
                    initImplicityWait();
                break;
            default:
                throw new RuntimeException("Browser undefined");
        };
        return driver;
    }

    public void initImplicityWait(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
