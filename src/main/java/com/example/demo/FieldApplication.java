package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan//扫描这个包下面的包
public class FieldApplication {
	public static void main(String[] args) {
		//SpringApplication.run(FieldApplication.class, args);
		SpringApplication application=new SpringApplication(FieldApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
