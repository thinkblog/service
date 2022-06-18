package cn.thinkmoon.blog.modules.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SiteMapController {

    @GetMapping(value = "/sitemap.xml", produces = {"application/xml;charset=UTF-8"})
    @ResponseBody
    public void getSiteMap(HttpServletResponse response) throws IOException {

    }
}