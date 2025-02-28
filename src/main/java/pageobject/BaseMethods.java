package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BaseMethods {

    protected WebDriver driver;

    @Step("Находим и кликаем по элементу")
    public void findAndClick (By locator){
        WebElement element = driver.findElement(locator);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Находим поле, кликаем и заполняем")
    public void insertData (By locator, String data) {
                WebElement element = driver.findElement(locator);
                new WebDriverWait(driver, Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                element.clear();
                element.sendKeys(data);
    }

    @Step("Находим элемент и возвращаем булен на наличие элемента на странице")
    public boolean findElement (By locator){
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    @Step("Находим и возвращаем текст из элемента")
    public String getText(By locator){
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    @Step("Находим и возвращаем аттрибут элемента")
    public String getAttribute(By locator,String attribute){
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attribute);
    }

}
