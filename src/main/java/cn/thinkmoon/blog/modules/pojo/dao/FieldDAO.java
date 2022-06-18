package cn.thinkmoon.blog.modules.pojo.dao;

import cn.thinkmoon.blog.modules.pojo.po.FieldsPO;

import java.util.List;

public interface FieldDAO {
    boolean deleteField(int cid);
    boolean addField(List<FieldsPO> fieldsPOList);
}
