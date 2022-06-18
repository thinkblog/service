package cn.thinkmoon.blog.modules.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SiteMapService {
    public static String BEGIN_DOC = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">";

    static String END_DOC = "</urlset>";
    static String CHANGEFREQ_DAILY = "daily";
    public static String CHANGEFREQ_ALWAYS = "always";


    @GetMapping(value = "/sitemap.xml", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public void getSiteMap(HttpServletResponse response) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(BEGIN_DOC);//拼接开始部分
        sb.append(new SiteMap("https://www.lovelin.space/"));//拼接网站首页地址
        //下面是根据实际情况写，目的是生成整站的Url
//        List<String> param = new ArrayList<>();
        List<Blog> list=  blogMapper.findAllBlog();
        for (Blog blog : list) {
            sb.append(new SiteMap("https://www.lovelin.space/blog/detail/" +blog.getBid() +".html" ,blog.getCreateTime(), CHANGEFREQ_DAILY, "0.8"));
        }
        sb.append(END_DOC);//拼接结尾
        response.setContentType(MediaType.APPLICATION_XML_VALUE);
        Writer writer = response.getWriter();

        writer.append(sb.toString());
    }
}
