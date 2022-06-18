package cn.thinkmoon.blog.modules.controller;

import cn.thinkmoon.blog.modules.pojo.TagPO;
import cn.thinkmoon.blog.modules.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/list")
    public List<TagPO> Index(@RequestParam(defaultValue = "") String name) {
        return tagService.queryList(name);
    }
}
