package costant;

import org.openqa.selenium.By;

public class OrderBY_Constants {
    public static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
    public static final By BODY_ORDER_BUTTON = By.cssSelector(".Button_Middle__1CSJM");
    public static final By INPUT_STRING_PAGEF = By.cssSelector("div.Order_Form__17u6u > div.Input_InputContainer__3NykH > input");//поле Имя,Фамилия,Адрес,Телефон в форме "Для кого"
    public static final By INPUT_METRO_PAGEF = By.className("select-search__input");//поле Станция метро в форме "Для кого"
    public static final By METROSTATION_PAGEF = By.xpath(".//*[text()='Черкизовская']");//локатор по названию станции метро для выбора в выпадайке на форме "Для кого"
    public static final By BUTTON_NEXTPAGE_PAGEF = By.xpath(".//button[text()='Далее']");//кнопка Далее в форме заказа
    public static final By DATE_PICK_PAGEW = By.cssSelector("div.react-datepicker__input-container > input");//поле "Когда привезти"
    public static final By FIRST_MONTH_DATE = By.xpath(".//div[text()='1' and @class='react-datepicker__day react-datepicker__day--001']");// 1е число открытого в календаре месяца и года
    public static final By RENT_TIME_PAGEW = By.cssSelector("div.Dropdown-control > div");//поле "Срок аренды"
    public static final By ONE_DAY_RENT_TIME = By.xpath(".//div[text()='сутки' and @class='Dropdown-option']");// сутки в сроке аренды
    public static final By COLOR_BLACK_BYIKE = By.id("black");// черный цвет в аренде
    public static final By COMMENT_FOR_CUR = By.cssSelector("div.Order_Form__17u6u > div.Input_InputContainer__3NykH > input");// Поле комментарий
    public static final By ORDER_PAGEW = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']");//кнопка Заказать на форме "Про аренду"
    public static final By YES_PAGEW = By.cssSelector("div.Order_Modal__YZ-d3 > div.Order_Buttons__1xGrp > button:nth-child(2)");//кнопка Заказать на форме "Про аренду"
    public static final By ORDER_CONFIRM = By.xpath(".//button[text()='Заказ оформлен' and @class='Order_ModalHeader__3FDaJ']");
    public static final By ORDER_CONFIRM_COCKIES = By.xpath(".//button[text()='да все привыкли' and @class='App_CookieButton__3cvqF']");


}
