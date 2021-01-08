<#include "/javadoc_source.include">
package ${basepackage}.${projectName}.${moduleName}.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
<#if superEntityClass?? && superEntityClass?trim != "">
import ${superEntityClass};
<#else>
import java.io.Serializable;
</#if>

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
<#if superEntityClass?? && superEntityClass?trim != "">
import lombok.EqualsAndHashCode;
</#if>
<#list table.columns as column>
<#if column.isStringColumn>
import javax.validation.constraints.Size;
<#break>
</#if>
</#list>

<#list table.columns as column>
<#if column.isStringColumn && column.nullable == false>
import javax.validation.constraints.NotBlank;
<#break>
</#if>
</#list>
<#list table.columns as column>
<#if column.isNumberColumn && column.nullable == false>
import javax.validation.constraints.NotNull;
<#break>
</#if>
</#list>
<#list table.columns as column>
<#if column.javaType == 'Date'>
import java.util.Date;
<#break>
</#if>
</#list>

/**
 * ${className} DO
 *
 * @author ${author}
 * @version 1.0
 * @date <#if now??>${now?string('yyyy/MM/dd HH:mm')}</#if>
 */
@Data
<#if superEntityClass?? && superEntityClass?trim != "">
@EqualsAndHashCode(callSuper = true)
@TableName("${table.sqlName}")
@ApiModel(description = "${className}实体")
public class ${className} extends ${superEntityClass?substring(superEntityClass?last_index_of(".")+1)}{
<#else>
@TableName("${table.sqlName}")
@ApiModel(description = "${className}实体")
public class ${className} implements Serializable{
</#if>

	<#list table.columns as column>
	<#if superEntityClass?? && superEntityClass?trim != "" && !ignoreAttributes?seq_contains(column.columnNameLower)>
	/**
	 * ${column.remarks!''}
 	 */
	<#if column.pk>
	@TableId(value = "id",type = IdType.AUTO)
	</#if>
	@ApiModelProperty(value = "${column.remarks!''}" <#if column.nullable == false>, required = true</#if>)
	<#if column.isStringColumn && column.nullable>
	@Size(max = ${column.size}, message = "不能超过{max}位")
	<#elseif column.isStringColumn && column.nullable == false>
	@NotBlank
	@Size(max = ${column.size}, message = "不能超过{max}位")
	<#elseif column.isNumberColumn && column.nullable == false>
	@NotNull
	</#if>
	private ${column.javaType} ${column.columnNameLower};
    <#elseif superEntityClass?trim == "">
	/**
	 * ${column.remarks!''}
 	 */
	<#if column.pk>
    @TableId(value = "id",type = IdType.AUTO)
	</#if>
	@ApiModelProperty(value = "${column.remarks!''}" <#if column.nullable == false>, required = true</#if>)
	<#if column.isStringColumn && column.nullable>
	@Size(max = ${column.size}, message = "不能超过{max}位")
	<#elseif column.isStringColumn && column.nullable == false>
	@NotBlank
	@Size(max = ${column.size}, message = "不能超过{max}位")
	<#elseif column.isNumberColumn && column.nullable == false>
	@NotNull
	</#if>
	private ${column.javaType} ${column.columnNameLower};
	</#if>
	</#list>
}
