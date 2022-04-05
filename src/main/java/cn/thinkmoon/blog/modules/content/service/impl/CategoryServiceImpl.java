package cn.thinkmoon.blog.modules.content.service.impl;

import cn.thinkmoon.blog.modules.content.pojo.po.CategoryPO;
import cn.thinkmoon.blog.modules.content.dao.CategoryDAO;
import cn.thinkmoon.blog.modules.content.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDAO categoryMapper;

    public List<CategoryPO> queryList() {
        return categoryMapper.queryList();
    }
}
