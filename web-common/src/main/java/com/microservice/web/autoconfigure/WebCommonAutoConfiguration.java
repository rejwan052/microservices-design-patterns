package com.microservice.web.autoconfigure;

import com.microservice.web.common.util.CustomReactiveDefaultErrorAttributes;
import com.microservice.web.common.util.GlobalExceptionHandler;
import com.microservice.web.common.util.HandleResponseError;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

@Configuration
public class WebCommonAutoConfiguration {
    @Primary
    @Bean
    CustomReactiveDefaultErrorAttributes customReactiveDefaultErrorAttributes() {
        return new CustomReactiveDefaultErrorAttributes();
    }

    @Bean
    HandleResponseError handleResponseError(CustomReactiveDefaultErrorAttributes customReactiveDefaultErrorAttributes) {
        return new HandleResponseError(customReactiveDefaultErrorAttributes);
    }

    @Bean
    GlobalExceptionHandler globalExceptionHandler(ErrorAttributes errorAttributes, ResourceProperties resourceProperties,
                                                  ServerProperties serverProperties, ApplicationContext applicationContext,
                                                  HandleResponseError handleResponseError, ObjectProvider<ViewResolver> viewResolversProvider,
                                                  ServerCodecConfigurer serverCodecConfigurer) {
        return new GlobalExceptionHandler(errorAttributes, resourceProperties, serverProperties, applicationContext, handleResponseError, viewResolversProvider, serverCodecConfigurer);
    }
}
