package cn.thinkmoon.blog.modules.pojo.dto;

public class SiteMapDTO {
    /**
     * url https://www.xxx.com
     */
    private final String loc;

    public static String BASE_URL = "https://www.thinkmoon.cn";

    @Override
    /* 重写 toString 适应xml格式 */
    public String toString() {
        return "<url>" +
                "<loc>" + loc + "</loc>" +
                "</url>";
    }

    public SiteMapDTO(String loc) {
        this.loc = BASE_URL + loc;
    }
}