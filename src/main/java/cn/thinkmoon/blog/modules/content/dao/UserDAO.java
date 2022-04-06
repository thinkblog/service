package cn.thinkmoon.blog.modules.content.dao;

import cn.thinkmoon.blog.modules.content.pojo.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserDAO extends BaseMapper<UserPO> {
    UserPO queryUserByAccount(String account);
}
