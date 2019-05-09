package cn.githink.upms.service;

import cn.githink.core.utils.Dp;
import cn.githink.model.entities.upms.sysuser.UserDto;
import cn.githink.model.entities.upms.sysuser.bo.SysUserQueryBody;
import cn.githink.model.entities.upms.sysuser.po.SysUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/8 14:24
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 新增用户
     * @param userDto
     * @return
     */
    Dp saveUser(UserDto userDto);

    Boolean updateUser(UserDto userDto);

    IPage findList(SysUserQueryBody sysUserQueryBody);
}
