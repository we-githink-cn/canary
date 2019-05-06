package cn.githink.gateway.config;

import cn.githink.gateway.handler.HystrixFallbackHandler;
import cn.githink.gateway.handler.SwaggerResourceHandler;
import cn.githink.gateway.handler.SwaggerSecurityHandler;
import cn.githink.gateway.handler.SwaggerUiHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @author 毛子坤
 * @Title: 路由配置信息
 * @Package
 * @Description:
 * @date 2019/5/611:04
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class RouterFunctionConfiguration {
    private final HystrixFallbackHandler hystrixFallbackHandler;
    private final SwaggerResourceHandler swaggerResourceHandler;
    private final SwaggerSecurityHandler swaggerSecurityHandler;
    private final SwaggerUiHandler swaggerUiHandler;

    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(
                RequestPredicates.path("/fallback")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), hystrixFallbackHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
    }
}
