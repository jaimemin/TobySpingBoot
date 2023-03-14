package com.tistory.jaimemin.helloboot;

public interface HelloService {

    String sayHello(String name);


    default Integer countOf(String name) {
        return 0;
    }
}
