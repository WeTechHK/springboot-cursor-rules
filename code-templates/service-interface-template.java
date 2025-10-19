package com.{company}.{project}.service;

import com.{company}.{project}.dao.entity.{Module}Entity;
import com.{company}.{project}.vo.request.{module}.{Create}{Module}Request;
import com.{company}.{project}.vo.request.{module}.{Update}{Module}Request;
import com.{company}.{project}.vo.request.{module}.{Module}PageRequest;
import com.{company}.{project}.vo.response.CommonResponse;
import com.{company}.{project}.vo.response.PageCommonResponse;

import java.util.List;

/**
 * {模块中文名}服务接口
 * 
 * 定义{模块中文名}相关的业务逻辑接口
 * 
 * @author 开发团队
 * @since 1.0.0
 */
public interface {Module}Service {

    /**
     * 创建{模块中文名}
     * 
     * @param request 创建{模块中文名}请求
     * @return 创建结果
     */
    CommonResponse<Void> create{Module}({Create}{Module}Request request);

    /**
     * 更新{模块中文名}
     * 
     * @param request 更新{模块中文名}请求
     * @return 更新结果
     */
    CommonResponse<Void> update{Module}({Update}{Module}Request request);

    /**
     * 删除{模块中文名}
     * 
     * @param id {模块中文名}ID
     * @return 删除结果
     */
    CommonResponse<Void> delete{Module}(Long id);

    /**
     * 根据ID查询{模块中文名}
     * 
     * @param id {模块中文名}ID
     * @return {模块中文名}详情
     */
    CommonResponse<{Module}Entity> get{Module}ById(Long id);

    /**
     * 分页查询{模块中文名}列表
     * 
     * @param request 分页查询请求
     * @return {模块中文名}列表
     */
    PageCommonResponse<List<{Module}Entity>> get{Module}List({Module}PageRequest request);

    /**
     * 批量删除{模块中文名}
     * 
     * @param ids {模块中文名}ID列表
     * @return 删除结果
     */
    CommonResponse<Void> batchDelete{Module}(List<Long> ids);

    /**
     * 根据条件查询{模块中文名}列表
     * 
     * @param condition 查询条件
     * @return {模块中文名}列表
     */
    CommonResponse<List<{Module}Entity>> get{Module}ListByCondition(String condition);

    /**
     * 统计{模块中文名}数量
     * 
     * @param condition 统计条件
     * @return {模块中文名}数量
     */
    CommonResponse<Long> count{Module}(String condition);

    /**
     * 检查{模块中文名}是否存在
     * 
     * @param id {模块中文名}ID
     * @return 是否存在
     */
    CommonResponse<Boolean> exists{Module}(Long id);

    /**
     * 启用{模块中文名}
     * 
     * @param id {模块中文名}ID
     * @return 启用结果
     */
    CommonResponse<Void> enable{Module}(Long id);

    /**
     * 禁用{模块中文名}
     * 
     * @param id {模块中文名}ID
     * @return 禁用结果
     */
    CommonResponse<Void> disable{Module}(Long id);
}
