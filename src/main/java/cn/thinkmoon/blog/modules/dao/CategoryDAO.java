package cn.thinkmoon.blog.modules.dao;

import cn.thinkmoon.blog.modules.pojo.CategoryPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;


public interface CategoryDAO extends BaseMapper<CategoryPO> {
    List<CategoryPO> queryList(String name);
}
