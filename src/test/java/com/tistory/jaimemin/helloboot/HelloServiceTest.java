package com.tistory.jaimemin.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloServiceTest {

    @Test
    void simpleHelloService() {
        SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

        String result = helloService.sayHello("Test");

        assertThat(result).isEqualTo("Hello Test");
    }

    @Test
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        String result = helloDecorator.sayHello("Test");

        assertThat(result).isEqualTo("*Test*");
    }

    private static HelloRepository helloRepositoryStub = new HelloRepository() {

        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };
}
