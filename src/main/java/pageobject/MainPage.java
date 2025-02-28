package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage extends BaseMethods {

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //URLs
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //xpaths
    private By loginButton = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");
    private By personalAccountLink = By.xpath(".//a[contains (@href, 'account')]");
    private By bunSection = By.xpath(".//span[contains(text(),'Булки')]/parent::div");
    private By sauceSection = By.xpath(".//span[contains(text(),'Соусы')]/parent::div");
    private By fillingSection = By.xpath(".//span[contains(text(),'Начинки')]/parent::div");

    private By selectedBunSection = By.xpath(".//div[contains(@class, 'current')]/child::span[contains(text(),'Булки')]");
    private By selectedSauceSection = By.xpath(".//div[contains(@class, 'current')]/child::span[contains(text(),'Соусы')]");
    private By selectedFillingSection = By.xpath(".//div[contains(@class, 'current')]/child::span[contains(text(),'Начинки')]");


    //Методы
    //Открыть гл страницу
    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    //Кликнуть по кнопке
    public void clickLoginButton() {
        allElementsArePresent();
        findAndClick(loginButton);
    }

    public void clickAccountLink() {
        allElementsArePresent();
        findAndClick(personalAccountLink);
    }

    public void clickBunSection(){
        allElementsArePresent();
        findAndClick(bunSection);
    }

    public void clickSauceSection(){
        allElementsArePresent();
        findAndClick(sauceSection);
    }

    public void clickFillingSection(){
        allElementsArePresent();
        findAndClick(fillingSection);
    }

    public boolean selectedBunIsPresent(){
        allElementsArePresent();
        return findElement(selectedBunSection);
    }

    public boolean selectedSauceIsPresent(){
        allElementsArePresent();
        return findElement(selectedSauceSection);
    }

    public boolean selectedFillingIsPresent(){
        allElementsArePresent();
        return findElement(selectedFillingSection);
    }

    public void allElementsArePresent() {
        List<By> locators = List.of(personalAccountLink, bunSection, sauceSection, fillingSection);
        for (int i = 0; i < locators.size(); i++) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(locators.get(i)));
        }
    }
}
