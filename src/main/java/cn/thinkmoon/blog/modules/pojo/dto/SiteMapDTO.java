package cn.thinkmoon.blog.modules.pojo.dto;

public class SiteMapDTO {
    /**
     * url https://www.xxx.com
     */
    private final String loc;


    @Override
    /* 重写 toString 适应xml格式 */
    public String toString() {
        return "<url>" +
                "<loc>" + loc + "</loc>" +
                "</url>";
    }

    public SiteMapDTO(String loc) {
        this.loc=loc;
    }
}