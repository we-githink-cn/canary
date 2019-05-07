package cn.githink.core.utils;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 毛子坤
 * @Title:
 * @Package
 * @Description:
 * @date 2019/5/7 10:35
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class Dp<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int code = 0;

    @Getter
    @Setter
    private String msg = "success";


    @Getter
    @Setter
    private T data;

    public Dp() {
        super();
    }

    public Dp(T data) {
        super();
        this.data = data;
    }

    public Dp(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public Dp(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = 1;
    }
}
