package cn.thinkmoon.blog.modules.content.dao;

import cn.thinkmoon.blog.modules.content.pojo.po.TagPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface TagDAO extends BaseMapper<TagPO> {
    List<TagPO> queryList();

    TagPO getDetail(String id);
}
