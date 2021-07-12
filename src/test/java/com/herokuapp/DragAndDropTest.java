package com.herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.startMaximized = true;
    }

    @Test
    void movingShapes() {
        openPage();
        swapShapes();
        checkMoving();
    }

    void openPage() {
        open("/drag_and_drop");
    }

    void swapShapes() {
        $("#column-a").dragAndDropTo($("#column-b"));
    }

    void checkMoving() {
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
