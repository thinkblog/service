package cn.thinkmoon.blog.modules.content.controller;

import cn.thinkmoon.blog.modules.content.pojo.po.CategoryPO;
import cn.thinkmoon.blog.modules.content.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/list")
    public List<CategoryPO> Index() {
        return categoryService.queryList();
    }
}
