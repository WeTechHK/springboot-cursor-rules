# /create-controller 命令

## 命令格式
```bash
/create-controller [一段描述性的话]
```

## 功能说明
创建RESTful API控制器，遵循Spring Boot最佳实践，包括标准的API设计、统一的响应格式、完整的参数校验和异常处理。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取模块名称、API功能、接口需求
- **识别API类型**：判断是CRUD操作、业务接口、查询接口等
- **推断接口复杂度**：评估API的复杂度和实现难度

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的API文档、接口设计文档
- **内容匹配**：基于描述内容匹配相关API文档
- **信息提取**：从文档中提取API设计、接口规范、参数定义等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的API设计风格、响应格式
- **模块识别**：识别相关模块和依赖关系
- **规范推断**：推断项目的API设计规范

### 4. 控制器规则匹配
- **规范匹配**：根据需求匹配对应的控制器编码规范
- **设计模式**：应用RESTful设计模式和最佳实践
- **代码生成**：生成符合项目规范的控制器代码

### 5. 主动询问机制
- **接口补全**：识别缺失或模糊的接口需求，主动询问用户
- **参数确认**：确认接口参数和响应格式
- **多轮对话**：支持多轮对话，逐步完善API设计

## 使用示例

### 1. 简单描述
```bash
/create-controller 用户管理API
```

### 2. 详细描述
```bash
/create-controller 用户管理API，包含用户注册、登录、信息查询、信息更新、删除功能
```

### 3. 业务场景描述
```bash
/create-controller 订单管理API，包含订单创建、支付处理、状态更新、物流跟踪
```

### 4. 技术需求描述
```bash
/create-controller 商品管理API，包含商品CRUD、库存管理、分类管理，需要支持图片上传
```

## AI交互示例

### 示例1：简单描述
```bash
# 用户输入
/create-controller 用户管理API

# AI响应
AI: 已解析您的描述"用户管理API"，并发现以下相关文档：

**发现的设计文档：**
- `docs/user-api-design.md` - 用户管理API设计文档
- `docs/api-standards.md` - API设计规范文档

基于这些文档，UserController将包含以下接口：
- `docs/request-response-models.md` - 请求响应模型文档

**API接口设计：**
- POST /api/v1/users - 创建用户
- GET /api/v1/users/{id} - 根据ID查询用户
- PUT /api/v1/users/{id} - 更新用户信息
- DELETE /api/v1/users/{id} - 删除用户
- POST /api/v1/users/login - 用户登录

**需要确认的信息：**
基于您的描述，我需要确认以下信息：

1. 具体的API接口需求
2. 核心字段和验证规则
3. 业务处理逻辑

请提供详细信息，或者确认我的推断是否正确？
```

### 示例2：详细描述
```bash
# 用户输入
/create-controller 用户管理API，包含用户注册、登录、信息查询、信息更新、删除功能

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/user-api-design.md` - 用户管理API设计文档
- `docs/api-standards.md` - API设计规范文档
- `docs/request-response-models.md` - 请求响应模型文档

基于这些文档，UserController将包含以下API接口：

**API接口实现：**
- POST /api/v1/users - 用户注册
- POST /api/v1/users/login - 用户登录
- GET /api/v1/users/{id} - 用户信息查询
- PUT /api/v1/users/{id} - 用户信息更新
- DELETE /api/v1/users/{id} - 用户删除

**推断的请求响应对象：**
- CreateUserRequest - 用户注册请求
- LoginRequest - 用户登录请求
- UpdateUserRequest - 用户更新请求
- UserResponse - 用户信息响应

**推断的数据库操作：**
- 用户注册：插入用户记录
- 用户登录：验证用户名密码
- 用户查询：根据ID查询用户
- 用户更新：更新用户信息
- 用户删除：软删除用户记录

**需要确认的信息：**
基于您的详细描述，我发现以下信息：

✅ **已明确**：用户注册、登录、查询、更新功能
✅ **API设计**：RESTful风格，统一响应格式
✅ **技术栈**：Spring Boot + MyBatis + JWT

信息完整，直接开始生成用户管理Controller类
```

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
1. AI会根据描述自动推断API接口
2. 自动处理参数校验和类型转换
3. 包含完整的异常处理机制
4. 遵循项目的编码规范和命名约定
5. 生成的代码可以直接运行和测试
6. 支持多轮对话完善需求
7. 支持文档引用和智能推断
8. 支持自然语言描述

## 最佳实践建议

### 1. 描述技巧
- **具体描述**: 提供详细的API功能描述，AI能更好地理解需求
- **关键功能**: 包含核心接口功能，帮助AI生成准确代码
- **技术细节**: 指定参数类型、响应格式等技术要求

### 2. 交互技巧
- **分步确认**: 先确认核心接口，再完善参数细节
- **及时反馈**: 对AI的推断及时提供反馈
- **迭代优化**: 基于生成结果进行迭代优化

### 3. 文档使用
- **API文档**: 在项目中维护API文档，AI会自动发现
- **接口文档**: 维护接口文档，AI会参考生成接口
- **参数文档**: 维护参数文档，AI会参考生成参数