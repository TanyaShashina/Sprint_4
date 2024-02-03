package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObj.MainPage;
import pageObj.OrderPages;

import static costant.CustomerTest_Constant.*;
import static costant.OrderBY_Constants.*;
import static costant.URL_Constant.HOME_P_URL;

public class OrderPages_Test {
    //создаём драйвера
    public WebDriver Gdriver;
    public WebDriver Mdriver;
    @Before
    public void createDriver(){
        Gdriver = new ChromeDriver();
        //FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--headless");
        Mdriver = new FirefoxDriver();

    }

    //закрываем браузер после теста
    @After
    public void quitDriver(){
        Gdriver.quit();
    }
    //Заказ через кнопку в шапке страници
    @Test
    public void createOrderHB(){
        Mdriver.get(HOME_P_URL);
        MainPage mainP = new MainPage(Mdriver);
        OrderPages orderP = new OrderPages(Mdriver);
        //открываем форму заказа
        mainP.clickHeaderOrderButton();
        //заполняем форму "Для кого самокат"
        String[] data = new String[] {CUSTOMER_NAME, CUSTOMER_SNAME, CUSTOMER_ADRESS, CUSTOMER_NUMBER};
        orderP.setArrTxtElement(data,INPUT_STRING_PAGEF);
        mainP.clickToObj(INPUT_METRO_PAGEF);
        orderP.waitToDisplay(METROSTATION_PAGEF);
        mainP.clickToObj(METROSTATION_PAGEF);
        mainP.clickToObj(BUTTON_NEXTPAGE_PAGEF);
        //заполняем форму "Про аренду"(обязательные поля)
        orderP.waitElements();
        //Заполнили дату аренды
        mainP.clickToObj(DATE_PICK_PAGEW);
        orderP.waitToDisplay(FIRST_MONTH_DATE);
        mainP.clickToObj(FIRST_MONTH_DATE);
        //Заполняем срок аренды
        mainP.clickToObj(RENT_TIME_PAGEW);
        orderP.waitToDisplay(ONE_DAY_RENT_TIME);
        mainP.clickToObj(ONE_DAY_RENT_TIME);
        //Выбираем черный цвет самоката
        mainP.clickToObj(COLOR_BLACK_BYIKE);
        orderP.waitElements();
        //Заполням коммент для курьера
        orderP.setTxtElement(CUSTOMER_COMMENT,COMMENT_FOR_CUR);
        orderP.waitElements();
        //принимаем куки что бы нажать кнопку "Заказать"
        mainP.clickToObj(ORDER_CONFIRM_COCKIES);
        orderP.waitElements();
        //Нажимаем кнопку Заказать
        mainP.clickToObj(ORDER_PAGEW);
        //Нажимаем кнопку "Да"
        mainP.clickToObj(YES_PAGEW);
        //Ждём заголовка "Заказ оформлен"
        Assert.assertEquals("Заказ не оформлен, не появилась модалка 'Заказ оформлен'", true, Mdriver.findElement(ORDER_CONFIRM).isDisplayed());

    }
    //Заказ через кнопку в теле страници
    @Test
    public void createOrderBB(){
        Gdriver.get(HOME_P_URL);
        MainPage mainP = new MainPage(Gdriver);
        OrderPages orderP = new OrderPages(Gdriver);
        //открываем форму заказа
        mainP.clickBoddyOrderButton();
        //заполняем форму "Для кого самокат"
        String[] data = new String[] {CUSTOMER_NAME, CUSTOMER_SNAME, CUSTOMER_ADRESS, CUSTOMER_NUMBER};
        orderP.setArrTxtElement(data,INPUT_STRING_PAGEF);
        mainP.clickToObj(INPUT_METRO_PAGEF);
        orderP.waitToDisplay(METROSTATION_PAGEF);
        mainP.clickToObj(METROSTATION_PAGEF);
        mainP.clickToObj(BUTTON_NEXTPAGE_PAGEF);
        //заполняем форму "Про аренду"(обязательные поля)
        orderP.waitElements();
        //Заполнили дату аренды
        mainP.clickToObj(DATE_PICK_PAGEW);
        orderP.waitToDisplay(FIRST_MONTH_DATE);
        mainP.clickToObj(FIRST_MONTH_DATE);
        //Заполняем срок аренды
        mainP.clickToObj(RENT_TIME_PAGEW);
        orderP.waitToDisplay(ONE_DAY_RENT_TIME);
        mainP.clickToObj(ONE_DAY_RENT_TIME);
        //Выбираем черный цвет самоката
        mainP.clickToObj(COLOR_BLACK_BYIKE);
        orderP.waitElements();
        //Заполням коммент для курьера
        orderP.setTxtElement(CUSTOMER_COMMENT,COMMENT_FOR_CUR);
        orderP.waitElements();
        //принимаем куки что бы нажать кнопку "Заказать"
        mainP.clickToObj(ORDER_CONFIRM_COCKIES);
        orderP.waitElements();
        //Нажимаем кнопку Заказать
        mainP.clickToObj(ORDER_PAGEW);
        //Нажимаем кнопку "Да"
        mainP.clickToObj(YES_PAGEW);
        //Ждём заголовка "Заказ оформлен"
        Assert.assertFalse("Заказ не оформлен, не появилась модалка 'Заказ оформлен'",Gdriver.findElement(ORDER_CONFIRM).isDisplayed());

    }
}
