package cn.thinkmoon.blog.content.dao;

import cn.thinkmoon.blog.content.pojo.po.TagPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface TagDAO extends BaseMapper<TagPO> {
    List<TagPO> queryList();
}
