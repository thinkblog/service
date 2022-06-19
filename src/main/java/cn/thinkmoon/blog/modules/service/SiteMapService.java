package cn.thinkmoon.blog.modules.service;

import cn.thinkmoon.blog.modules.pojo.dao.CategoryDAO;
import cn.thinkmoon.blog.modules.pojo.dao.PostDAO;
import cn.thinkmoon.blog.modules.pojo.dao.TagDAO;
import cn.thinkmoon.blog.modules.pojo.po.CategoryPO;
import cn.thinkmoon.blog.modules.pojo.po.PostPO;
import cn.thinkmoon.blog.modules.pojo.dto.SiteMapDTO;
import cn.thinkmoon.blog.modules.pojo.po.TagPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteMapService {
    public static String BEGIN_DOC = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">";

    static String END_DOC = "</urlset>";

    @Autowired
    private PostDAO postMapper;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private TagDAO tagDAO;

    public String getSiteMap() {
        StringBuilder sb = new StringBuilder();
        sb.append(BEGIN_DOC);//拼接开始部分
        sb.append(new SiteMapDTO(""));//拼接网站首页地址
        // 文章内容
        List<PostPO> list = postMapper.findAll();
        for (PostPO post : list) {
            sb.append(new SiteMapDTO("/post/" + post.getCid()));
        }
        int page = list.size() / 10 + 1;
        // 分页内容
        int i = 1;
        while (i <= page) {
            sb.append(new SiteMapDTO("/page/" + i));
            i++;
        }
        // 分类
        sb.append(new SiteMapDTO("/category"));
        List<CategoryPO> categoryPOList = categoryDAO.queryList("");
        categoryPOList.forEach(item -> {
            sb.append(new SiteMapDTO("/category/" + item.getName() + "/1"));
        });
        // 标签
        sb.append(new SiteMapDTO("/tag"));
        List<TagPO> tagPOList = tagDAO.queryList("");
        categoryPOList.forEach(item -> {
            sb.append(new SiteMapDTO("/tag/" + item.getName() + "/1"));
        });
        sb.append(END_DOC);//拼接结尾
        return sb.toString();
    }
}
