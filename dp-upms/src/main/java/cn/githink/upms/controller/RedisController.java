package cn.githink.upms.controller;

import cn.hutool.json.JSONObject;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/7 17:54
 */
@RestController
@RequestMapping(value = "/redis")
@AllArgsConstructor
public class RedisController {
    private final RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/get/{username}")
    public Object get(@PathVariable String username) {
        return redisTemplate.opsForValue().get(username);
    }

    @PutMapping("/put")
    public void put(String username, String nickname) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",username);
        jsonObject.put("nikename",nickname);
        redisTemplate.opsForValue().set(username, jsonObject);
    }
}
