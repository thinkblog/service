package cn.thinkmoon.blog.modules.dao;

import cn.thinkmoon.blog.modules.pojo.TagPO;
import cn.thinkmoon.blog.modules.pojo.PostPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface TagDAO extends BaseMapper<TagPO> {
    List<TagPO> queryList(String name);

    List<PostPO> getPostList(String tagName);
}
