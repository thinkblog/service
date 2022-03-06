package cn.thinkmoon.blog.content.dao;

import cn.thinkmoon.blog.content.pojo.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserDAO extends BaseMapper<UserPO> {
    UserPO queryUserByAccount(String account);
}
