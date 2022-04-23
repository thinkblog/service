package cn.thinkmoon.blog.modules.content.dao;

import cn.thinkmoon.blog.modules.content.pojo.po.TagPO;
import cn.thinkmoon.blog.modules.post.pojo.PostPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface TagDAO extends BaseMapper<TagPO> {
    List<TagPO> queryList(String name);

    List<PostPO> getPostList(String tagName);
}
