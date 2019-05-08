package cn.githink.model.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/8 13:58
 */
@Data
@ApiModel("请求对象基类")
public class BaseRequest implements Serializable {
    @ApiModelProperty(value = "分页插件")
    private Page page;
}
