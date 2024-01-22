package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static costant.OrderBY_Constants.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MainPage {
    private WebDriver driver;//Драйвер для работы с элементами страницы

    //базовый конструктор с инициализацией драйвера
    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    //функция скрола до объекта
    public void scrollToObj(By tagFromScroll){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(tagFromScroll));
    }
    //функция клика по объекту
    public void clickToObj(By tagFromClick){
        scrollToObj(tagFromClick);
        new WebDriverWait(driver, 15);
        driver.findElement(tagFromClick).click();
        new WebDriverWait(driver, 15);
    }
    //функция верификации текста в объекте
    public String getTextObj(By tagTextObj){
        scrollToObj(tagTextObj);
        new WebDriverWait(driver, 15);
        return driver.findElement(tagTextObj).getText();
    }
    //Нажатие на кнопку заказать в хедере
    public void clickHeaderOrderButton() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }
    //Нажатие на кнопку заказать в теле
    public void clickBoddyOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(BODY_ORDER_BUTTON));
        driver.findElement(BODY_ORDER_BUTTON).click();
    }

}