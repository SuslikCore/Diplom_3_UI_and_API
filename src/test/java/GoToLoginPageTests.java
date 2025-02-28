import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static pageobject.LoginPage.LOGIN_PAGE_URL;

public class GoToLoginPageTests extends BaseUITest{

    @Test
    @DisplayName("Переход на стр авторизации")
    @Description("Переход через кнопку 'Войти в аккаунт' на главной странице")
    public void goToLoginPageViaLoginAccountButtonTest(){

        mainPage.openMainPage();
        mainPage.clickLoginButton();
        softAssertions.assertThat(loginPage.loginElementIsPresent()).isEqualTo(true);
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(LOGIN_PAGE_URL);
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Переход на стр авторизации ")
    @Description("Переход через кнопку 'Личный кабинет' на главной странице")
    public void goToLoginPageViaLoginAccountLinkTest(){

        mainPage.openMainPage();
        mainPage.clickAccountLink();
        softAssertions.assertThat(loginPage.loginElementIsPresent()).isEqualTo(true);
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(LOGIN_PAGE_URL);
        softAssertions.assertAll();

    }

    @Test
    @DisplayName("Переход на стр авторизации ")
    @Description("Переход через ссылку вход 'Личный кабинет' на странице регистрации")
    public void goToLoginPageViaLoginLinkInRegistrationPageTest(){

        registerPage.openRegisterPage();
        registerPage.loginLink();
        softAssertions.assertThat(loginPage.loginElementIsPresent()).isEqualTo(true);
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(LOGIN_PAGE_URL);
        softAssertions.assertAll();

    }

    @Test
    @DisplayName("Переход на стр авторизации ")
    @Description("Переход через ссылку вход 'Личный кабинет' на странице забыл пароль")
    public void goToLoginPageViaLoginLinkInForgotPasswordPageTest(){

        forgotPasswordPage.openPage();
        forgotPasswordPage.clickLoginLink();

        softAssertions.assertThat(loginPage.loginElementIsPresent()).isEqualTo(true);
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(LOGIN_PAGE_URL);
        softAssertions.assertAll();
    }
}
