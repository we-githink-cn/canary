package cn.githink.upms.service.impl;

import cn.githink.model.upms.sysuser.UserDto;
import cn.githink.model.upms.sysuser.bo.SysUserQueryBody;
import cn.githink.model.upms.sysuser.po.SysUser;
import cn.githink.upms.mapper.SysUserMapper;
import cn.githink.upms.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/8 14:25
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public Boolean saveUser(UserDto userDto) {
        System.out.println("+++++"+userDto.toString());
        return null;
    }
}
