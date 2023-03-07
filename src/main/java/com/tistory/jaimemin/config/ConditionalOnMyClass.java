package com.tistory.jaimemin.config;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnMyClassCondition.class)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ConditionalOnMyClass {

    String value();
}
