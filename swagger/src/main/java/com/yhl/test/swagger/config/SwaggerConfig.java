package com.yhl.test.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 杨贺龙
 * @name SwaggerConfig
 * @create 2019-11-04 10:09
 * @description:
 */
@Configuration  //必须存在
@EnableSwagger2  // 必须存在
// 必须存在 扫描的API Controller包
@ComponentScan(basePackages = {"com.yhl.test.swagger.controller"})
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        Contact contact = new Contact("YHL", "http://www.baidu.com/", "1359541394@qq.com");
        return new ApiInfoBuilder()
                .title("测试Swagger API")
                .description("API接口")
                .contact(contact)
                .version("1.1.0")
                .build();
    }
}
