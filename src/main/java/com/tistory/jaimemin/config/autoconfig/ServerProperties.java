package com.tistory.jaimemin.config.autoconfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerProperties {

    private String contextPath;

    private int port;
}
