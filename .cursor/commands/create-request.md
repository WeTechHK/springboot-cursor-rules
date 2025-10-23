# /create-request 命令

## 命令格式
```bash
/create-request [一段描述性的话]
```

## 功能说明
创建请求对象类，遵循Spring Boot最佳实践，包括参数校验、数据绑定、API文档和统一请求格式。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取请求类型、参数需求、校验规则
- **识别请求类型**：判断是创建请求、更新请求、查询请求、删除请求等
- **推断参数复杂度**：评估参数的复杂度和校验需求

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的请求设计文档、API设计文档
- **内容匹配**：基于描述内容匹配相关请求文档
- **信息提取**：从文档中提取参数定义、校验规则、API规范等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的请求设计风格、参数规范
- **模块识别**：识别相关模块和请求依赖
- **规范推断**：推断项目的请求设计规范

### 4. 请求规则匹配
- **规范匹配**：根据需求匹配对应的请求编码规范
- **参数校验**：应用统一的参数校验规范
- **API规范**：应用RESTful API设计规范

### 5. 主动询问与确认
- **需求澄清**：对模糊描述进行主动询问
- **参数确认**：确认具体参数定义
- **校验确认**：确认参数校验规则
- **格式确认**：确认请求格式规范

## 使用示例

### 示例1：简单描述
```bash
# 用户输入
/create-request 用户注册请求

# AI响应
AI: 已解析您的描述"用户注册请求"，并发现以下相关文档：

**发现的设计文档：**
- `docs/request-design.md` - 请求设计文档
- `docs/user-registration-api.md` - 用户注册API文档
- `docs/validation-rules.md` - 验证规则文档

基于这些文档，CreateUserRequest将包含以下请求字段：

**请求字段规划：**
- 基础信息字段（username、password、email）
- 个人信息字段（nickname、phone、gender）
- 验证字段（captcha、agreeTerms）
- 扩展字段（source、referrer）

**需要确认的细节：**
1. 用户注册需要哪些必填字段？
2. 字段验证规则？（用户名长度、密码强度、邮箱格式等）
3. 是否需要验证码字段？
4. 是否需要同意条款字段？

请提供详细信息，或者确认以上规划是否符合您的需求？
```

### 示例2：详细描述
```bash
# 用户输入
/create-request 订单创建请求，包含商品信息、收货地址、支付方式、优惠券等

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/order-creation-api.md` - 订单创建API文档
- `docs/payment-integration.md` - 支付集成文档
- `docs/address-management.md` - 地址管理文档
- `docs/coupon-system.md` - 优惠券系统文档

基于这些文档，CreateOrderRequest将包含以下请求字段：

**请求字段规划：**
1. **商品信息字段**
   - productItems - 商品列表
   - productId - 商品ID
   - quantity - 商品数量
   - price - 商品价格

2. **收货地址字段**
   - receiverName - 收货人姓名
   - receiverPhone - 收货人电话
   - receiverAddress - 收货地址
   - receiverPostcode - 邮政编码

3. **支付信息字段**
   - paymentMethod - 支付方式
   - paymentAccount - 支付账户
   - totalAmount - 订单总金额

4. **优惠信息字段**
   - couponCode - 优惠券代码
   - discountAmount - 优惠金额
   - finalAmount - 最终金额

**需要确认的信息：**
基于您的描述，我将智能判断是否需要确认信息：

- **如果描述完整**：直接开始生成Request类
- **如果缺少字段信息**：询问具体的请求字段和数据类型
- **如果缺少验证规则**：询问字段验证和约束规则
- **如果缺少业务规则**：询问具体的业务验证需求
- **如果描述模糊**：询问关键请求字段细节

**当前状态：** 基于您的描述，我将智能推断Request字段和验证规则，如有疑问会主动询问。
```

## 生成内容

### 1. 请求类
- `src/main/java/com/example/app/vo/request/CreateUserRequest.java` - 创建用户请求
- `src/main/java/com/example/app/vo/request/UpdateUserRequest.java` - 更新用户请求
- `src/main/java/com/example/app/vo/request/QueryUserRequest.java` - 查询用户请求

### 2. 请求规范
遵循 `.cursor/rules/03-code-file-convertions/request-class-conventions.mdc` 规范：
- 使用 `@Data` 注解自动生成getter/setter
- 使用 `@JsonInclude(JsonInclude.Include.NON_NULL)` 忽略null值
- 使用 `@Schema` 注解提供API文档
- 使用 `@Valid` 注解进行参数校验
- 使用 `@Accessors(chain = true)` 支持链式调用

### 3. 校验注解
- **非空校验**：`@NotNull`、`@NotBlank`、`@NotEmpty`
- **长度校验**：`@Size`、`@Length`
- **格式校验**：`@Email`、`@Pattern`、`@URL`
- **数值校验**：`@Min`、`@Max`、`@Range`、`@DecimalMin`、`@DecimalMax`
- **自定义校验**：`@Valid`、`@Validated`

## 技术特性

### 1. 参数校验
- Bean Validation注解支持
- 分组校验支持
- 自定义校验器支持
- 校验错误信息国际化

### 2. 数据绑定
- 自动类型转换
- 嵌套对象绑定
- 集合对象绑定
- 日期格式绑定

### 3. API文档
- Swagger/OpenAPI注解支持
- 参数描述和示例
- 校验规则文档
- 请求示例生成

## 进一步阅读
- 请求规范：`03-code-file-convertions/request-class-conventions.mdc`
- 通用请求规范：`03-code-file-convertions/common-request-class-conventions.mdc`
- 校验规范：`03-code-file-convertions/validation-class-conventions.mdc`
- 命名规范：`02-coding-standards/naming-standards.mdc`