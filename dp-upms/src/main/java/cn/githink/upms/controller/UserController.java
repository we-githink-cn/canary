package cn.githink.upms.controller;

import cn.githink.core.utils.Dp;
import cn.githink.model.entities.upms.sysuser.UserDto;
import cn.githink.model.entities.upms.sysuser.bo.SysUserQueryBody;
import cn.githink.upms.service.SysUserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author mzk
 */
@Api(value = "user",tags = "用户管理")
@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    private final SysUserService userService;

    @GetMapping("/{id}")
    @ApiOperation(value = "获取用户", notes = "根据用户Id获取用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path")
    private Dp get(@PathVariable String id){
        return new Dp<>(userService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "新增", notes = "添加用户")
    public Dp save (@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PutMapping
    @ApiOperation(value = "修改",notes = "修改用户")
    public Dp updata (@Valid @RequestBody UserDto userDto){
        return new Dp<>(userService.updateUser(userDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除", notes = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path")
    public Dp delete (@PathVariable String id){
        return new Dp<>(userService.removeById(id));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询", notes = "用户集合")
    public Dp findList(SysUserQueryBody sysUserQueryBody){
        return new Dp<>(userService.findList(sysUserQueryBody));
    }
}
