package cn.thinkmoon.blog.modules.post.web;

import cn.thinkmoon.blog.core.enums.PermissionTag;
import cn.thinkmoon.blog.core.annotation.Permission;
import cn.thinkmoon.blog.modules.content.pojo.po.UserPO;
import cn.thinkmoon.blog.modules.post.pojo.PostPO;
import cn.thinkmoon.blog.modules.post.service.PostService;
import cn.thinkmoon.blog.modules.post.vo.PostVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/list")
    @Permission(permissionTag = PermissionTag.ADMIN)
    public IPage<PostPO> Index(@RequestParam(defaultValue = "1") Integer current,
                               @RequestParam(defaultValue = "10") Integer size,
                               @RequestParam(defaultValue = "") String category,
                               @RequestParam(defaultValue = "") String keyword) {
        return postService.selectPage(new Page<PostPO>(current, size), category, keyword);
    }

    @RequestMapping(value = "/list-by-tag")
    public List<PostPO> getListByTag(
            @RequestParam(defaultValue = "") String name) {
        return postService.getListByTag(name);
    }

    @Permission(permissionTag = PermissionTag.ADMIN)
    @RequestMapping(value = "/add")
    public boolean addPost(
            @RequestBody Map body,
            @RequestAttribute("user_info") UserPO user) {
        return postService.addPost(user.getId(), (String) body.get("title"), (String) body.get("text"), (int) body.get("category_id"));
    }

    @Permission(permissionTag = PermissionTag.ADMIN)
    @RequestMapping(value = "/update")
    public boolean updatePost(
            @RequestBody PostVo postVo,
            @RequestAttribute("user_info") UserPO user) {
        return postService.updatePost(postVo.getCid(),user.getId(), postVo.getTitle(), postVo.getText(), postVo.getCategory_id());
    }

    @RequestMapping(value = "/{cid}")
    public PostPO detail(@PathVariable String cid) {
        return postService.getDetail(cid);
    }

    @RequestMapping(value = "/about")
    public PostPO getAboutPost() {
        return postService.getAboutPost();
    }

    @RequestMapping(value = "/search")
    public IPage<PostPO> searchPost(@RequestParam(defaultValue = "1") Integer current,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    @RequestParam(defaultValue = "") String category,
                                    @RequestParam(defaultValue = "") String keyword) {
        return postService.selectPage(new Page<PostPO>(current, size), category, keyword);
    }
}
