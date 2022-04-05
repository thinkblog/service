package cn.thinkmoon.blog.modules.post.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

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
public class PostPO extends Model<PostPO> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Long cid;

    private String title;

    private String slug;

    private Integer created;

    private Integer modified;

    private String text;

    private Integer order;

    private long authorId;

    private String type;

    private String status;

    private Integer commentsNum;

    private Integer views;

    private Integer likes;

    private String tag;

    private String category;

    private String category_id;

    private String thumb;

    private String desc;

    public PostPO() {

    }

    public PostPO(long authorId, String title, String text, String category_id){
        this.authorId = authorId;
        this.title = title;
        this.text = text;
        this.category_id = category_id;
        this.modified = this.created = (int) (System.currentTimeMillis() / 1000);
    }

    public PostPO(Long cid,int authorId, String title, String text, String category_id){
        this.cid = cid;
        this.authorId = authorId;
        this.title = title;
        this.text = text;
        this.category_id = category_id;
        this.modified = (int) (System.currentTimeMillis() / 1000);
    }

    @Override
    protected Serializable pkVal() {
        return this.cid;
    }
}