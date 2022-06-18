package cn.thinkmoon.blog.modules.controller;

import cn.thinkmoon.blog.core.base.ResponseResult;
import cn.thinkmoon.blog.core.enums.PermissionTag;
import cn.thinkmoon.blog.core.annotation.Permission;
import cn.thinkmoon.blog.modules.pojo.po.UserPO;
import cn.thinkmoon.blog.modules.pojo.po.PostPO;
import cn.thinkmoon.blog.modules.service.PostService;
import cn.thinkmoon.blog.modules.pojo.vo.PostVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/list")
    public ResponseResult Index(@RequestParam(defaultValue = "1") Integer current,
                                @RequestParam(defaultValue = "10") Integer size,
                                @RequestParam(defaultValue = "") String category,
                                @RequestParam(defaultValue = "") String keyword) {
        return new ResponseResult(postService.selectPage(new Page<PostPO>(current, size), category, keyword));
    }

    @RequestMapping(value = "/list-by-tag")
    public ResponseResult getListByTag(
            @RequestParam(defaultValue = "") String name) {
        return new ResponseResult(postService.getListByTag(name));
    }

    @Permission(permissionTag = PermissionTag.ADMIN)
    @RequestMapping(value = "/add")
    public ResponseResult addPost(
            @RequestBody PostVO postVo,
            @RequestAttribute("user_info") UserPO user) {
        return new ResponseResult(postService.addPost((Integer) user.getId(), postVo.getTitle(), postVo.getText(), postVo.getCategory_id(), postVo.getCustomOptions()));
    }

    @Permission(permissionTag = PermissionTag.ADMIN)
    @RequestMapping(value = "/update")
    public ResponseResult updatePost(
            @RequestBody PostVO postVo,
            @RequestAttribute("user_info") UserPO user) {
        return new ResponseResult(postService.updatePost(postVo.getCid(),user.getId(), postVo.getTitle(), postVo.getText(), postVo.getCategory_id(),postVo.getCustomOptions()));
    }

    @RequestMapping(value = "/{cid}")
    public ResponseResult detail(@PathVariable String cid) {
        return new ResponseResult(postService.getDetail(cid));
    }

    @RequestMapping(value = "/about")
    public ResponseResult getAboutPost() {
        return new ResponseResult(postService.getAboutPost());
    }

    @RequestMapping(value = "/search")
    public ResponseResult searchPost(@RequestParam(defaultValue = "1") Integer current,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    @RequestParam(defaultValue = "") String category,
                                    @RequestParam(defaultValue = "") String keyword) {
        return new ResponseResult(postService.selectPage(new Page<PostPO>(current, size), category, keyword));
    }
}
