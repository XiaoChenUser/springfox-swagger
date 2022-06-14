package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("demo api")
@RestController
@RequestMapping("/demo")
public class DemoController {
    @ApiOperation(value = "say hi")
    @ApiImplicitParam(name = "name", value = "用户名",required = true,dataTypeClass = String.class)
    @GetMapping("/echo")
    public String echo(@RequestParam String name) {
        return "Hello," + name;
    }
}
