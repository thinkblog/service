package cn.thinkmoon.blog.core.enums;

/**
 * 公共的返回码
 *
 */
public enum ResultEnum {

    SUCCESS(true, 200, "操作成功！"),
    // ---系统错误返回码-----
    FAIL(false, 10001, "操作失败"),
    UNAUTHENTICATED(false, 401, "您还未登录"),
    UNAUTHORISE(false, 10003, "权限不足"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");

    // ---用户操作返回码 2xxxx----
    // ---企业操作返回码 3xxxx----
    // ---权限操作返回码----
    // ---其他操作返回码----

    // 操作是否成功
    public boolean state;
    // 操作代码
    public int code;
    // 提示信息
    public String message;

    ResultEnum(boolean success, int code, String message) {
        this.state = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return state;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
