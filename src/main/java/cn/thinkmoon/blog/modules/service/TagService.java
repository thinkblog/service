package cn.thinkmoon.blog.modules.service;

import cn.thinkmoon.blog.modules.pojo.po.TagPO;
import cn.thinkmoon.blog.modules.pojo.dao.TagDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService extends ServiceImpl<TagDAO, TagPO>  {
    @Autowired
    private TagDAO tagMapper;

    public List<TagPO> queryList(String name) {
        return tagMapper.queryList(name);
    }
}
