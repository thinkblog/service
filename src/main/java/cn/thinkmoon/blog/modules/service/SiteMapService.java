package cn.thinkmoon.blog.modules.service;

import cn.thinkmoon.blog.modules.pojo.po.SiteMapPO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SiteMapService {
    public static String BEGIN_DOC = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">";

    static String END_DOC = "</urlset>";
    public static String BASE_URL = "https://www.thinkmoon.c/";


    public StringBuffer getSiteMap(HttpServletResponse response) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(BEGIN_DOC);//拼接开始部分
        sb.append(new SiteMapPO(BASE_URL));//拼接网站首页地址

        List<Blog> list = blogMapper.findAllBlog();
        for (Blog blog : list) {
            sb.append(new SiteMap("https://www.lovelin.space/blog/detail/" + blog.getBid() + ".html", blog.getCreateTime(), CHANGEFREQ_DAILY, "0.8"));
        }
        sb.append(END_DOC);//拼接结尾
        return sb;
    }
}
