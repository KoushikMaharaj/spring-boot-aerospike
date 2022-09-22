//package example.springbootaerospikedemo.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@Component
//@EnableSwagger2
//public class EmployeeSwaggerConfig {
//    @Bean
//    public Docket getBean() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.any()).paths(regex("/emp.*")).build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title("Employee service")
//                .description("Sample doc generated using swagger2 for Rest API").build();
//    }
//}
