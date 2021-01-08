package ${basepackage}.${projectName}.${moduleName}.dto.resp;

import cn.hutool.core.date.DateUtil;
import ${basepackage}.${projectName}.${moduleName}.common.BusinessStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 响应结果封装类
 *
 */
@Data
@ApiModel(value = "ResponseData")
public class ResponseData<T> {
    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳", name = "timestamp", example = "2020-01-01")
    private String timestamp;

    /**
     * http 状态码
     */
    @ApiModelProperty(value = "状态码", name = "code", example = "0")
    private int code;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息", name = "msg", example = "成功")
    private String msg;

    /**
     * 返回的数据
     */
    @ApiModelProperty(value = "返回数据", name = "data")
    private T data;

    public ResponseData() {
        // 无参构造函数
    }

    public ResponseData(String timestamp, int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.timestamp = timestamp;
        this.data = data;
    }

    /**
     * 返回成功消息
     *
     * @param <T> 泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> success() {
        return success(BusinessStatus.SUCCESS.getValue());
    }

    /**
     * 返回成功消息，自定义msg
     *
     * @param msg 返回消息
     * @param <T> 泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> success(String msg) {
        return ResponseData.success(msg, null);
    }

    /**
     * 返回成功消息，自定义data
     *
     * @param data 数据对象
     * @param <T>  泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> success(T data) {
        return success(BusinessStatus.SUCCESS.getValue(), data);
    }

    /**
     * 返回成功消息，自定义msg和data
     *
     * @param msg  返回消息
     * @param data 数据对象
     * @param <T>  泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> success(String msg, T data) {
        return ResponseData.success(BusinessStatus.SUCCESS.getKey(), msg, data);
    }

    /**
     * 返回成功消息，自定义code,msg
     *
     * @param code 状态吗
     * @param msg  返回消息
     * @param <T>  泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> success(int code, String msg) {
        return ResponseData.success(code, msg, null);
    }

    /**
     * 返回成功消息，自定义code,msg和data
     *
     * @param code 状态吗
     * @param msg  返回消息
     * @param data 数据对象
     * @param <T>  泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> success(int code, String msg, T data) {
        return new ResponseData<>(DateUtil.formatDateTime(new Date()), code, msg, (T)data);
    }

    /**
     * 返回失败消息
     *
     * @param <T> 泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> failure() {
        return ResponseData.failure(BusinessStatus.FAILURE.getValue());
    }

    /**
     * 返回失败消息，自定义msg
     *
     * @param msg 返回消息
     * @param <T> 泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> failure(String msg) {
        return ResponseData.failure(msg, null);
    }

    /**
     * 返回失败消息，自定义msg和data
     *
     * @param msg  返回消息
     * @param data 数据对象
     * @param <T>  泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> failure(String msg, T data) {
        return ResponseData.failure(BusinessStatus.FAILURE.getKey(), msg, data);
    }

    /**
     * 返回失败消息，自定义code,msg
     *
     * @param code 状态吗
     * @param msg  返回消息
     * @param <T>  泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> failure(int code, String msg) {
        return ResponseData.failure(code, msg, null);
    }

    /**
     * 返回失败消息，自定义code,msg和data
     *
     * @param code 状态吗
     * @param msg  返回消息
     * @param data 数据对象
     * @param <T>  泛型
     * @return ResponseData
     */
    public static <T> ResponseData<T> failure(int code, String msg, T data) {
        return new ResponseData<T>(DateUtil.formatDateTime(new Date()), code, msg, data);
    }

    /**
     * 是否成功
     *
     * @return 成功:true/失败:false
     */
    public Boolean isSuccess() {
        return this.code == BusinessStatus.SUCCESS.getKey();
    }
}
