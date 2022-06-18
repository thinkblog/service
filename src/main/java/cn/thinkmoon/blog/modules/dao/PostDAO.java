package cn.thinkmoon.blog.modules.dao;

import cn.thinkmoon.blog.modules.pojo.FieldsPO;
import cn.thinkmoon.blog.modules.pojo.PostPO;
import cn.thinkmoon.blog.modules.pojo.TagPO;
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
    List<TagPO> selectTag(int cid);

    List<FieldsPO> selectFields(int cid);

    List<PostPO> selectPage(List<PostPO> cidList, String category, String keyword);

    IPage<PostPO> selectPage(Page<?> page, String category, String keyword, List<PostPO> cidList);

    PostPO getDetail(String cid);

    PostPO getAboutPost();

    boolean insertPost(PostPO post);

    boolean updatePost(PostPO post);

}
