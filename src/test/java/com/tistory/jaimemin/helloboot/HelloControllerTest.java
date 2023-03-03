package com.tistory.jaimemin.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloControllerTest {

    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);
        String result = helloController.hello("Test");

        assertThat(result).isEqualTo("Test");
    }

    @Test
    void helloControllerFail() {
        HelloController helloController = new HelloController(name -> name);

        assertThatThrownBy(() -> {
           String result = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            String result = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
