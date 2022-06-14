package cn.thinkmoon.blog.modules.post.service;

import cn.thinkmoon.blog.modules.content.dao.TagDAO;
import cn.thinkmoon.blog.modules.post.dao.FieldDAO;
import cn.thinkmoon.blog.modules.post.dao.PostDAO;
import cn.thinkmoon.blog.modules.post.pojo.FieldsPO;
import cn.thinkmoon.blog.modules.post.pojo.PostPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
        return postMapper.selectPage(page, category, "%" + keyword + "%",null);
    }

    public List<PostPO> getListByTag(String tagName) {
        List<PostPO> po = tagDAO.getPostList(tagName);
        return postMapper.selectPage(po,"","");
    }

    public PostPO getDetail(String cid) {
        return postMapper.getDetail(cid);
    }

    public PostPO getAboutPost() {
        return postMapper.getAboutPost();
    }

    public int addPost(int authorId,String title,String text,int category_id,List<FieldsPO> fieldsPOList) {
        PostPO post = new PostPO(authorId,title,text,category_id);
        postMapper.insertPost(post);
        int cid = post.getCid();
        fieldMapper.deleteField(cid);
        fieldsPOList.stream().forEach(item -> item.setCid(cid));
        fieldMapper.addField(fieldsPOList);
        return cid;
    }

    public boolean updatePost(int cid,int userId,String title,String text,int category_id) {
        PostPO post = new PostPO(cid,userId,title,text,category_id);
        return postMapper.updatePost(post);
    }
}
