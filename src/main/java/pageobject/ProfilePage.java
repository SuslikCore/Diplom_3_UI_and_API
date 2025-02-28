package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProfilePage extends BaseMethods {

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //URLs
    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //xpaths
    private By inputUserName = By.xpath(".//label[contains(text(),'Имя')]/following-sibling::input");
    private By inputEmail = By.xpath(".//label[contains(text(),'Логин')]/following-sibling::input");
    private By constructorLink = By.xpath(".//p[contains(text(),'Конструктор')]/parent::a");
    private By burgerLogoLink = By.xpath(".//div[contains(@class, 'logo')]/child::a");
    private By textProfile = By.xpath(".//a[contains(text(),'Профиль')]");
    private By logOutButton = By.xpath(".//button[contains(text (), 'Выход')]");


    //Методы
    public String getUserName() {
        allElementsArePresent();
        return getAttribute(inputUserName, "Value");
    }

    public String getEmail() {
        allElementsArePresent();
        return getAttribute(inputEmail, "Value");
    }

    public String getProfileText() {
        allElementsArePresent();
        return getText(textProfile);
    }

    public void clickConstructorLink() {
        allElementsArePresent();
        findAndClick(constructorLink);
    }

    public void clickBurgerLogoLink() {
        allElementsArePresent();
        findAndClick(burgerLogoLink);
    }

    public ProfilePage openProfilePage() {
        driver.get(PROFILE_PAGE_URL);
        return this;
    }

    public void clickLogOutButton() {
        allElementsArePresent();
        findAndClick(logOutButton);
    }

    public void allElementsArePresent() {
        List<By> locators = List.of(inputUserName, inputEmail, constructorLink, burgerLogoLink, textProfile, logOutButton);
        for (int i = 0; i < locators.size(); i++) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(locators.get(i)));
        }
    }
}
