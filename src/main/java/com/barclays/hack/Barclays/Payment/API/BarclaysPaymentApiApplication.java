package com.barclays.hack.Barclays.Payment.API;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BarclaysPaymentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarclaysPaymentApiApplication.class, args);
	}

	@Bean
	public Docket api() {
		// @formatter:off
		//Register the controllers to swagger
		//Also it is configuring the Swagger Docket
		return new Docket(DocumentationType.SWAGGER_2).select()
				// .apis(RequestHandlerSelectors.any())
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				// .paths(PathSelectors.any())
				// .paths(PathSelectors.ant("/swagger2-demo"))
				.build();
		// @formatter:on
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		//enabling swagger-ui part for visual documentation
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
