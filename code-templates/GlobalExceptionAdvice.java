package com.{company}.{project}.advice;

import com.{company}.{project}.exception.BusinessException;
import com.{company}.{project}.exception.SystemException;
import com.{company}.{project}.vo.response.CommonResponse;
import com.{company}.{project}.vo.response.PageCommonResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 全局异常处理器
 * 
 * 统一处理应用中的各种异常，返回统一的错误响应格式
 * 
 * @author 开发团队
 * @since 1.0.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 处理业务异常
     * 
     * @param e 业务异常
     * @return 错误响应
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<Void> handleBusinessException(BusinessException e) {
        log.warn("业务异常: {}", e.getMessage());
        return CommonResponse.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理系统异常
     * 
     * @param e 系统异常
     * @return 错误响应
     */
    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<Void> handleSystemException(SystemException e) {
        log.error("系统异常: {}", e.getMessage(), e);
        return CommonResponse.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数验证异常（@Valid 注解）
     * 
     * @param e 参数验证异常
     * @return 错误响应
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<Void> handleValidationException(MethodArgumentNotValidException e) {
        log.warn("参数验证失败: {}", e.getMessage());
        
        StringBuilder errorMsg = new StringBuilder("参数验证失败: ");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errorMsg.append(fieldError.getField())
                   .append(" ")
                   .append(fieldError.getDefaultMessage())
                   .append("; ");
        }
        
        return CommonResponse.error(4000, errorMsg.toString());
    }

    /**
     * 处理参数绑定异常
     * 
     * @param e 参数绑定异常
     * @return 错误响应
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<Void> handleBindException(BindException e) {
        log.warn("参数绑定失败: {}", e.getMessage());
        
        StringBuilder errorMsg = new StringBuilder("参数绑定失败: ");
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errorMsg.append(fieldError.getField())
                   .append(" ")
                   .append(fieldError.getDefaultMessage())
                   .append("; ");
        }
        
        return CommonResponse.error(4000, errorMsg.toString());
    }

    /**
     * 处理约束违反异常
     * 
     * @param e 约束违反异常
     * @return 错误响应
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<Void> handleConstraintViolationException(ConstraintViolationException e) {
        log.warn("约束违反异常: {}", e.getMessage());
        
        StringBuilder errorMsg = new StringBuilder("参数验证失败: ");
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            errorMsg.append(violation.getPropertyPath())
                   .append(" ")
                   .append(violation.getMessage())
                   .append("; ");
        }
        
        return CommonResponse.error(4000, errorMsg.toString());
    }

    /**
     * 处理非法参数异常
     * 
     * @param e 非法参数异常
     * @return 错误响应
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResponse<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("非法参数异常: {}", e.getMessage());
        return CommonResponse.error(4000, "参数错误: " + e.getMessage());
    }

    /**
     * 处理空指针异常
     * 
     * @param e 空指针异常
     * @return 错误响应
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<Void> handleNullPointerException(NullPointerException e) {
        log.error("空指针异常", e);
        return CommonResponse.error(5000, "系统内部错误");
    }

    /**
     * 处理通用异常
     * 
     * @param e 通用异常
     * @return 错误响应
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResponse<Void> handleException(Exception e) {
        log.error("未知异常", e);
        return CommonResponse.error(5000, "系统异常，请稍后重试");
    }

    /**
     * 处理分页查询异常
     * 
     * @param e 业务异常
     * @return 分页错误响应
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public PageCommonResponse<Void> handlePageBusinessException(BusinessException e) {
        log.warn("分页查询业务异常: {}", e.getMessage());
        return PageCommonResponse.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理分页查询系统异常
     * 
     * @param e 系统异常
     * @return 分页错误响应
     */
    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public PageCommonResponse<Void> handlePageSystemException(SystemException e) {
        log.error("分页查询系统异常: {}", e.getMessage(), e);
        return PageCommonResponse.error(e.getCode(), e.getMessage());
    }
}
