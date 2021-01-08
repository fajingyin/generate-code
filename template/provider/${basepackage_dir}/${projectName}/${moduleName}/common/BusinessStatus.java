package ${basepackage}.${projectName}.${moduleName}.common;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 业务状态枚举
 *
 */
@Getter
public enum BusinessStatus {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 失败
     */
    FAILURE(1, "失败"),
    /**
     * 错误
     */
    ERROR(2, "错误"),
    /**
     * 未登录
     */
    UNAUTHORIZED(401, "还未登陆, 请重新登陆"),
    /**
     * 未登录
     */
    FORBIDDEN(403, "您的权限不足，无法访问该资源");

    /**
     * mybatis plus枚举识别,默认取name
     */
    @EnumValue
    private final Integer key;

    private final String value;

    BusinessStatus(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

}
