package cn.thinkmoon.blog.modules.dao;

import cn.thinkmoon.blog.modules.pojo.FieldsPO;

import java.util.List;

public interface FieldDAO {
    boolean deleteField(int cid);
    boolean addField(List<FieldsPO> fieldsPOList);
}
