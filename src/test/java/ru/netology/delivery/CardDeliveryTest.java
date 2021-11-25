package ru.netology.delivery;

import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;

public class CardDeliveryTest {


    @Test
    void shouldRegisterCardDelivery() {

        Configuration.headless = true;

        LocalDate date = LocalDate.now();
        date = date.plusDays(3);


        open("http://localhost:9999");
        $("[data-test-id='city'] [class='input__control']").sendKeys("Вологда"); // город
        $("[data-test-id='date'] [class='input__control']").doubleClick().setValue(String.valueOf(date));// дата
        $("[data-test-id='name'] [class='input__control']").sendKeys("Пупкин Василий"); // ФИ
        $("[data-test-id='phone'] [class='input__control']").sendKeys("+79632587411"); // тел
        $("[data-test-id='agreement'] [class='checkbox__box']").click(); // согласие
        $("[class='button__content']").click(); // отправка формы
        $("[data-test-id='notification'] [class='notification__title']")
                .shouldBe(Condition.visible, Duration.ofSeconds(15));
//        $("[class='notification__content']").shouldHave(Condition.text(String.valueOf(date)));

    }

}
