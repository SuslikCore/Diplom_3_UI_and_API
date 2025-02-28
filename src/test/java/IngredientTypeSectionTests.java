import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeSectionTests extends BaseUITest{

    @Test
    @DisplayName("Переход в секцию Булки")
    @Description("Кликаем по любой из секций кроме Булки, а потом кликаем по секции Булки")
    public void selectBunSectionTest(){

        mainPage.openMainPage();
        mainPage.clickSauceSection();
        mainPage.clickBunSection();

        Assert.assertTrue(mainPage.selectedBunIsPresent());
    }

    @Test
    @DisplayName("Переход в секцию соус")
    @Description("Кликаем по секции и проверяем")
    public void selectSauceSectionTest(){

        mainPage.openMainPage();
        mainPage.clickSauceSection();
        mainPage.allElementsArePresent();

        Assert.assertTrue(mainPage.selectedSauceIsPresent());
    }

    @Test
    @DisplayName("Переход в секцию Начинки")
    @Description("Кликаем по секции и проверяем")
    public void selectFillingSectionTest(){

        mainPage.openMainPage();
        mainPage.clickFillingSection();
        mainPage.allElementsArePresent();

        Assert.assertTrue(mainPage.selectedFillingIsPresent());
    }

}
