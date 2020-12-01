package tests.registration;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class RegistrationSuccess {

    String email = getRandomEmail();
    String pass = getRandomString(10);
    String phone = getRandomPhone();

    @Test
    public void registrationWithEmail(){

        open("https://megaplan.ru/");

        $(".login-link").click();
        $(byText("Регистрация")).click();
        $("#reg-email").setValue(email);
        $(byText("Попробовать бесплатно")).click();
        sleep(15000);
        $(byName("firstName")).setValue("MyName");
        $(byName("lastName")).setValue("MyLastname");
        $(byName("phone")).setValue(phone);
        $(byText("Продолжить")).click();
        $(byText("Для себя")).click();
        $(byText("Завершить")).click();

        $("#megaReact").shouldHave(text("Добро пожаловать в Мегаплан!"));

    }
}
