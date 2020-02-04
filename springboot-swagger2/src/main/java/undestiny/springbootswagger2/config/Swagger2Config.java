package undestiny.springbootswagger2.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnExpression("${swagger.enable:true}")//当enable为true时才选择加载该配置类
@EnableSwagger2
public class Swagger2Config {


    /**
     * 可以写多个docket，相当于在线swagger文档右上角的spec
     */
    @Bean
    public Docket createModuleAApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("a")//如果要写多个docket，就需要为它们指定不同groupName
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("undestiny.springbootswagger2.controller.a"))//设定扫描范围
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createModuleBApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("b")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("undestiny.springbootswagger2.controller.b"))//设定扫描范围
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("my API Documentation")//文档名
                .description("springboot集成swagger2实现接口文档")//文档描述
                //.termsOfServiceUrl("接口文档数据源的url")//数据源（默认http://localhost:8080/v2/api-docs）
                .version("1.0")
                .build();
    }
}
