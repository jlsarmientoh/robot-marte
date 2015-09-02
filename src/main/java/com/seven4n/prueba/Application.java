package com.seven4n.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args){
		ApplicationContext context = SpringApplication.run(Application.class, args);
		EntryPoint entryPoint = context.getBean(EntryPoint.class);
		entryPoint.execute();
	}

}
