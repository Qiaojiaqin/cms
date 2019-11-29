package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArticleDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Override
    public void addArticle(Article article) throws CustomerException {
        if( article == null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        }
        article.setClickTimes(0);
        article.setPublishDate(new Date());
        articleDao.save(article);
    }

    @Override
    public void deleteArticle(int id) throws CustomerException {
        articleDao.deleteById(id);
    }

    @Override
    public Article findById(int id) throws CustomerException {
        Article article = articleDao.queryById(id);
        return article;
    }

    @Override
    public List<Article> findAll() throws CustomerException {
        List<Article> list = articleDao.findAll();
        return list;
    }
}
