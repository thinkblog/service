package cn.thinkmoon.blog.modules.service;

import cn.thinkmoon.blog.modules.pojo.dao.TagDAO;
import cn.thinkmoon.blog.modules.pojo.dao.FieldDAO;
import cn.thinkmoon.blog.modules.pojo.dao.PostDAO;
import cn.thinkmoon.blog.modules.pojo.po.FieldsPO;
import cn.thinkmoon.blog.modules.pojo.po.PostPO;
import cn.thinkmoon.blog.modules.pojo.po.UserPO;
import cn.thinkmoon.blog.modules.pojo.vo.PostVO;
import cn.thinkmoon.blog.utils.TimeUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chauncey
 * @since 2020-12-12
 */
@Service
public class PostService extends ServiceImpl<PostDAO, PostPO> {
    @Autowired
    private PostDAO postMapper;

    @Autowired
    private FieldDAO fieldMapper;

    @Autowired
    private TagDAO tagDAO;

    public IPage<PostPO> selectPage(Page<PostPO> page, String category, String keyword) {
        return postMapper.selectPage(page, category, "%" + keyword + "%", null);
    }

    public List<PostPO> getListByTag(String tagName) {
        List<PostPO> po = tagDAO.getPostList(tagName);
        return postMapper.selectPage(po, "", "");
    }

    public PostPO getDetail(String cid) {
        return postMapper.getDetail(cid);
    }

    public PostPO getAboutPost() {
        return postMapper.getAboutPost();
    }

    public int addPost(UserPO user, PostVO postVO) {
        final int nowTime = TimeUtils.getNow();
        PostPO post = new PostPO()
                .setAuthorId(user.getId())
                .setTitle(postVO.getTitle())
                .setText(postVO.getText())
                .setCategory_id(postVO.getCategory_id())
                .setCreated(nowTime)
                .setModified(nowTime);
        postMapper.insertPost(post);
        int cid = post.getCid();
        updateMeta(cid, postVO);
        return cid;
    }

    public int updatePost(UserPO user, PostVO postVO) {
        PostPO post = new PostPO();
        BeanUtils.copyProperties(postVO, post);
        post.setAuthorId(user.getId());
        post.setModified((int) (System.currentTimeMillis() / 1000));
        postMapper.updatePost(post);
        updateMeta(postVO.getCid(), postVO);
        return postVO.getCid();
    }

    public void updateMeta(int cid, PostVO postVo) {
        // 处理自定义字段
        fieldMapper.deleteField(cid);
        fieldMapper.addField(cid, postVo.getFields());
        // 处理标签
        tagDAO.removeTagRelation(cid);
        tagDAO.addTagRelation(cid, postVo.getSelectedTag());
    }
}
