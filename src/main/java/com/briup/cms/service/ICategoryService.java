package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.ex.CategoryEX;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface ICategoryService {
    void saveOrUpdate(Category category) throws CustomerException;
    List<Category> findAll() throws CustomerException;
    Category findById(int id) throws CustomerException;
    void deleteById(int id) throws CustomerException;
    //查询所有栏目，包括栏目里面信息栏目
    List<CategoryEX> findAllCategory() throws CustomerException;
}
