package cn.thinkmoon.blog.modules.post.dao;

import cn.thinkmoon.blog.modules.post.pojo.FieldsPO;

import java.util.List;

public interface FieldDAO {
    boolean deleteField(int cid);
    boolean addField(List<FieldsPO> fieldsPOList);
}
