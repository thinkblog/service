package cn.thinkmoon.blog.modules.pojo.vo;

import cn.thinkmoon.blog.modules.pojo.po.FieldsPO;
import lombok.Data;

import java.util.List;

@Data
public class PostVO {
    private int cid;

    private String title;

    private String text;

    private int category_id;

    private List<FieldsPO> customOptions;
}
