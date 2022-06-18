package cn.thinkmoon.blog.modules.service;

import cn.thinkmoon.blog.modules.pojo.dao.PostDAO;
import cn.thinkmoon.blog.modules.pojo.po.PostPO;
import cn.thinkmoon.blog.modules.pojo.dto.SiteMapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteMapService {
    public static String BEGIN_DOC = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">";

    static String END_DOC = "</urlset>";
    public static String BASE_URL = "https://www.thinkmoon.cn";

    @Autowired
    private PostDAO postMapper;

    public String getSiteMap() {
        StringBuilder sb = new StringBuilder();
        sb.append(BEGIN_DOC);//拼接开始部分
        sb.append(new SiteMapDTO(BASE_URL));//拼接网站首页地址
        // 文章内容
        List<PostPO> list = postMapper.findAll();
        for (PostPO post : list) {
            sb.append(new SiteMapDTO(BASE_URL + "/post/" + post.getCid()));
        }
        int page = list.size() / 10 + 1;
        // 分页内容
        int i = 1;
        while (i <= page) {
            sb.append(new SiteMapDTO(BASE_URL + "/page/" + i));
            i++;
        }
        sb.append(END_DOC);//拼接结尾
        return sb.toString();
    }
}
