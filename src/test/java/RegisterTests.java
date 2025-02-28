import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


public class RegisterTests extends BaseUITest{

    @Test
    @DisplayName("Проверка регистрации")
    @Description("Проверка регистрации с валидными данными")
    public void successfulRegisterTest(){

        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(6);
        setGeneratedData(generatedEmail ,generatedPassword);

        registerPage.openRegisterPage();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);
        loginPage.loginIn(generatedEmail,generatedPassword);
        mainPage.clickAccountLink();

        softAssertions.assertThat(generatedEmail).isEqualTo(profilePage.getEmail());
        softAssertions.assertThat(generatedUserName).isEqualTo(profilePage.getUserName());
        softAssertions.assertAll();
    }

    @Test
    @DisplayName("Сообщение об ошибке при вводе пароля")
    @Description("Появление ошибки при вводе менее 6сти символов")
    public void incorrectPasswordTest(){
        
        String generatedEmail = generator.generateEmail(6);
        String generatedUserName = generator.generateUserName(6);
        String generatedPassword = generator.generatePassword(3);
        setGeneratedData(generatedEmail ,generatedPassword);

        loginPage.openLoginPage();
        loginPage.clickRegisterButton();
        registerPage.registerUser(generatedUserName, generatedEmail,generatedPassword);

        Assert.assertEquals("Некорректный пароль", registerPage.incorrectPasswordMessage());
    }
}
