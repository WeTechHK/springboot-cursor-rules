# /create-integration 命令

## 命令格式
```bash
/create-integration [一段描述性的话]
```

## 功能说明
创建集成测试类，遵循Spring Boot最佳实践，包括测试环境配置、测试数据准备、端到端测试和测试清理。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取测试模块、测试场景、测试需求
- **识别测试类型**：判断是API测试、数据库测试、服务集成测试、端到端测试等
- **推断测试复杂度**：评估测试的复杂度和实现难度

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的测试设计文档、集成测试文档
- **内容匹配**：基于描述内容匹配相关测试文档
- **信息提取**：从文档中提取测试场景、测试数据、测试规范等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的测试结构、测试规范
- **模块识别**：识别相关模块和测试依赖
- **规范推断**：推断项目的测试设计规范

### 4. 测试规则匹配
- **规范匹配**：根据需求匹配对应的测试编码规范
- **测试框架**：应用Spring Boot测试框架
- **测试数据**：应用测试数据管理规范

### 5. 主动询问与确认
- **需求澄清**：对模糊描述进行主动询问
- **场景确认**：确认具体测试场景
- **数据确认**：确认测试数据需求
- **环境确认**：确认测试环境配置

## 使用示例

### 示例1：简单描述
```bash
# 用户输入
/create-integration 用户管理集成测试

# AI响应
AI: 已解析您的描述"用户管理集成测试"，并发现以下相关文档：

**发现的设计文档：**
- `docs/integration-test-design.md` - 集成测试设计文档
- `docs/user-management-test.md` - 用户管理测试文档
- `docs/test-data-management.md` - 测试数据管理文档

基于这些文档，UserManagementIntegrationTest将包含以下测试场景：

**测试场景规划：**
- 用户注册流程测试
- 用户登录流程测试
- 用户信息更新测试
- 用户删除流程测试
- 用户权限验证测试

**需要确认的细节：**
1. 测试场景是否完整？
2. 测试数据如何准备？
3. 是否需要Mock外部服务？
4. 测试环境如何配置？

请提供详细信息，或者确认以上规划是否符合您的需求？
```

### 示例2：详细描述
```bash
# 用户输入
/create-integration 订单管理端到端测试，包含订单创建、支付、发货、完成等完整流程

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/order-e2e-test-design.md` - 订单端到端测试设计文档
- `docs/payment-integration-test.md` - 支付集成测试文档
- `docs/delivery-process-test.md` - 配送流程测试文档

基于这些文档，OrderManagementE2ETest将包含以下测试场景：

**端到端测试场景规划：**
1. **订单创建流程**
   - 商品选择测试
   - 购物车操作测试
   - 订单提交测试
   - 订单验证测试

2. **支付流程测试**
   - 支付方式选择测试
   - 支付接口调用测试
   - 支付结果处理测试
   - 支付异常处理测试

3. **发货流程测试**
   - 库存扣减测试
   - 发货单生成测试
   - 物流信息更新测试
   - 发货状态通知测试

4. **完成流程测试**
   - 收货确认测试
   - 订单完成测试
   - 评价流程测试
   - 售后流程测试

**需要确认的信息：**
1. 测试场景是否覆盖完整流程？
2. 测试数据如何模拟真实环境？
3. 外部服务如何Mock？
4. 测试断言如何设计？

请确认以上信息是否正确，或者提供更多详细信息？
```

## 生成内容

### 1. 集成测试类
- `src/test/java/com/example/app/integration/UserManagementIntegrationTest.java` - 用户管理集成测试
- `src/test/java/com/example/app/integration/OrderManagementE2ETest.java` - 订单管理端到端测试
- `src/test/java/com/example/app/integration/PaymentIntegrationTest.java` - 支付集成测试

### 2. 测试配置
- `src/test/resources/application-test.yml` - 测试环境配置
- `src/test/resources/test-data.sql` - 测试数据脚本
- `src/test/resources/test-data.json` - 测试数据JSON文件

### 3. 测试规范
遵循 `.cursor/rules/02-coding-standards/unit-testing-standards.mdc` 规范：
- 使用 `@SpringBootTest` 进行集成测试
- 使用 `@TestConfiguration` 配置测试环境
- 使用 `@DirtiesContext` 清理测试间状态
- 使用 `@MockBean` 模拟外部依赖

## 技术特性

### 1. 测试环境
- Spring Boot测试环境
- 测试数据库配置
- 测试数据准备
- 测试环境隔离

### 2. 测试数据
- 测试数据管理
- 测试数据清理
- 测试数据隔离
- 测试数据验证

### 3. 测试执行
- 并行测试执行
- 测试结果报告
- 测试覆盖率统计
- 测试性能监控

## 进一步阅读
- 单元测试规范：`02-coding-standards/unit-testing-standards.mdc`
- 编码规范：`02-coding-standards/coding-standards.mdc`
- 项目结构：`00-project-structure/project-structure.mdc`
- 技术栈：`00-project-structure/tech-stack.mdc`