package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;

public class SearchElement {

    @Test
    void test() {
        open("https://github.com/selenide/selenide");
        $("h1 div").should(exist);
    }

    @Test
    void test2() {
        open("https://github.com/selenide/selenide");
        $("h1").$("div").should(exist);
    }

    // в элементе h1 нет элементов div, в первом и втором случае тест упадет
    @Test
    void test3() {
        open("https://github.com/selenide/selenide");
        $("h1 a").click();
    }

    @Test
    void test4() {
        open("https://github.com/selenide/selenide");
        $("h1").$("a").click();
    }
    //если же взять в элементе h1 элемент a, то найдутся все элементы a + вложенные элементы a, селенид возьмет первый найденный
    //в данном случае будут найдены только вложенные элементы т.к на уровень выше нет элементов а (как например svg элемент)
}
