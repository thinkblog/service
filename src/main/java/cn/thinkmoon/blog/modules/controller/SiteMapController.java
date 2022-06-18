package cn.thinkmoon.blog.modules.controller;

import cn.thinkmoon.blog.modules.service.CategoryService;
import cn.thinkmoon.blog.modules.service.PostService;
import cn.thinkmoon.blog.modules.service.SiteMapService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SiteMapController {

    @Resource
    private SiteMapService siteMapService;
    @GetMapping(value = "/sitemap.xml", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public String getSiteMap(HttpServletResponse response) throws IOException {
        return siteMapService.getSiteMap();
    }
}