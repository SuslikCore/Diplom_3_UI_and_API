import api.UserApi;
import browser.Browser;
import pageobject.*;
import random.generator.Generator;
import io.restassured.response.ValidatableResponse;
import model.UserData;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseUITest {

    protected WebDriver driver;
    private UserApi userApi = new UserApi();
    private UserData userData;
    private ValidatableResponse response;
    protected String generatedEmail;
    protected String generatedPassword;

    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ProfilePage profilePage;
    ForgotPasswordPage forgotPasswordPage;
    Generator generator;
    SoftAssertions softAssertions;
    Browser browser = new Browser();



    @Before
    public void startUp() throws IOException {
        driver = browser.initDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        profilePage = new ProfilePage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        generator = new Generator();
        softAssertions = new SoftAssertions();
    }

    @After
    public void tearDown(){
        deleteUser();
        driver.quit();
    }

    public void deleteUser(){
        userData = new UserData(generatedEmail,generatedPassword);
        response = userApi.loginUser(userData);
        String accessToken = response.extract().jsonPath().getString("accessToken");

        if (accessToken == null || accessToken.isEmpty()){
            System.out.println("Message: Токен пустой. Удаление токена производиться не будет");
            return;
        }
        try {
            userApi.deleteUser(accessToken).log().all();
        } catch (Exception e) {
            System.out.println("Не удалось удалить пользователя");
            throw new RuntimeException(e);
        }
    }

    public void setGeneratedData(String generatedEmail, String generatedPassword) {
        this.generatedEmail = generatedEmail;
        this.generatedPassword = generatedPassword;
    }
}
