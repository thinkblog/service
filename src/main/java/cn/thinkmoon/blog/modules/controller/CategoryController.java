package cn.thinkmoon.blog.modules.controller;

import cn.thinkmoon.blog.modules.pojo.CategoryPO;
import cn.thinkmoon.blog.modules.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public List<CategoryPO> Index(@RequestParam(defaultValue = "") String name) {
        return categoryService.queryList(name);
    }
}
