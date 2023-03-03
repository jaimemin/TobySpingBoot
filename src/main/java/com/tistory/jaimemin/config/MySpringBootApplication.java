package com.tistory.jaimemin.config;

import com.tistory.jaimemin.config.EnableMyAutoConfiguration;
import com.tistory.jaimemin.config.autoconfig.DispatcherServletConfig;
import com.tistory.jaimemin.config.autoconfig.TomcatWebServerConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
