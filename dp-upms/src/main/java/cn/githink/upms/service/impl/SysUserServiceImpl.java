package cn.githink.upms.service.impl;

import cn.githink.core.utils.Dp;
import cn.githink.data.datascope.DataScope;
import cn.githink.model.entities.upms.sysuser.UserDto;
import cn.githink.model.entities.upms.sysuser.bo.SysUserQueryBody;
import cn.githink.model.entities.upms.sysuser.po.SysUser;
import cn.githink.upms.mapper.SysUserMapper;
import cn.githink.upms.service.SysUserService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Dp saveUser(UserDto userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        Integer count = baseMapper.selectCount(new QueryWrapper<SysUser>().eq("username",sysUser.getUsername()).or().eq("phone",sysUser.getPhone()));
        if(count == 0){
            sysUser.setPassword(ENCODER.encode(userDto.getPassword()));
            int i = baseMapper.insert(sysUser);
            if(i!=0){
                return new Dp<>().setMsg("新增用户【"+sysUser.getUsername()+"】成功！");
            }
        }
        return new Dp<>().setMsg("用户名已存在！");
    }

    @Override
    public Boolean updateUser(UserDto userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setUpdateTime(LocalDateTime.now());
        if (StrUtil.isNotBlank(userDto.getPassword())) {
            sysUser.setPassword(ENCODER.encode(userDto.getPassword()));
        }
        this.updateById(sysUser);
        return null;
    }

    @Override
    public IPage findList(SysUserQueryBody body) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(body,sysUser);
        if(StrUtil.isBlank(sysUser.getDelFlag())){
            sysUser.setDelFlag("0");
        }
        return baseMapper.findList(body.getPage(),sysUser,new DataScope());
    }
}
