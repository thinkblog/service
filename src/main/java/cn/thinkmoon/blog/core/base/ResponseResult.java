package cn.thinkmoon.blog.core.base;

import cn.thinkmoon.blog.core.enums.ResultEnum;

public class ResponseResult {

    private boolean success ;
    private int code ;
    private String msg ;
    private Object data ;

    public ResponseResult(ResultEnum Result){
        this.success = Result.state;
        this.code = Result.code;
        this.msg = Result.message;
        this.data = null;
    }

    public ResponseResult(Object obj){
        this.success = ResultEnum.SUCCESS.state ;
        this.code = ResultEnum.SUCCESS.code ;
        this.msg = ResultEnum.SUCCESS.message ;
        this.data = obj;
    }

    public static ResponseResult SUCCESS(){
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    public static ResponseResult ERROR(){
        return new ResponseResult(ResultEnum.SERVER_ERROR);
    }

    public static ResponseResult FAIL(){
        return new ResponseResult(ResultEnum.FAIL);
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
