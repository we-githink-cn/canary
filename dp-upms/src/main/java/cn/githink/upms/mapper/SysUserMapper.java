package cn.githink.upms.mapper;

import cn.githink.data.datascope.DataScope;
import cn.githink.model.entities.upms.sysuser.po.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/8 14:30
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 列表查询
     * @param page
     * @param sysUser
     * @param dataScope
     * @return
     */
    IPage findList(Page page, @Param("query") SysUser sysUser, DataScope dataScope);
}
