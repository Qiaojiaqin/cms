package com.briup.cms.service.impl;

import com.briup.cms.bean.Category;
import com.briup.cms.bean.ex.CategoryEX;
import com.briup.cms.dao.ICategoryDao;
import com.briup.cms.dao.ex.ICategoryEXDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.CodeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Autowired
    private ICategoryEXDao categoryEXDao;

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if(category == null) {
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        }
        categoryDao.save(category);
    }

    @Override
    public List<Category> findAll() throws CustomerException {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(int id) throws CustomerException {
        return categoryDao.queryById(id);
    }

    @Override
    public void deleteById(int id) throws CustomerException {
        categoryDao.deleteById(id);
    }

    @Override
    public List<CategoryEX> findAllCategory() throws CustomerException {
        return categoryEXDao.findAll();
    }


}
