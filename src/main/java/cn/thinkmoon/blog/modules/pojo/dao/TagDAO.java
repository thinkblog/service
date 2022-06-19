package cn.thinkmoon.blog.modules.pojo.dao;

import cn.thinkmoon.blog.modules.pojo.po.TagPO;
import cn.thinkmoon.blog.modules.pojo.po.PostPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface TagDAO extends BaseMapper<TagPO> {
    List<TagPO> queryList(String name);

    List<PostPO> getPostList(String tagName);

    void removeTagRelation(int cid);

    void addTagRelation(int cid, List<Integer> tagList);

}
