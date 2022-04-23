package cn.thinkmoon.blog.modules.post.service;

import cn.thinkmoon.blog.modules.post.dao.PostDAO;
import cn.thinkmoon.blog.modules.post.pojo.PostPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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

    public IPage<PostPO> selectPage(Page<PostPO> page, String category, String keyword) {
        return postMapper.selectPage(page, category, "%" + keyword + "%");
    }

    public PostPO getDetail(String cid) {
        return postMapper.getDetail(cid);
    }

    public PostPO getAboutPost() {
        return postMapper.getAboutPost();
    }

    public boolean addPost(int authorId,String title,String text,int category_id) {
        PostPO post = new PostPO(authorId,title,text,category_id);
        return postMapper.insertPost(post);
    }

    public boolean updatePost(String cid,int userId,String title,String text,int category_id) {
        PostPO post = new PostPO(Long.parseLong(cid),userId,title,text,category_id);
        return postMapper.updatePost(post);
    }
}
