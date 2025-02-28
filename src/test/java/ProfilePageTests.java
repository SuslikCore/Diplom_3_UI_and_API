import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static pageobject.LoginPage.LOGIN_PAGE_URL;
import static pageobject.MainPage.MAIN_PAGE_URL;
import static pageobject.ProfilePage.PROFILE_PAGE_URL;

public class ProfilePageTests extends BaseUITest{

    @Test
    @DisplayName("Переход на страницу профиля")
    @Description("Для зарегистрированного пользователя")
    public void goToProfilePageTest(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        mainPage.clickAccountLink();

        softAssertions.assertThat(profilePage.getProfileText()).isEqualTo("Профиль");
        softAssertions.assertThat(driver.getCurrentUrl()).isEqualTo(PROFILE_PAGE_URL);
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу ")
    @Description("Через ссылку Конструктор")
    public void goToMainPageFromProfilePageViaConstructorButton(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        mainPage.clickAccountLink();
        profilePage.clickConstructorLink();

        Assert.assertEquals(MAIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу")
    @Description("Через ссылку 'Лого'")
    public void goToMainPageFromProfilePageViaLogoLink(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        mainPage.clickAccountLink();
        profilePage.clickBurgerLogoLink();

        Assert.assertEquals(MAIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из профиля")
    @Description("Через кнопку 'Выйти'")
    public void logOutViaLogOutButtonFromProfilePageTest(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        mainPage.clickAccountLink();
        profilePage.clickLogOutButton();
        loginPage.allElementsArePresent();

        Assert.assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }
}
