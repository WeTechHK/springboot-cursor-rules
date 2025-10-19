package com.{company}.{project}.vo.request.{module};

import com.{company}.{project}.vo.request.CommonRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 创建{模块中文名}请求
 * 
 * @author 开发团队
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "创建{模块中文名}请求")
public class {Create}{Module}Request extends CommonRequest {

    @Schema(description = "名称", example = "测试{模块中文名}", required = true)
    @NotBlank(message = "名称不能为空")
    @Size(max = 100, message = "名称长度不能超过100个字符")
    private String name;

    @Schema(description = "描述", example = "这是一个测试{模块中文名}")
    @Size(max = 500, message = "描述长度不能超过500个字符")
    private String description;

    @Schema(description = "金额", example = "1000.00")
    @DecimalMin(value = "0.01", message = "金额必须大于0")
    @DecimalMax(value = "999999999.99", message = "金额不能超过999999999.99")
    private BigDecimal amount;

    @Schema(description = "状态", example = "ACTIVE")
    @Pattern(regexp = "^(ACTIVE|INACTIVE)$", message = "状态只能是ACTIVE或INACTIVE")
    private String status;

    @Schema(description = "类型", example = "TYPE_A")
    @NotBlank(message = "类型不能为空")
    private String type;

    @Schema(description = "优先级", example = "1")
    @Min(value = 1, message = "优先级最小值为1")
    @Max(value = 10, message = "优先级最大值为10")
    private Integer priority;

    @Schema(description = "是否启用", example = "true")
    private Boolean enabled = true;

    @Schema(description = "备注", example = "这是一个备注")
    @Size(max = 1000, message = "备注长度不能超过1000个字符")
    private String remark;
}
