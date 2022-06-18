package cn.thinkmoon.blog.modules.controller;

import cn.thinkmoon.blog.core.base.ResponseResult;
import cn.thinkmoon.blog.modules.pojo.po.TagPO;
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
    public ResponseResult Index(@RequestParam(defaultValue = "") String name) {
        return new ResponseResult(tagService.queryList(name));
    }
}
