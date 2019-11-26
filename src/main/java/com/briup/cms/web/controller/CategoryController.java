package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "栏目管理")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    //更新使用post请求方式
    @PostMapping("/saveOrUpdate")
    @ApiOperation("栏目新增或修改")
    public Message saveOrUpdate(Category category) {
        categoryService.saveOrUpdate(category);
        return MessageUtil.success();
    }

    @GetMapping("/findAll")
    @ApiOperation("查询所有栏目")
    public Message<List<Category>> findAll() {
        return MessageUtil.success( categoryService.findAll());
    }

    @GetMapping("/findById")
    @ApiOperation("通过id查询栏目")
    @ApiImplicitParam(name = "id",value = "栏目id",paramType = "query",dataType = "int",required = true )
    public Message<Category> findById(int id) {
        Category category = categoryService.findById(id);
        return MessageUtil.success(category);
    }

    @GetMapping("/delete")
    @ApiOperation("根据id删除栏目")
    @ApiImplicitParam(name = "id",value = "栏目id",paramType = "query",dataType = "int",required = true )
    public Message deleteById(int id) {
        categoryService.deleteById(id);
        return MessageUtil.success();
    }
}
