package cn.thinkmoon.blog.modules.content.dao;

import cn.thinkmoon.blog.modules.content.pojo.po.CategoryPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface CategoryDAO extends BaseMapper<CategoryPO> {
    List<CategoryPO> queryList(String name);
}
