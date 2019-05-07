package cn.githink.upms.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user",tags = "用户管理")
@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {



}
