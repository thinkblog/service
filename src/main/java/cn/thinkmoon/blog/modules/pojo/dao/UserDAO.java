package cn.thinkmoon.blog.modules.pojo.dao;

import cn.thinkmoon.blog.modules.pojo.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserDAO extends BaseMapper<UserPO> {
    UserPO queryUserByAccount(String account);
}
