package cn.thinkmoon.blog.modules.dao;

import cn.thinkmoon.blog.modules.pojo.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserDAO extends BaseMapper<UserPO> {
    UserPO queryUserByAccount(String account);
}
