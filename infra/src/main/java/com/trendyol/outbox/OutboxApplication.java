package com.trendyol.outbox;

import com.trendyol.outbox.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = "com.trendyol", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class}))
public class OutboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutboxApplication.class, args);
	}

}
