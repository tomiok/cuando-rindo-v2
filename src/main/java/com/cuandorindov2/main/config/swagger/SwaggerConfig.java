package com.cuandorindov2.main.config.swagger;

import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.cuandorindov2.main.resources.crud.domain"))
                .build()
                .apiInfo(metaData());
    }

    private static ApiInfo metaData() {
        return new ApiInfo("Exam dispatcher API",
                "Select signatures, exams and all the schedules",
                "2.0.SNAPSHOT",
                "GNU",
                getMyself(),
                "Apache License V 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

    private static Contact getMyself() {
        return new Contact("Tomas F. Lingotti", "https:github.com/tomiok", "tomaslingotti@gmail.com");
    }

}
