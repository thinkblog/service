package cn.thinkmoon.blog.modules.service;

import cn.thinkmoon.blog.modules.pojo.po.CategoryPO;
import cn.thinkmoon.blog.modules.pojo.dao.CategoryDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService{

    @Resource
    private CategoryDAO categoryMapper;

    public List<CategoryPO> queryList(String name) {
        return categoryMapper.queryList(name);
    }
}
