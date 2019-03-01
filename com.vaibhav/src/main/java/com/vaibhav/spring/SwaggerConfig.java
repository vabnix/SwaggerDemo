package com.vaibhav.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;
import com.google.common.base.Predicate;
import static com.google.common.base.Predicates.or;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				  .select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(PathSelectors.any())                          
		          .build().apiInfo(apiInfo()); 
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("RestApi Service Listing").description("Implementing Swagger")
				.termsOfServiceUrl("http://vabnix.com").contact("Vaibhav Srivastava").version("1.0").build();
	}
}
