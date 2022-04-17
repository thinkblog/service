package cn.thinkmoon.blog.modules.content.controller;

import cn.thinkmoon.blog.modules.content.pojo.po.CategoryPO;
import cn.thinkmoon.blog.modules.content.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public List<CategoryPO> Index() {
        return categoryService.queryList();
    }
    @GetMapping(value = "/list/{id}")
    public CategoryPO getDetail(@PathVariable String id) {
        return categoryService.getDetail(id);
    }
}
