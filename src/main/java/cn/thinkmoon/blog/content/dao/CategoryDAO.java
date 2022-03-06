package cn.thinkmoon.blog.content.dao;

import cn.thinkmoon.blog.content.pojo.po.CategoryPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface CategoryDAO extends BaseMapper<CategoryPO> {
    List<CategoryPO> queryList();
}
