package cn.githink.model.entities.upms.sysuser.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author mzk
 * 用户数据库实体类
 */

@Data
@TableName(value = "sys_user")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SysUser",description = "用户数据库视图")
public class SysUser extends Model<SysUser> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.UUID)
    private String userId;
    /**
     * 用户名
     */
    private String username;


    private String password;
    /**
     * 随机盐
     */
    @JsonIgnore
    private String salt;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 0-正常，1-删除
     */
    @TableLogic
    private String delFlag;

    /**
     * 锁定标记
     */
    private String lockFlag;

    /**
     * 简介
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门ID
     */
    private String deptId;

    /**
     * 微信openid
     */
    private String wxOpenid;

    /**
     * QQ openid
     */
    private String qqOpenid;

    /**
     * 上次登录时间
     */
    private LocalDateTime loginTime;

    @Version
    @JsonIgnore
    @ApiModelProperty("乐观锁")
    private Integer version;
}
