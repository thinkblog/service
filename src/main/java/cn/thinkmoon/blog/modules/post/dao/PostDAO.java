package cn.thinkmoon.blog.modules.post.dao;

import cn.thinkmoon.blog.modules.post.pojo.FieldsPO;
import cn.thinkmoon.blog.modules.post.pojo.PostPO;
import cn.thinkmoon.blog.modules.post.pojo.TagPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author chauncey
 * @since 2020-12-12
 */
public interface PostDAO extends BaseMapper<PostPO> {
    List<TagPo> selectTag(int cid);

    List<FieldsPO> selectFields(int cid);

    IPage<PostPO> selectPage(Page<?> page, int mid, String keyword);

    PostPO getDetail(String cid);

    PostPO getAboutPost();

    boolean insertPost(PostPO post);

    boolean updatePost(PostPO post);
}
