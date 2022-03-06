package cn.thinkmoon.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBlogApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBlogApplication.class, args);
	}
}
