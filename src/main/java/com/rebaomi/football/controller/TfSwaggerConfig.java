package com.rebaomi.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
//@EnableWebMvc  
//@ComponentScan(basePackages ={"com.tfdd.controller","com.tfdd.commons"}) 
public class TfSwaggerConfig {
//    public class TfSwaggerConfig extends WebMvcConfigurerAdapter {

        private SpringSwaggerConfig springSwaggerConfig;

        /**
         * Required to autowire SpringSwaggerConfig
         */
        @Autowired
        public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
        {
            this.springSwaggerConfig = springSwaggerConfig;
        }

        /**
         * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
         * framework - allowing for multiple swagger groups i.e. same code base
         * multiple swagger resource listings.
         */
        @Bean
        public SwaggerSpringMvcPlugin customImplementation()
        {
            return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(
                    ".*?");
        }

        private ApiInfo apiInfo()
        {
            ApiInfo apiInfo = new ApiInfo(
                    "xxx系统API接口管理", 
                    "各个controller下对应相应业务接口",
                    "My Apps API terms of service", 
                    "任何问题可联系xxx",
                    null,
                    null);
            return apiInfo;
        }
    }