package com.briup.cms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "用户管理")
public class CustomerController {

    @PostMapping("/authentication/form")
    @ApiOperation("登陆逻辑")
    public void login(String username,String password) {

    }
}