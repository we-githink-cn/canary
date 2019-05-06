package cn.githink.gateway.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.*;
import java.util.stream.Collectors;

/**
  * @author Sywd
  * 聚合接口文档注册，和zuul实现类似
 */
@Component
@Primary
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {

    private static final String API_URI = "/v2/api-docs";
    private final RouteDefinitionRepository routeDefinitionRepository;
    private final GatewayProperties gatewayProperties;
    private final FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;
    private final RouteLocator routeLocator;


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routes = new ArrayList<>();
        routeLocator.getRoutes().filter(route -> route.getUri().getHost() != null)
                .filter(route -> !"dp-gateway".equals(route.getUri().getHost()))
                .subscribe(route -> routes.add(route.getUri().getHost()));
        //routeDefinitionRepository.getRouteDefinitions().subscribe(route -> routes.add(route));
//        routes.forEach(routeDefinition -> routeDefinition.getPredicates().stream()
//                .filter(predicateDefinition -> "Path".equalsIgnoreCase(predicateDefinition.getName()))
//                .filter(predicateDefinition -> !filterIgnorePropertiesConfig.getSwaggerProviders().contains(routeDefinition.getId()))
//                .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(),
//                        predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0")
//                                .replace("/**", API_URI)))));
//
//        return resources.stream().sorted(Comparator.comparing(SwaggerResource::getName))
//                .collect(Collectors.toList());
        Set<String> dealed = new HashSet<>();
        routes.forEach(instance -> {
            // 拼接url，样式为/serviceId/v2/api-info，当网关调用这个接口时，会自动通过负载均衡寻找对应的主机
            String url = "/" + instance + API_URI;
            if (!dealed.contains(url)) {
                dealed.add(url);
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setUrl(url);
                swaggerResource.setName(instance);
                resources.add(swaggerResource);
            }
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
