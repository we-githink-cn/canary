package cn.githink.model.upms.sysuser;

import cn.githink.model.member.po.Member;
import cn.githink.model.upms.sysuser.po.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/8 15:57
 */

@Data
@ApiModel("用户聚合实体类")
@EqualsAndHashCode(callSuper = true)
public class UserDto extends SysUser {
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色集合")
    private List<Integer> role;

    /**
     * 部门Id
     */
    @ApiModelProperty(value = "部门Id")
    private Integer deptId;

    /**
     * 新密码
     */
    @ApiModelProperty(value = "新密码")
    private String newpassword1;

    /**
     * 用户扩展类
     */
    @ApiModelProperty(value = "用户扩展信息")
    private Member member;
}
