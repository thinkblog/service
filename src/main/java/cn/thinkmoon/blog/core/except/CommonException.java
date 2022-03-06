package cn.thinkmoon.blog.core.except;

import cn.thinkmoon.blog.core.enums.ResultEnum;

public class CommonException extends Exception {
    private static final long serialVersionUID = -950010155084574600L;

    private final ResultEnum result;

    public ResultEnum getResultCode() {
        return result;
    }

    public CommonException(ResultEnum result) {
        this.result = result;
    }
}
