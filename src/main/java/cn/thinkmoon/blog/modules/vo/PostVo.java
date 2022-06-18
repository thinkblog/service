package cn.thinkmoon.blog.modules.vo;

import cn.thinkmoon.blog.modules.pojo.FieldsPO;
import lombok.Data;

import java.util.List;

@Data
public class PostVo {
    private int cid;

    private String title;

    private String text;

    private int category_id;

    private List<FieldsPO> customOptions;
}
