package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//http://localhost:9001/swagger-ui/
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage("cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02"))
				.paths(PathSelectors.any()).build();
	// rdyp es que sea de cualquier Path
	
	}

}
