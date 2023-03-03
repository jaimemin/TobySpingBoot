package com.tistory.jaimemin.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class HellobootApplication {

	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		return new TomcatServletWebServerFactory();
	}

	/**
	 * DispatcherServlet을 Factory Method에서 생성자 없이 Object를 생성해서
	 * return 하더라도 문제 없이 동작
	 *
	 * @return
	 */
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
			/**
			 * Hook Method
			 */
			@Override
			protected void onRefresh() {
				super.onRefresh();

				ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
				DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);

				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet", dispatcherServlet)
							.addMapping("/*");
				});
				webServer.start();
			}
		};
		applicationContext.register(HellobootApplication.class);
		applicationContext.refresh();
	}
}
