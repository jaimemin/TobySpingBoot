package com.tistory.jaimemin.helloboot;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Transactional
@Target(ElementType.TYPE)
@ExtendWith(SpringExtension.class)
@Retention(RetentionPolicy.RUNTIME)
@TestPropertySource("classpath:/application.properties")
@ContextConfiguration(classes = HellobootApplication.class)
public @interface HellobootTest {
}
