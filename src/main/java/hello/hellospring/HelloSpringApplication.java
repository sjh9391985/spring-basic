package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		// class 명을 명시해주면 tomcat web server를 띄워서 자체적으로 실행을 해줍니다.
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}