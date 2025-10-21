# /create-service 命令

## 命令格式
```bash
/create-service [模块名称] [业务描述]
```

## 参数说明
- `[模块名称]`: 模块名称，用于生成服务接口和实现类名
- `[业务描述]`: 业务功能描述，用于生成相应的业务方法

## 功能说明
创建完整的服务层代码，包括：
- 服务接口 (Service Interface)
- 服务实现 (ServiceImpl)
- 业务逻辑封装
- 事务管理配置
- 异常处理机制

## 生成内容

### 1. 服务接口 (Service Interface)
- 接口名以`Service`结尾
- 定义业务方法签名
- 清晰的业务边界划分
- 完整的JavaDoc注释

### 2. 服务实现 (ServiceImpl)
- 实现类名以`ServiceImpl`结尾
- 使用`@Service`注解标记
- 业务逻辑具体实现
- 事务管理配置

### 3. 业务方法
- 根据业务描述生成相应方法
- 标准的CRUD业务操作
- 复杂业务逻辑封装
- 数据校验和业务规则

### 4. 依赖注入
- 使用`@Autowired`注入依赖
- 数据访问层依赖注入
- 工具类和配置类依赖

### 5. 异常处理
- 业务异常处理和转换
- 数据访问异常处理
- 自定义业务异常抛出

## 编码规范遵循

本命令严格遵循以下编码规范文件：
- **主要规范**：`03-code-file-convertions/service-interface-conventions.mdc`、`service-impl-conventions.mdc`
- **相关规范**：`01-design-standards/design-pattern-standards.mdc`

**详细规范**：请参考上述规范文件获取完整要求。

## 使用示例

### 1. 创建订单管理服务
```bash
/create-service Order 订单管理服务，包含订单创建、状态更新、支付处理
```

### 2. 创建用户管理服务
```bash
/create-service User 用户管理服务，包含用户注册、登录验证、权限管理
```

### 3. 创建商品管理服务
```bash
/create-service Product 商品管理服务，包含商品信息、库存管理、价格计算
```

## 标准业务方法

### 1. 基础CRUD操作
- `create{Domain}()` - 创建业务对象
- `update{Domain}()` - 更新业务对象
- `delete{Domain}ById()` - 删除业务对象
- `get{Domain}ById()` - 根据ID查询
- `list{Domain}s()` - 列表查询

### 2. 复杂业务操作
- `process{Domain}()` - 复杂业务处理
- `validate{Domain}()` - 业务数据校验
- `convert{Domain}()` - 数据转换处理

### 3. 业务查询方法
- `find{Domain}sByCondition()` - 条件查询
- `search{Domain}s()` - 搜索查询
- `get{Domain}sByPage()` - 分页查询

## 服务层特性
1. **业务封装**: 完整的业务逻辑封装
2. **事务管理**: 合理的事务边界控制
3. **异常处理**: 统一的异常处理机制
4. **可测试**: 支持单元测试和集成测试
5. **可扩展**: 支持业务功能扩展

## 技术实现
- **接口设计**: 清晰的业务接口定义
- **实现类**: 使用`@Service`注解标记
- **事务**: 使用`@Transactional`管理事务
- **依赖注入**: 使用`@Autowired`注入依赖
- **异常处理**: 业务异常和系统异常处理

## 注意事项
1. 会根据业务描述生成相应的业务方法
2. 自动处理事务管理和异常处理
3. 包含完整的业务逻辑和数据校验
4. 遵循项目的编码规范和架构设计
5. 生成的代码可以直接运行和测试
