package com.tistory.jaimemin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Configuration
@ComponentScan
@Target(ElementType.TYPE)
@EnableMyAutoConfiguration
@Retention(RetentionPolicy.RUNTIME)
public @interface MySpringBootApplication {
}
