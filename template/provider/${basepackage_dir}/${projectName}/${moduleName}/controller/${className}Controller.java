<#include "/javadoc_source.include">
package ${basepackage}.${projectName}.${moduleName}.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import ${basepackage}.${projectName}.${moduleName}.dto.request.RequestPage;
import ${basepackage}.${projectName}.${moduleName}.dto.resp.ResponseData;
import ${basepackage}.${projectName}.${moduleName}.dao.entity.${className};
import ${basepackage}.${projectName}.${moduleName}.service.${className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;

/**
 *  ${className} API接口实现类
 *
 * @author ${author}
 * @version 1.0
 * @date <#if now??>${now?string('yyyy/MM/dd HH:mm')}</#if>
 */
@RestController
@Api(tags = {"${className}-API"})
@RequestMapping("/${moduleName}/${classNameFirstLower}")
public class ${className}Controller extends BaseController {

	@Resource
	private ${className}Service ${classNameFirstLower}Service;

	@PostMapping("/page")
	@ApiOperation(value = "分页查询")
	public  ResponseData<IPage<${className}>> page(@RequestBody RequestPage<${className}> request) {
		IPage<${className}> page = ${classNameFirstLower}Service.page(request.getData(), request.getPageNo(), request.getPageSize());
		return page !=null ? ResponseData.success(page) : ResponseData.failure();
	}

	@PostMapping("/save")
	@ApiOperation(value = "保存数据")
	public ResponseData<${className}> save(@RequestBody ${className} entity){
		return ${classNameFirstLower}Service.save(entity) ? ResponseData.success() : ResponseData.failure();
	}

	@PostMapping("/update")
	@ApiOperation(value = "根据ID更新")
	public ResponseData<${className}> update(@RequestBody ${className} entity){
		return ${classNameFirstLower}Service.updateById(entity) ? ResponseData.success() : ResponseData.failure();
	}

	@PostMapping("/remove")
	@ApiOperation("根据ID删除")
	public ResponseData<${className}> remove(Long id){
		return ${classNameFirstLower}Service.removeById(id) ? ResponseData.success() : ResponseData.failure();
	}

	@GetMapping("/get")
	@ApiOperation("根据ID查询")
	public ResponseData<${className}> get(Long id){
		${className} entity = ${classNameFirstLower}Service.getById(id);
		return entity !=null ? ResponseData.success(entity) : ResponseData.failure();
	}
}
