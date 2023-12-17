package cn.elves;

public class APIResponse<T> {

    private Integer code;

    private String msg;

    private T data;

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
