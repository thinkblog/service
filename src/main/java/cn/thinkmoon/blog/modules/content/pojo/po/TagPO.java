package cn.thinkmoon.blog.modules.content.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public class TagPO extends Model<TagPO> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "tid", type = IdType.AUTO)
    private Integer tid;

    private String name;

    private int order;

    private int count;
}
