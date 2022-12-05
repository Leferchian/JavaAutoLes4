package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryFormTest {

    @BeforeEach

    void setUp(){
        open("http://localhost:9999");
    }
    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    public void formTest() {
        String valueDate = generateDate(3);

        $("[placeholder='Город']").setValue("Иваново");
        $("div [data-test-id='date'] input").doubleClick().sendKeys(" ");
        $("div [data-test-id='date'] input").setValue(valueDate);
        $("div [data-test-id=name] input").setValue("Егор Бойко");
        $("[data-test-id='phone'] input").setValue("+79106811222");
        $("[class=checkbox__box]").click();
        $("[class=button__text]").click();
        $("div.notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(20));
    }
}
