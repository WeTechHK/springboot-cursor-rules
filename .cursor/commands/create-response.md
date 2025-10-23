# /create-response 命令

## 命令格式
```bash
/create-response [一段描述性的话]
```

## 功能说明
创建响应对象类，遵循Spring Boot最佳实践，包括统一响应格式、数据封装、API文档和错误处理。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取响应类型、数据字段、返回格式
- **识别响应类型**：判断是数据响应、分页响应、错误响应、状态响应等
- **推断字段复杂度**：评估字段的复杂度和返回需求

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的响应设计文档、API设计文档
- **内容匹配**：基于描述内容匹配相关响应文档
- **信息提取**：从文档中提取字段定义、响应格式、错误码规范等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的响应设计风格、数据格式
- **模块识别**：识别相关模块和响应依赖
- **规范推断**：推断项目的响应设计规范

### 4. 响应规则匹配
- **规范匹配**：根据需求匹配对应的响应编码规范
- **格式统一**：应用统一的响应格式规范
- **错误处理**：应用统一的错误响应规范

### 5. 主动询问与确认
- **需求澄清**：对模糊描述进行主动询问
- **字段确认**：确认具体响应字段
- **格式确认**：确认响应格式规范
- **错误确认**：确认错误处理方式

## 使用示例

### 示例1：简单描述
```bash
# 用户输入
/create-response 用户信息响应

# AI响应
AI: 已解析您的描述"用户信息响应"，并发现以下相关文档：

**发现的设计文档：**
- `docs/response-design.md` - 响应设计文档
- `docs/user-api-design.md` - 用户API设计文档
- `docs/common-response-standards.md` - 通用响应标准文档

基于这些文档，UserResponse将包含以下响应字段：

**响应字段规划：**
- 基础信息字段（id、username、email）
- 个人信息字段（nickname、avatar、phone）
- 状态字段（status、enabled、createTime）
- 扩展字段（roles、permissions、lastLoginTime）

**需要确认的细节：**
1. 用户信息包含哪些字段？（用户名、邮箱、手机号等）
2. 是否需要敏感字段脱敏？
3. 字段返回格式要求？
4. 是否需要分页信息？

请提供详细信息，或者确认以上规划是否符合您的需求？
```

### 示例2：详细描述
```bash
# 用户输入
/create-response 订单列表响应，包含订单信息、分页信息、统计信息等

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/order-response-design.md` - 订单响应设计文档
- `docs/pagination-response.md` - 分页响应文档
- `docs/statistics-response.md` - 统计信息响应文档

基于这些文档，OrderListResponse将包含以下响应字段：

**响应字段规划：**
1. **分页信息字段**
   - total - 总记录数
   - pageNumber - 当前页码
   - pageSize - 每页大小
   - totalPages - 总页数

2. **订单列表字段**
   - orderList - 订单列表
   - orderNo - 订单号
   - orderStatus - 订单状态
   - orderAmount - 订单金额
   - createTime - 创建时间

3. **统计信息字段**
   - totalAmount - 总金额
   - orderCount - 订单数量
   - averageAmount - 平均金额
   - statusCount - 状态统计

**需要确认的信息：**
基于您的描述，我将智能判断是否需要确认信息：

- **如果描述完整**：直接开始生成Response类
- **如果缺少字段信息**：询问具体的响应字段和数据类型
- **如果缺少分页信息**：询问分页查询的响应格式
- **如果缺少业务字段**：询问具体的业务响应需求
- **如果描述模糊**：询问关键响应字段细节

**当前状态：** 基于您的描述，我将智能推断Response字段和格式规范，如有疑问会主动询问。
```

## 生成内容

### 1. 响应类
- `src/main/java/com/example/app/vo/response/UserResponse.java` - 用户信息响应
- `src/main/java/com/example/app/vo/response/OrderResponse.java` - 订单信息响应
- `src/main/java/com/example/app/vo/response/OrderListResponse.java` - 订单列表响应

### 2. 响应规范
遵循 `.cursor/rules/03-code-file-convertions/response-class-conventions.mdc` 规范：
- 使用 `@Data` 注解自动生成getter/setter
- 使用 `@JsonInclude(JsonInclude.Include.NON_NULL)` 忽略null值
- 使用 `@Schema` 注解提供API文档
- 使用 `@Accessors(chain = true)` 支持链式调用

### 3. 统一响应格式
- **成功响应**：`CommonResponse<T>` 包含 code、msg、data 字段
- **分页响应**：`CommonPageResponse<T>` 包含 total、pageNumber、pageSize、list 字段
- **错误响应**：统一的错误码和错误信息格式

## 技术特性

### 1. 数据封装
- 统一响应格式
- 数据脱敏处理
- 字段过滤控制
- 嵌套对象封装

### 2. 序列化配置
- JSON序列化配置
- 日期格式配置
- 枚举序列化配置
- 字段忽略配置

### 3. API文档
- Swagger/OpenAPI注解支持
- 响应示例生成
- 字段描述和类型
- 错误码文档

## 进一步阅读
- 响应规范：`03-code-file-convertions/response-class-conventions.mdc`
- 通用响应规范：`03-code-file-convertions/common-response-class-conventions.mdc`
- 分页响应规范：`03-code-file-convertions/common-page-response-class-conventions.mdc`
- 命名规范：`02-coding-standards/naming-standards.mdc`