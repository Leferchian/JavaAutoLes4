package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryFormTest {
    @Test
    public void FormTest() {

//        Calendar date = Calendar.getInstance(); // передаем текущую дату
//        date.add(Calendar.DATE, 3);
//        String valueDate= new SimpleDateFormat("dd,mm,yyyy").format(date.getTime());
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Иваново");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(" ");
        $("div [data-test-id='date'] input").setValue("12.12.2022");
        $("div [data-test-id=name] input").setValue("Егор Бойко");
        $("[data-test-id='phone'] input").setValue("+79106811222");
        $("[class=checkbox__box]").click();
        $("[class=button__text]").click();
        $("div.notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(20));
    }
}
