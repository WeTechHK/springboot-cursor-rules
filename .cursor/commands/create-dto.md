# /create-dto 命令

## 命令格式
```bash
/create-dto [一段描述性的话]
```

## 功能说明
创建数据传输对象(DTO)类，遵循Spring Boot最佳实践，包括字段映射、数据校验、序列化配置和数据转换支持。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取DTO名称、字段需求、数据用途
- **识别DTO类型**：判断是请求DTO、响应DTO、查询DTO、转换DTO等
- **推断字段复杂度**：评估字段的复杂度和验证需求

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的DTO设计文档、API设计文档
- **内容匹配**：基于描述内容匹配相关DTO文档
- **信息提取**：从文档中提取字段定义、验证规则、序列化配置等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的DTO设计风格、字段规范
- **模块识别**：识别相关模块和DTO依赖
- **规范推断**：推断项目的DTO设计规范

### 4. DTO规则匹配
- **规范匹配**：根据需求匹配对应的DTO编码规范
- **字段映射**：应用统一的字段映射规范
- **验证规则**：应用数据校验注解

### 5. 主动询问与确认
- **需求澄清**：对模糊描述进行主动询问
- **字段确认**：确认具体字段定义
- **验证确认**：确认字段验证规则
- **映射确认**：确认字段映射关系

## 使用示例

### 示例1：简单描述
```bash
# 用户输入
/create-dto 用户信息DTO

# AI响应
AI: 已解析您的描述"用户信息DTO"，并发现以下相关文档：

**发现的设计文档：**
- `docs/dto-design.md` - DTO设计文档
- `docs/user-api-design.md` - 用户API设计文档
- `docs/field-mapping.md` - 字段映射文档

基于这些文档，UserDto将包含以下字段定义：

**字段定义规划：**
- 基础信息字段（id、username、email）
- 个人信息字段（nickname、avatar、phone）
- 状态字段（status、enabled、createTime）
- 扩展字段（roles、permissions）

**需要确认的细节：**
1. 用户信息包含哪些字段？（用户名、邮箱、手机号等）
2. 字段验证规则？（非空、格式、长度等）
3. 是否需要敏感字段脱敏？
4. 字段映射关系如何？

请提供详细信息，或者确认以上规划是否符合您的需求？
```

### 示例2：详细描述
```bash
# 用户输入
/create-dto 订单查询DTO，包含订单号、用户ID、订单状态、时间范围等查询条件

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/order-dto-design.md` - 订单DTO设计文档
- `docs/query-dto-standards.md` - 查询DTO标准文档
- `docs/field-validation.md` - 字段验证文档

基于这些文档，OrderQueryDto将包含以下查询字段：

**查询字段规划：**
1. **基础查询字段**
   - orderNo - 订单号（模糊查询）
   - userId - 用户ID（精确查询）
   - orderStatus - 订单状态（枚举查询）

2. **时间范围字段**
   - startTime - 开始时间
   - endTime - 结束时间
   - createTimeRange - 创建时间范围

3. **分页排序字段**
   - pageNumber - 页码
   - pageSize - 页大小
   - sortField - 排序字段
   - sortOrder - 排序方向

4. **扩展查询字段**
   - minAmount - 最小金额
   - maxAmount - 最大金额
   - paymentMethod - 支付方式

**需要确认的信息：**
基于您的描述，我将智能判断是否需要确认信息：

- **如果描述完整**：直接开始生成DTO类
- **如果缺少字段信息**：询问具体的字段和数据类型
- **如果缺少验证规则**：询问字段验证和约束规则
- **如果缺少查询条件**：询问查询条件和过滤规则
- **如果描述模糊**：询问关键字段细节

**当前状态：** 基于您的描述，我将智能推断DTO字段和验证规则，如有疑问会主动询问。
```

## 生成内容

### 1. DTO类
- `src/main/java/com/example/app/dto/UserDto.java` - 用户DTO
- `src/main/java/com/example/app/dto/OrderDto.java` - 订单DTO
- `src/main/java/com/example/app/dto/OrderQueryDto.java` - 订单查询DTO

### 2. DTO规范
遵循 `.cursor/rules/03-code-file-convertions/dto-class-conventions.mdc` 规范：
- 使用 `@Data` 注解自动生成getter/setter
- 使用 `@JsonInclude(JsonInclude.Include.NON_NULL)` 忽略null值
- 使用 `@Schema` 注解提供API文档
- 使用 `@Valid` 注解进行数据校验
- 使用 `@Accessors(chain = true)` 支持链式调用

### 3. 字段注解
- **数据校验**：`@NotNull`、`@NotBlank`、`@Size`、`@Email`、`@Pattern`
- **序列化**：`@JsonFormat`、`@JsonIgnore`、`@JsonProperty`
- **API文档**：`@Schema`、`@ApiModelProperty`
- **字段映射**：`@Mapping`、`@JsonProperty`

## 技术特性

### 1. 数据校验
- Bean Validation注解支持
- 自定义校验器支持
- 分组校验支持
- 校验错误信息国际化

### 2. 序列化配置
- JSON序列化/反序列化
- 字段忽略配置
- 日期格式配置
- 枚举序列化配置

### 3. 数据转换
- 与Entity对象转换
- 与VO对象转换
- 字段映射配置
- 类型转换支持

## 进一步阅读
- DTO规范：`03-code-file-convertions/dto-class-conventions.mdc`
- 请求响应规范：`03-code-file-convertions/request-class-conventions.mdc`、`03-code-file-convertions/response-class-conventions.mdc`
- 命名规范：`02-coding-standards/naming-standards.mdc`