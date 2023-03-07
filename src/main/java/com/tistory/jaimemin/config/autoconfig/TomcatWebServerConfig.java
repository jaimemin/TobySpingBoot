package com.tistory.jaimemin.config.autoconfig;

import com.tistory.jaimemin.config.ConditionalOnMyClass;
import com.tistory.jaimemin.config.EnableMyConfigurationProperties;
import com.tistory.jaimemin.config.MyAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@EnableMyConfigurationProperties(ServerProperties.class)
@ConditionalOnMyClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @ConditionalOnMissingBean
    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory(ServerProperties properties) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setContextPath(properties.getContextPath());
        serverFactory.setPort(properties.getPort());

        return serverFactory;
    }

}
