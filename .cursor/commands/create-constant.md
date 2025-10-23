# /create-constant 命令

## 命令格式
```bash
/create-constant [一段描述性的话]
```

## 功能说明
创建常量类，遵循Spring Boot最佳实践，包括常量定义、分组管理、访问控制和文档说明。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取常量类型、常量名称、常量用途
- **识别常量类型**：判断是业务常量、系统常量、配置常量、枚举常量等
- **推断常量复杂度**：评估常量的复杂度和组织方式

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的常量设计文档、业务规范文档
- **内容匹配**：基于描述内容匹配相关常量文档
- **信息提取**：从文档中提取常量定义、业务规则、命名规范等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的常量组织方式、命名规范
- **模块识别**：识别相关模块和常量依赖
- **规范推断**：推断项目的常量管理规范

### 4. 常量规则匹配
- **规范匹配**：根据需求匹配对应的常量编码规范
- **命名规范**：应用统一的常量命名规范
- **分组管理**：按功能模块分组管理常量

### 5. 主动询问与确认
- **需求澄清**：对模糊描述进行主动询问
- **常量确认**：确认具体常量定义
- **分组确认**：确认常量分组方式
- **命名确认**：确认常量命名规范

## 使用示例

### 示例1：简单描述
```bash
# 用户输入
/create-constant 用户状态常量

# AI响应
AI: 已解析您的描述"用户状态常量"，并发现以下相关文档：

**发现的设计文档：**
- `docs/constants-design.md` - 常量设计文档
- `docs/user-business-rules.md` - 用户业务规则文档
- `docs/naming-standards.md` - 命名规范文档

基于这些文档，UserStatusConstants将包含以下常量定义：

**常量定义规划：**
- 用户状态常量（正常、禁用、锁定）
- 用户类型常量（普通用户、VIP用户、管理员）
- 用户权限常量（读取、写入、删除）
- 用户操作常量（登录、登出、注册）

**需要确认的细节：**
1. 用户状态有哪些？（正常、禁用、锁定、待激活等）
2. 用户类型有哪些？（普通用户、VIP用户、管理员等）
3. 是否需要权限常量？
4. 常量值的格式要求？

请提供详细信息，或者确认以上规划是否符合您的需求？
```

### 示例2：详细描述
```bash
# 用户输入
/create-constant 订单相关常量，包含订单状态、支付状态、配送状态等

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/order-business-rules.md` - 订单业务规则文档
- `docs/payment-status-design.md` - 支付状态设计文档
- `docs/delivery-status-design.md` - 配送状态设计文档
- `docs/constants-design.md` - 常量设计文档

基于这些文档，OrderConstants将包含以下常量定义：

**常量分组规划：**
1. **订单状态常量**
   - PENDING_PAYMENT - 待支付
   - PAID - 已支付
   - SHIPPED - 已发货
   - DELIVERED - 已送达
   - COMPLETED - 已完成
   - CANCELLED - 已取消

2. **支付状态常量**
   - PAYMENT_PENDING - 支付中
   - PAYMENT_SUCCESS - 支付成功
   - PAYMENT_FAILED - 支付失败
   - PAYMENT_REFUNDED - 已退款

3. **配送状态常量**
   - DELIVERY_PENDING - 待配送
   - DELIVERY_IN_PROGRESS - 配送中
   - DELIVERY_COMPLETED - 配送完成
   - DELIVERY_FAILED - 配送失败

**需要确认的信息：**
基于您的描述，我将智能判断是否需要确认信息：

- **如果描述完整**：直接开始生成常量类
- **如果缺少常量定义**：询问具体的常量值和枚举
- **如果缺少业务常量**：询问具体的业务状态和类型
- **如果缺少技术常量**：询问技术相关的常量配置
- **如果描述模糊**：询问关键常量细节

**当前状态：** 基于您的描述，我将智能推断常量定义和业务状态，如有疑问会主动询问。
```

## 生成内容

### 1. 常量类
- `src/main/java/com/example/app/constants/UserConstants.java` - 用户相关常量
- `src/main/java/com/example/app/constants/OrderConstants.java` - 订单相关常量
- `src/main/java/com/example/app/constants/SystemConstants.java` - 系统相关常量

### 2. 常量规范
遵循 `.cursor/rules/03-code-file-convertions/constants-class-conventions.mdc` 规范：
- 使用 `public static final` 定义常量
- 常量名使用全大写字母和下划线
- 按功能模块分组管理
- 提供完整的JavaDoc注释
- 使用 `final` 类避免被继承

### 3. 常量组织
- **按模块分组**：用户模块、订单模块、系统模块
- **按类型分组**：状态常量、类型常量、配置常量
- **按用途分组**：业务常量、系统常量、配置常量

## 技术特性

### 1. 常量定义
- 类型安全的常量定义
- 常量值验证
- 常量分组管理
- 常量访问控制

### 2. 常量管理
- 常量类自动装配
- 常量条件化加载
- 常量文档生成
- 常量监控支持

### 3. 常量验证
- 常量值范围验证
- 常量类型验证
- 常量依赖验证
- 常量冲突检测

## 进一步阅读
- 常量规范：`03-code-file-convertions/constants-class-conventions.mdc`
- 命名规范：`02-coding-standards/naming-standards.mdc`
- 项目结构：`00-project-structure/project-structure.mdc`