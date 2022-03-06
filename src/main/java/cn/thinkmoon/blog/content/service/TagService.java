package cn.thinkmoon.blog.content.service;

import cn.thinkmoon.blog.content.pojo.po.TagPO;
import cn.thinkmoon.blog.content.dao.TagDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService extends ServiceImpl<TagDAO, TagPO>  {
    @Autowired
    private TagDAO tagMapper;

    public List<TagPO> queryList() {
        return tagMapper.queryList();
    }
}
