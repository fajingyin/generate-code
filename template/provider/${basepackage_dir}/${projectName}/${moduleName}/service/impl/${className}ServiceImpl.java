<#include "/javadoc_source.include">
package ${basepackage}.${projectName}.${moduleName}.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${basepackage}.${projectName}.${moduleName}.dto.request.RequestPage;
import ${basepackage}.${projectName}.${moduleName}.service.impl.BaseServiceImpl;
import ${basepackage}.${projectName}.${moduleName}.dao.entity.${className};
import ${basepackage}.${projectName}.${moduleName}.dao.mapper.${className}Mapper;
import ${basepackage}.${projectName}.${moduleName}.service.${className}Service;
import org.springframework.stereotype.Service;

/**
 * Service接口实现类
 *
 * @author ${author}
 * @version 1.0
 * @date <#if now??>${now?string('yyyy/MM/dd HH:mm')}</#if>
 */
@Service
public class ${className}ServiceImpl extends BaseServiceImpl<${className}Mapper,${className}> implements ${className}Service{
	
}
