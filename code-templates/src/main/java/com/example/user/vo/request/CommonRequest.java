package com.example.user.vo.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Base class for all request objects
 * Provides common fields needed across different request types
 * 
 * @author 开发者姓名
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Common Request")
public class CommonRequest {

    @Schema(description = "Sequence number for request tracking", example = "REQ20240501000001")
    @Size(max = 50, message = "序列号长度不能超过50个字符")
    protected String seqNo;
}
