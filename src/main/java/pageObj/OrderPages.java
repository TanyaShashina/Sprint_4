package pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static costant.OrderBY_Constants.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class OrderPages {
    private final WebDriver driver;//Драйвер для работы с элементами страницы

    //базовый конструктор с инициализацией драйвера
    public OrderPages(WebDriver driver) {
        this.driver=driver;
    }

    //Заполнение текстовых полей страницы "Для кого самокат"
    public void setArrTxtElement(String[] txt, By Element){
        List<WebElement> elements = driver.findElements(Element);
        for(int i=0; i<elements.size();i++){
            //Нажимаем на поле
            elements.get(i).click();
            //очищаем и вставляем данные
            elements.get(i).clear();
            elements.get(i).sendKeys(txt[i]);
            new WebDriverWait(driver, 10);
        }
    }
    public void setTxtElement(String txt, By Element){
        WebElement element = driver.findElement(Element);
        //Нажимаем на поле
        element.click();
        //очищаем и вставляем данные
        element.clear();
        element.sendKeys(txt);
        new WebDriverWait(driver, 10);
    }
    public void waitToDisplay(By displayElem){
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(displayElem).isDisplayed()));
    }
    public void waitElements(){
        new WebDriverWait(driver, 10);
    }


}
