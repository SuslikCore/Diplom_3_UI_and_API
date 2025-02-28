package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginPage extends BaseMethods {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //URLs
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    //xpaths
    private By registerLink = By.xpath(".//a[contains (@href, 'register') and contains(text(),'Зарегистрироваться')]");
    private By inputEmail = By.xpath(".//input[@name = 'name']");
    private By inputPassword = By.xpath(".//input[@name = 'Пароль']");
    private By loginButton = By.xpath(".//button[contains(text(),'Войти')]");
    private By textLogin = By.xpath(".//h2[contains(text(),'Вход')]");

    //Методы
    @Step("Находим и кликаем по ссылки регистрации")
    public void clickRegisterButton() {
        allElementsArePresent();
        findAndClick(registerLink);
    }

    @Step("Вводим почту и пароль, заходим")
    public void loginIn(String email, String password) {
        allElementsArePresent();
        insertData(inputEmail, email);
        insertData(inputPassword, password);
        findAndClick(loginButton);
    }

    @Step("Проверяем что слово 'Вход' есть на странице")
    public boolean loginElementIsPresent() {
        allElementsArePresent();
        return findElement(textLogin);
    }

    @Step("Открываем страницу логина")
    public void openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    @Step("Проверяем наличие элементов на странице")
    public void allElementsArePresent() {
        List<By> locators = List.of(registerLink, inputEmail, inputPassword, loginButton, textLogin);
        for (int i = 0; i < locators.size(); i++) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(locators.get(i)));
        }
    }
}
