package com.seven4n.prueba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seven4n.prueba.EntryPoint;
import com.seven4n.prueba.MarteEntryPoint;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AppConfig {
	
	@Value("${amenazas}")
	private String pathToAmenazas;
	
	@Value("${movimientos}")
	private String pathToMovimientos;
	
	@Bean
	public EntryPoint createEntryPoint() throws Exception{
		return new MarteEntryPoint(this.pathToAmenazas, this.pathToMovimientos);
	}

}
