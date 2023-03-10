package com.tistory.jaimemin.config.autoconfig;

import com.tistory.jaimemin.config.MyConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MyConfigurationProperties(prefix = "data")
public class MyDataSourceProperties {

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
