package cn.thinkmoon.blog.post.service;

import cn.thinkmoon.blog.post.dao.PostDAO;
import cn.thinkmoon.blog.post.pojo.PostPO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public IPage<PostPO> selectPage(Page<PostPO> page, int mid, String keyword) {
        return postMapper.selectPage(page, mid, "%" + keyword + "%");
    }

    public PostPO getDetail(String cid) {
        return postMapper.getDetail(cid);
    }

    public PostPO getAboutPost() {
        return postMapper.getAboutPost();
    }

    public boolean addPost(int authorId,String title,String text,String category_id) {
        PostPO post = new PostPO(authorId,title,text,category_id);
        return postMapper.insertPost(post);
    }

    public boolean updatePost(int cid,int authorId,String title,String text,String category_id) {
        PostPO post = new PostPO(cid,authorId,title,text,category_id);
        return postMapper.updatePost(post);
    }
}
