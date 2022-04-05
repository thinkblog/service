package cn.thinkmoon.blog.modules.content.controller;

import cn.thinkmoon.blog.modules.content.pojo.po.TagPO;
import cn.thinkmoon.blog.modules.content.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/list")
    public List<TagPO> Index() {
        return tagService.queryList();
    }
}
