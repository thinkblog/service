package cn.thinkmoon.blog.content.service;

import cn.thinkmoon.blog.content.pojo.po.UserPO;
import cn.thinkmoon.blog.content.dao.UserDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserDAO, UserPO> {
    @Autowired
    private UserDAO userMapper;

    public UserPO queryUserByAccount(String account) {
        return userMapper.queryUserByAccount(account);
    }
}
