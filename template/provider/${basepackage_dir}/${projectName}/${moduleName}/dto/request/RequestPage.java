<#include "/javadoc_source.include">
package ${basepackage}.${projectName}.${moduleName}.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ${basepackage}.${projectName}.${moduleName}.dao.entity.${className};

@Data
@ApiModel(description = "分页请求参数")
public class RequestData<T>  {

    @ApiModelProperty(value = "当前页")
    private Integer pageNo=1;


    @ApiModelProperty(value = "每页大小")
    private Integer pageSize=10;

    @ApiModelProperty(value = "请求实体")
    private T data;


}
