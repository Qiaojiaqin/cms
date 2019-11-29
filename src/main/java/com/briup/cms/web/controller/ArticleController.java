package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
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
@RequestMapping("/article")
@Api(description = "信息管理")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/add")
    @ApiOperation(value = "新增信息",notes = "category_name,category_code不需要输入")
    public Message addArticle(Article article) {
        articleService.addArticle(article);
        return MessageUtil.success();
    }

    @GetMapping("/delete")
    @ApiOperation("根据id删除信息")
    @ApiImplicitParam(name = "id",value = "信息id",paramType = "query",dataType = "int",required = true)
    public Message deleteArticle(int id) {
        articleService.deleteArticle(id);
        return MessageUtil.success();
    }


    @GetMapping("/findById")
    @ApiOperation("通过id查询信息")
    @ApiImplicitParam(name = "id",value = "信息id",paramType = "query",dataType = "int",required = true)
    public Message<Article> findById(int id) {
        Article article = articleService.findById(id);
        return MessageUtil.success(article);
    }

    @GetMapping("/findAllArticle")
    @ApiOperation("查找所有信息")
    public Message<List<Article>> findAllArticle() {
        List<Article> articleList = articleService.findAll();
        return MessageUtil.success(articleList);
    }
}
