package com.tistory.jaimemin.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HellobootApplication {

	public static void main(String[] args) {
		/**
		 * 추상화되어 Jetty 쓰고 싶으면 new JettyServletWebServerFactory()
		 */
		ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			HelloController helloController = new HelloController();

			/**
			 * front controller로 전환
			 */
			servletContext.addServlet("frontcontroller", new HttpServlet() {
				@Override
				protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					/**
					 * 인증, 보안, 다국어, 공통 기능 처리한다고 가정
					 */

					/**
					 * 매핑: 웹 요청에 있는 정보를 활용해서 어떤 로직을 수행하는 코드를 호출할 것인가
					 * 바인딩:
					 * 		HelloController는 웹 요청과 응답을 직접 노출하는 기술적인 타입을 사용하지 않았음
					 * 		코드를 작성하면 평범한 자바 코드에 심플하게 넣을 수 있는 로직 사이사이에 웹 기술과 연동되는 메서드가 자주 등장 (상태값, request에 퍼러미터 가져오는 등)
					 * 		이 부분을 분리, 컨트롤러를 만든다고 하더라도 직접적으로 웹 요청과 응답을 다루는 오브젝트를 사용하지 않음 (사용할 수도 있지만 일반적으로 X)
					 * 		평범한 자바 타입으로 웹 요청 정보를 변환해서 받기를 원함
					 * 		ex) 파라미터로 넘어온 name이라는 값을 갖다가 String 타입으로 hello method를 호출했을 때 인자 값으로 넘겨주는 이 작업을 바인딩이라고 함
					 * 		웹 요청을 가지고 이거를 처리하는 로직 코드에서 사용할수 있도록 새로운 형태의 타입으로 변환해주는 작업
					 * 		ex) 만약 form을 통해 많은 정보가 넘어오면 dto라던가 java bean 형태 object로 만들어 데이터를 집어넣어서 이 것을 처리하는 object의 파라미터로 넘겨주는 작업
					 * 		사실 Spring MVC의 binding은 이 것보다 훨씬 복잡하지만 기본적으로는 위와 같음
 					 */
					if ("/hello".equals(req.getRequestURI())
							&& HttpMethod.GET.name().equals(req.getMethod())) {
						String name = req.getParameter("name");
						String result = helloController.hello(name);

						/**
						 * Web 응답의 3가지 요소
						 */
						resp.setStatus(HttpStatus.OK.value());
						resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
						resp.getWriter().println(result);
					} else if ("/user".equals(req.getRequestURI())) {

					} else {
						resp.setStatus(HttpStatus.NOT_FOUND.value());
					}
				}
			}).addMapping("/*");
		});
		webServer.start();
	}
}
