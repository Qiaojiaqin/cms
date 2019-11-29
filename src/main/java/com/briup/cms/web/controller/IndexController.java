package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.ex.CategoryEX;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
@Api(description = "首页管理")
public class IndexController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    @ApiOperation("首页数据")
    public Message<List<CategoryEX>> showIndex() {
        return MessageUtil.success(categoryService.findAllCategory());
    }


}
