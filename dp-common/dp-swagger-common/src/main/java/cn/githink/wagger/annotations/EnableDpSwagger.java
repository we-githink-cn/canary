package cn.githink.wagger.annotations;

import cn.githink.wagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/6 17:04
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableDpSwagger {
}
