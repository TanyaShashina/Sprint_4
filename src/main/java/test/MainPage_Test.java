package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObj.MainPage;

import static costant.QuestionBY_Constant.*;
import static costant.QuestionText_Constant.*;
import static costant.URL_Constant.HOME_P_URL;


@RunWith(Parameterized.class)
public class MainPage_Test {

    public WebDriver Gdriver;

    private final By selectedQuestionLocator;
    private final By selectedAnswerLocator;
    private final String questionExpectedText;
    private final String questionExpectedAnswer;

    public MainPage_Test(By selectedQuestionLocator, By selectedAnswerLocator, String questionExpectedText, String questionExpectedAnswer){
        this.selectedQuestionLocator = selectedQuestionLocator;
        this.selectedAnswerLocator = selectedAnswerLocator;
        this.questionExpectedText = questionExpectedText;
        this.questionExpectedAnswer = questionExpectedAnswer;
    }


    //создаём драйвера
    @Before
    public void createDriver(){
        Gdriver = new ChromeDriver();

    }

    //закрываем браузер после теста
    @After
    public void quitDriver(){
        Gdriver.quit();
            }

    //Догадалась текст задать только константами, возможно есть более гибкий способ?
    @Parameterized.Parameters
    public static Object[][] getQuestions() {
        return new Object[][] {
                {Q1, A1, T_Q1, T_A1},
                {Q2, A2, T_Q2, T_A2},
                {Q3, A3, T_Q3, T_A3},
                {Q4, A4, T_Q4, T_A4},
                {Q5, A5, T_Q5, T_A5},
                {Q6, A6, T_Q6, T_A6},
                {Q7, A7, T_Q7, T_A7},
                {Q8, A8, T_Q8, T_A8},
        };
    }

    @Test
    public void checkListGC(){
        Gdriver.get(HOME_P_URL);

        MainPage mainP = new MainPage(Gdriver);
        mainP.scrollToObj(By.className("Home_SubHeader__zwi_E"));
        //получаем текст из выпадайки
        String textFromListQuest = mainP.getTextObj(selectedQuestionLocator);
        //нажимаем на пункт выпадайки
        mainP.clickToObj(selectedQuestionLocator);
        //получем текст из ответа выпадайки
        String textFromListAnswer = mainP.getTextObj(selectedAnswerLocator);

        //проверяем соответствие текста полученого и "справочных значений"
        Assert.assertEquals("Текст вопроса не соответствует ожидаемому",questionExpectedText,textFromListQuest);
        Assert.assertEquals("Текст ответа не соответствует ожидаемому",questionExpectedAnswer,textFromListAnswer);

    }

}
