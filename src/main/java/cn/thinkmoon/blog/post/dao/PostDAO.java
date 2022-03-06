package cn.thinkmoon.blog.post.dao;

import cn.thinkmoon.blog.post.pojo.PostPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author chauncey
 * @since 2020-12-12
 */
public interface PostDAO extends BaseMapper<PostPO> {
    IPage<PostPO> selectPage(Page<?> page, int mid, String keyword);

    PostPO getDetail(String cid);

    PostPO getAboutPost();

    boolean insertPost(PostPO post);

    boolean updatePost(PostPO post);
}
