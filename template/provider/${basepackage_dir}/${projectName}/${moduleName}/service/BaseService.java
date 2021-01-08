<#include "/javadoc_source.include">
package ${basepackage}.${projectName}.${moduleName}.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import ${basepackage}.${projectName}.${moduleName}.dao.entity.${className};
public interface BaseService<T> extends IService<T> {

    /**
     * 分页查询
     *
     * @param entity    实体对象
     * @param pageNo    页码
     * @param pageSize  每页显示条数,默认20
     * @return com.baomidou.mybatisplus.core.metadata.IPage<T> 分页对象
     */
    IPage<T> page(T entity, Integer pageNo, Integer pageSize);

    /**
     * 分页查询
     *
     * @param entity   实体对象
     * @param pageSize 起始页，默认每页显示条数20
     * @return com.baomidou.mybatisplus.core.metadata.IPage<T> 分页对象
     */
    default IPage<T> page(T entity, Integer pageSize) {
        return this.page(entity, 1, pageSize);
    }

}
