package cn.thinkmoon.blog.modules.pojo.po;

import cn.thinkmoon.blog.modules.pojo.vo.PostVO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author chauncey
 * @since 2020-12-12
 */
@Slf4j
@TableName("weblog_contents")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PostPO extends Model<PostPO> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    private String title;

    private String slug;

    private Integer created;

    private Integer modified;

    private String text;

    private Integer order;

    private long authorId;

    private String type;

    private String status;

    private Integer comments;

    private Integer views;

    private Integer likes;

    private List<TagPO> tag;

    private String category;

    private int category_id;

    private String thumb;

    private String desc;

    private List<FieldsPO> fields;

    @Override
    protected Serializable pkVal() {
        return this.cid;
    }
}
