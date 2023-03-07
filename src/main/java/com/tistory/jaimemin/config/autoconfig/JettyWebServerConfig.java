package com.tistory.jaimemin.config.autoconfig;

import com.tistory.jaimemin.config.ConditionalOnMyClass;
import com.tistory.jaimemin.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
@ConditionalOnMyClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {

    @ConditionalOnMissingBean
    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new JettyServletWebServerFactory();
    }

}
