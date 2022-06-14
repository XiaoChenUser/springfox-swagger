package com.example.controller;

import com.example.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation("根据 id 查询用户信息")
    @GetMapping("/{id}")
    public UserVo getUser(@PathVariable("id") Integer id) {
        return new UserVo(id, "Xiao Ming");
    }
}
