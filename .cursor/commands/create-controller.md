# /create-controller 命令

## 命令格式
```bash
/create-controller [模块名称] [API描述]
```

## 参数说明
- `[模块名称]`: 模块名称，用于生成控制器类名
- `[API描述]`: API功能描述，用于生成相应的接口方法

## 功能说明
创建RESTful API控制器，遵循Spring Boot最佳实践：
- 标准的RESTful API设计
- 统一的响应格式
- 完整的参数校验
- 异常处理机制
- API文档注解

## 生成内容

### 1. 控制器类 (Controller)
- 使用`@RestController`注解标记
- 类名以`Controller`结尾
- 使用`@RequestMapping`指定API路由
- 符合RESTful设计原则

### 2. API接口方法
- 根据功能描述生成相应的API方法
- 仅使用`@GetMapping`和`@PostMapping`
- 简单查询使用GET，复杂查询和修改使用POST
- 统一的参数处理和响应格式

### 3. 参数处理
- 路径参数使用`@PathVariable`
- 查询参数使用`@RequestParam`
- 请求体参数使用`@RequestBody @Valid`
- 自动参数校验和类型转换

### 4. 响应处理
- 统一使用`CommonResponse<T>`包装响应
- 分页查询使用`CommonPageResponse<T>`
- 标准HTTP状态码
- 错误信息统一处理

### 5. API文档
- 使用`@Operation`注解进行API文档说明
- 包含摘要和描述信息
- 参数和响应示例
- 符合OpenAPI规范

## 编码规范遵循

本命令严格遵循以下编码规范文件：
- **主要规范**：`03-code-file-convertions/controller-class-conventions.mdc`
- **相关规范**：`01-design-standards/api-design-standards.mdc`

**详细规范**：请参考上述规范文件获取完整要求。

## 使用示例

### 1. 创建用户管理API
```bash
/create-controller User 用户管理API，包含CRUD操作
```

### 2. 创建订单管理API
```bash
/create-controller Order 订单管理API，包含订单创建、状态更新、查询
```

### 3. 创建商品管理API
```bash
/create-controller Product 商品管理API，包含商品信息、库存管理
```

## 标准API接口

### 1. 查询接口
- `GET /api/v1/{module}s/{id}` - 根据ID查询
- `POST /api/v1/{module}s/query` - 条件查询
- `POST /api/v1/{module}s/page` - 分页查询

### 2. 修改接口
- `POST /api/v1/{module}s` - 创建记录
- `POST /api/v1/{module}s/{id}` - 更新记录
- `POST /api/v1/{module}s/{id}/delete` - 删除记录

## 控制器特性
1. **标准化**: 遵循RESTful API设计规范
2. **统一性**: 统一的响应格式和错误处理
3. **安全性**: 参数校验和权限控制
4. **文档化**: 完整的API文档注解
5. **可维护**: 清晰的代码结构和注释

## 技术实现
- **注解**: 使用Spring MVC注解
- **校验**: 使用Bean Validation进行参数校验
- **文档**: 使用Swagger/OpenAPI生成文档
- **异常**: 全局异常处理机制
- **响应**: 统一响应包装类

## 注意事项
1. 会根据API描述生成相应的接口方法
2. 自动处理参数校验和类型转换
3. 包含完整的异常处理机制
4. 遵循项目的编码规范和命名约定
5. 生成的代码可以直接运行和测试
