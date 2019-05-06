package cn.githink.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author 毛子坤
 * @Title: 限流配置
 * @Package
 * @Description:
 * @date 2019/5/610:55
 */
@Configuration
public class RateLimiterConfiguration {
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
