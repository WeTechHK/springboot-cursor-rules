package com.{company}.{project}.controller.{module};

import com.{company}.{project}.vo.request.{module}.{Create}{Module}Request;
import com.{company}.{project}.vo.request.{module}.{Module}PageRequest;
import com.{company}.{project}.vo.response.CommonResponse;
import com.{company}.{project}.vo.response.PageCommonResponse;
import com.{company}.{project}.service.{Module}Service;
import com.{company}.{project}.dao.entity.{Module}Entity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {模块中文名}控制器
 * 
 * 提供{模块中文名}相关的 REST API 接口
 * 
 * @author 开发团队
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/{module}")
@RequiredArgsConstructor
@Tag(name = "{模块中文名} API", description = "管理{模块中文名}的 API")
public class {Module}Controller {

    private final {Module}Service {module}Service;

    /**
     * 创建{模块中文名}
     * 
     * @param request 创建{模块中文名}请求
     * @return 创建结果
     */
    @PostMapping("/create")
    @Operation(summary = "创建{模块中文名}", description = "验证后创建新的{模块中文名}")
    public CommonResponse<Void> create(@RequestBody @Valid {Create}{Module}Request request) {
        log.info("开始创建{模块中文名}，请求参数: {}", request);
        return {module}Service.create{Module}(request);
    }

    /**
     * 更新{模块中文名}
     * 
     * @param request 更新{模块中文名}请求
     * @return 更新结果
     */
    @PostMapping("/update")
    @Operation(summary = "更新{模块中文名}", description = "更新{模块中文名}信息")
    public CommonResponse<Void> update(@RequestBody @Valid {Update}{Module}Request request) {
        log.info("开始更新{模块中文名}，请求参数: {}", request);
        return {module}Service.update{Module}(request);
    }

    /**
     * 删除{模块中文名}
     * 
     * @param id {模块中文名}ID
     * @return 删除结果
     */
    @PostMapping("/delete")
    @Operation(summary = "删除{模块中文名}", description = "根据ID删除{模块中文名}")
    public CommonResponse<Void> delete(@RequestParam Long id) {
        log.info("开始删除{模块中文名}，ID: {}", id);
        return {module}Service.delete{Module}(id);
    }

    /**
     * 根据ID查询{模块中文名}
     * 
     * @param id {模块中文名}ID
     * @return {模块中文名}详情
     */
    @PostMapping("/detail")
    @Operation(summary = "查询{模块中文名}详情", description = "根据ID查询{模块中文名}详细信息")
    public CommonResponse<{Module}Entity> getById(@RequestParam Long id) {
        log.info("开始查询{模块中文名}详情，ID: {}", id);
        return {module}Service.get{Module}ById(id);
    }

    /**
     * 分页查询{模块中文名}列表
     * 
     * @param request 分页查询请求
     * @return {模块中文名}列表
     */
    @PostMapping("/list")
    @Operation(summary = "分页查询{模块中文名}列表", description = "根据条件分页查询{模块中文名}列表")
    public PageCommonResponse<List<{Module}Entity>> list(@RequestBody @Valid {Module}PageRequest request) {
        log.info("开始分页查询{模块中文名}列表，请求参数: {}", request);
        return {module}Service.get{Module}List(request);
    }

    /**
     * 批量删除{模块中文名}
     * 
     * @param ids {模块中文名}ID列表
     * @return 删除结果
     */
    @PostMapping("/batch-delete")
    @Operation(summary = "批量删除{模块中文名}", description = "根据ID列表批量删除{模块中文名}")
    public CommonResponse<Void> batchDelete(@RequestBody List<Long> ids) {
        log.info("开始批量删除{模块中文名}，ID列表: {}", ids);
        return {module}Service.batchDelete{Module}(ids);
    }
}
