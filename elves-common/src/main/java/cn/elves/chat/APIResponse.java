package cn.elves.chat;

public class APIResponse<T> {


    private Integer code;

    private String msg;

    private T data;

    public APIResponse() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public APIResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public APIResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> APIResponse<T> fail(String msg) {
        return new APIResponse<T>(500, "fail");
    }


    public static <T> APIResponse<T> success(T t) {
        return new APIResponse<T>(200, "success", t);
    }


}
