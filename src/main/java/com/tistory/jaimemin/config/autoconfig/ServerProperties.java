package com.tistory.jaimemin.config.autoconfig;

import com.tistory.jaimemin.config.MyConfigurationProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@MyConfigurationProperties(prefix = "server")
public class ServerProperties {

    private String contextPath;

    private int port;
}
