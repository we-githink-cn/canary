package cn.githink.model.upms.sysuser.bo;

import cn.githink.model.common.BaseRequest;
import cn.githink.model.member.bo.MemberQueryBody;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mzk
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUserQueryBody", description = "User查询对象")
public class SysUserQueryBody extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    @ApiModelProperty(value = "用户主键",hidden = true)
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;
    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 部门Id
     */
    @ApiModelProperty(value = "部门Id")
    private Integer deptId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 角色Id
     */
    @ApiModelProperty(value = "角色Id")
    private List<Integer> role;

    /**
     * 扩展信息
     */
    @ApiModelProperty(value = "扩展信息")
    private MemberQueryBody memberQueryBody;

}
