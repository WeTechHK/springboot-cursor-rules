# AI交互命令参考

## 概述

本文档定义了与AI进行Spring Boot开发交互的27个预定义命令。用户可以直接输入这些命令来快速触发常见的开发任务，提高开发效率。

## 命令格式

```
/命令名 [参数1] [参数2] ...
```

## 命令索引

### 项目管理
- `/create-project` - 创建新项目
- `/init-structure` - 初始化项目结构

### 模块开发
- `/create-module` - 创建业务模块

### 代码文件
- `/create-controller` - 创建控制器
- `/create-service` - 创建服务层
- `/create-mapper` - 创建数据访问层
- `/create-entity` - 创建实体类
- `/create-dto` - 创建DTO类
- `/create-task` - 创建定时任务
- `/create-util` - 创建工具类
- `/create-constant` - 创建常量类
- `/create-enum` - 创建枚举类

### 请求响应对象
- `/create-request` - 创建请求对象
- `/create-response` - 创建响应对象

### 异常处理
- `/create-exception` - 创建业务异常
- `/setup-exception` - 配置全局异常处理

### 测试
- `/create-test` - 创建单元测试
- `/create-integration` - 创建集成测试

### 配置
- `/create-config` - 创建配置文件
- `/setup-database` - 配置数据源
- `/setup-security` - 配置安全

### 重构
- `/refactor-code` - 重构代码结构
- `/refactor-naming` - 重构命名规范

### 问题修复
- `/fix-performance` - 修复性能问题
- `/fix-concurrency` - 修复并发问题

### 工具
- `/format-code` - 代码格式化
- `/check-code` - 代码检查

## 一、项目管理命令

### 1. 创建新项目
```bash
/create-project [项目名称] [描述]
```

**功能说明：**
创建新的Spring Boot项目，包括项目目录结构初始化、基础配置文件生成、依赖管理配置、项目文档生成、基础代码模板。

**示例：**
```bash
/create-project student-management 学生管理系统，包含用户管理、课程管理、成绩管理
```

**AI响应示例：**
```
已完成项目需求分析，根据00-project-structure/project-structure.mdc创建学生管理系统项目结构

**计划：**
- 开发项目主启动类
- 开发基础配置类
- 开发用户管理模块
- 开发课程管理模块
- 开发成绩管理模块

**请确认：** 是否需要集成Spring Security和Redis缓存？
```

### 2. 初始化项目结构
```bash
/init-structure [项目类型]
```

**参数：**
- `basic`: 基础Spring Boot项目
- `web`: Web应用项目
- `api`: RESTful API项目
- `microservice`: 微服务项目

**功能说明：**
初始化现有项目的目录结构，根据项目类型创建相应的基础架构和配置文件。

**示例：**
```bash
/init-structure api
```

**AI响应示例：**
```
已完成API项目结构初始化，根据01-design-standards/api-design-standards.mdc配置RESTful架构

**计划：**
- 配置API基础结构
- 配置统一响应格式
- 配置全局异常处理
- 配置API文档
- 配置跨域处理

我将开始初始化API项目结构。
```

## 二、模块开发命令

### 3. 创建业务模块
```bash
/create-module [模块名称] [功能描述]
```

**功能说明：**
创建完整的业务模块，包括实体类、数据访问层、服务接口、服务实现、控制器、请求响应对象、单元测试。

**示例：**
```bash
/create-module user 用户管理模块，包含注册、登录、权限管理、用户信息维护
```

**AI响应示例：**
```
已完成用户管理模块分析，根据03-code-file-convertions/规范生成完整模块

**计划：**
- 开发UserController用户管理API
- 开发UserService用户业务逻辑
- 开发UserMapper用户数据访问
- 开发UserEntity用户实体类
- 开发用户相关Request/Response对象
- 开发用户权限管理功能

我将开始开发用户管理模块。
```


## 三、代码文件命令

### 4. 创建控制器
```bash
/create-controller [模块名称] [API描述]
```

**功能说明：**
创建RESTful API控制器，遵循Spring Boot最佳实践，包含标准的RESTful API设计、统一的响应格式、完整的参数校验、异常处理机制、API文档注解。

**示例：**
```bash
/create-controller User 用户管理API，包含CRUD操作
```

**AI响应示例：**
```
已完成用户控制器设计，根据03-code-file-convertions/controller-class-conventions.mdc生成UserController

**计划：**
- 开发用户基础CRUD API
- 开发用户权限管理API
- 开发用户状态管理API
- 开发用户搜索和筛选API
- 配置API参数校验和异常处理

我将开始开发UserController。
```

### 5. 创建服务层
```bash
/create-service [模块名称] [业务描述]
```

**功能说明：**
创建完整的服务层代码，包括服务接口、服务实现、业务逻辑封装、事务管理配置、异常处理机制。

**示例：**
```bash
/create-service Order 订单管理服务，包含订单创建、状态更新、支付处理、库存扣减
```

**AI响应示例：**
```
已完成订单服务层设计，根据03-code-file-convertions/service-interface-conventions.mdc和service-impl-conventions.mdc生成OrderService

**计划：**
- 开发OrderService接口定义
- 开发OrderServiceImpl实现类
- 开发订单创建业务逻辑
- 开发订单状态管理
- 开发支付处理逻辑
- 开发库存扣减逻辑
- 配置事务管理和异常处理

我将开始开发订单服务层。
```

### 6. 创建数据访问层
```bash
/create-mapper [实体名称] [查询需求]
```

**功能说明：**
创建MyBatis数据访问层代码，包括Mapper接口定义、基础CRUD操作方法、复杂查询方法、参数映射和结果映射、动态SQL支持。

**示例：**
```bash
/create-mapper User 用户基础CRUD和复杂查询，包含分页查询、条件筛选、统计查询
```

**AI响应示例：**
```
已完成用户Mapper设计，根据03-code-file-convertions/mapper-interface-conventions.mdc生成UserMapper

**计划：**
- 开发用户基础CRUD操作
- 开发用户分页查询
- 开发用户条件筛选查询
- 开发用户统计查询
- 开发用户批量操作
- 配置SQL注解和参数映射

我将开始开发UserMapper接口。
```

### 7. 创建实体类
```bash
/create-entity [实体名称] [字段描述]
```

**功能说明：**
创建MyBatis实体类，包括实体类定义、字段映射和注解、数据校验注解、序列化配置、数据库表映射。

**示例：**
```bash
/create-entity Product 商品实体，包含商品ID、名称、描述、价格、库存、分类、状态、创建时间
```

**AI响应示例：**
```
已完成商品实体类设计，根据03-code-file-convertions/entity-class-conventions.mdc生成Product实体

**计划：**
- 定义商品基础字段
- 配置字段注解和校验
- 配置数据库映射
- 配置序列化规则
- 配置实体关系映射

我将开始开发Product实体类。
```

### 8. 创建DTO类
```bash
/create-dto [DTO名称] [字段描述]
```

**功能说明：**
创建数据传输对象(DTO)类，包括DTO类定义、字段映射和注解、数据校验注解、序列化配置、数据转换支持。

**示例：**
```bash
/create-dto UserDto 用户数据传输对象，包含用户ID、用户名、邮箱、状态
```

### 9. 创建定时任务
```bash
/create-task [任务名称] [任务描述]
```

**功能说明：**
创建定时任务类，包括任务类定义、定时任务配置、任务执行逻辑、异常处理机制、任务监控配置。

**示例：**
```bash
/create-task DataSyncTask 数据同步任务，每小时同步一次用户数据
```

### 10. 创建工具类
```bash
/create-util [工具名称] [功能描述]
```

**功能说明：**
创建工具类，包括工具类定义、静态方法实现、工具方法封装、异常处理机制、性能优化。

**示例：**
```bash
/create-util DateUtil 日期工具类，包含日期格式化、计算、转换功能
```

### 11. 创建常量类
```bash
/create-constant [常量名称] [常量描述]
```

**功能说明：**
创建常量类，包括常量类定义、常量定义和分组、常量访问控制、常量文档说明、常量验证。

**示例：**
```bash
/create-constant SystemConstants 系统常量，包含系统配置、状态码、错误信息
```

### 12. 创建枚举类
```bash
/create-enum [枚举名称] [枚举描述]
```

**功能说明：**
创建枚举类，包括枚举类定义、枚举值设计、枚举方法定义、枚举查找验证、枚举序列化配置。

**示例：**
```bash
/create-enum OrderStatus 订单状态枚举，包含待支付、已支付、已发货、已完成、已取消
```

## 四、请求响应对象命令

### 13. 创建请求对象
```bash
/create-request [操作名称] [字段描述]
```

**功能说明：**
创建请求对象类，包括请求类定义、字段校验注解、数据转换支持、序列化配置、API文档注解。

**示例：**
```bash
/create-request CreateUser 创建用户请求，包含用户名、邮箱、密码、手机号、角色
```

**AI响应示例：**
```
已完成用户创建请求对象设计，根据03-code-file-convertions/request-class-conventions.mdc生成CreateUserRequest

**计划：**
- 定义请求字段结构
- 配置字段校验注解
- 配置字段格式验证
- 配置请求参数绑定
- 配置序列化规则

我将开始开发CreateUserRequest。
```

### 14. 创建响应对象
```bash
/create-response [数据名称] [字段描述]
```

**功能说明：**
创建响应对象类，包括响应类定义、字段映射和注解、序列化配置、API文档注解、数据转换支持。

**示例：**
```bash
/create-response ProductInfo 商品信息响应，包含商品ID、名称、价格、库存、分类、状态
```

**AI响应示例：**
```
已完成商品信息响应对象设计，根据03-code-file-convertions/response-class-conventions.mdc生成ProductInfoResponse

**计划：**
- 定义响应字段结构
- 配置字段序列化规则
- 配置敏感信息脱敏
- 配置响应格式统一
- 配置字段类型转换

我将开始开发ProductInfoResponse。
```

## 五、异常处理命令

### 15. 创建业务异常
```bash
/create-exception [异常名称] [异常描述]
```

**功能说明：**
创建自定义业务异常类，包括异常类定义、错误码和错误信息、异常构造函数、异常处理机制、国际化支持。

**示例：**
```bash
/create-exception ProductNotFoundException 商品不存在异常
```

**AI响应示例：**
```
已完成商品不存在异常设计，根据03-code-file-convertions/exception-class-conventions.mdc生成ProductNotFoundException

**计划：**
- 定义异常类结构
- 配置异常消息格式
- 配置错误码定义
- 配置异常构造函数
- 配置异常链传递

我将开始开发ProductNotFoundException。
```

### 16. 配置全局异常处理
```bash
/setup-exception [处理范围]
```

**参数：**
- `all`: 处理所有异常
- `business`: 仅处理业务异常
- `custom`: 自定义异常处理

**功能说明：**
配置全局异常处理器，包括全局异常处理器类、异常映射和处理逻辑、统一错误响应格式、异常日志记录、异常监控和告警。

**示例：**
```bash
/setup-exception business
```

**AI响应示例：**
```
已完成全局异常处理器配置，根据03-code-file-convertions/global-exception-handler-conventions.mdc配置业务异常处理

**计划：**
- 开发全局异常处理器
- 配置业务异常处理逻辑
- 配置异常响应格式
- 配置异常日志记录
- 配置异常监控

我将开始配置全局异常处理器。
```

## 六、测试命令

### 17. 创建单元测试
```bash
/create-test [测试目标] [测试范围]
```

**参数：**
- `controller`: 控制器测试
- `service`: 服务层测试
- `mapper`: 数据访问层测试
- `all`: 全模块测试

**功能说明：**
创建单元测试代码，包括测试类定义、测试方法实现、Mock对象配置、断言验证、测试数据准备。

**示例：**
```bash
/create-test UserService 服务层单元测试，包含正常流程和异常情况
```

**AI响应示例：**
```
已完成用户服务单元测试设计，根据02-coding-standards/unit-testing-standards.mdc生成测试用例

**计划：**
- 开发UserServiceTest测试类
- 开发正常流程测试用例
- 开发异常情况测试用例
- 配置Mock依赖注入
- 配置测试数据准备
- 配置断言验证

我将开始开发UserService单元测试。
```

### 18. 创建集成测试
```bash
/create-integration [测试模块] [测试场景]
```

**功能说明：**
创建集成测试代码，包括集成测试类定义、测试场景实现、测试环境配置、数据准备和清理、端到端测试验证。

**示例：**
```bash
/create-integration UserController 用户管理API集成测试
```

**AI响应示例：**
```
已完成用户控制器集成测试设计，根据02-coding-standards/unit-testing-standards.mdc生成集成测试

**计划：**
- 开发UserControllerIntegrationTest
- 配置测试环境
- 开发API接口测试
- 开发数据一致性测试
- 配置测试数据清理

我将开始开发用户控制器集成测试。
```

## 七、配置命令

### 19. 创建配置文件
```bash
/create-config [配置类型] [配置描述]
```

**参数：**
- `database`: 数据库配置
- `redis`: Redis配置
- `security`: 安全配置
- `logging`: 日志配置
- `custom`: 自定义配置
- `full`: 完整项目配置

**功能说明：**
根据指定的配置类型和描述，自动生成符合Spring Boot规范的配置文件，包括application.yml主配置文件、环境配置、数据库配置和日志配置。

**示例：**
```bash
/create-config database MySQL数据库配置，包含连接池、事务管理、主从配置
```

**AI响应示例：**
```
已完成数据库配置设计，根据02-coding-standards/build-and-deployment-standards.mdc配置MySQL数据库

**计划：**
- 配置数据源连接
- 配置连接池参数
- 配置事务管理器
- 配置主从数据库
- 配置数据库监控

我将开始配置数据库。
```

### 20. 配置数据源
```bash
/setup-database [数据库类型] [配置参数]
```

**功能说明：**
配置数据源，包括数据源配置类、连接池配置、事务管理配置、多数据源配置、读写分离配置。

**示例：**
```bash
/setup-database mysql 主从数据库配置，包含读写分离
```

**AI响应示例：**
```
已完成MySQL主从数据库配置，根据02-coding-standards/build-and-deployment-standards.mdc配置数据源

**计划：**
- 配置主数据源
- 配置从数据源
- 配置读写分离
- 配置连接池参数
- 配置事务管理

我将开始配置MySQL数据源。
```

### 21. 配置安全
```bash
/setup-security [安全类型] [配置描述]
```

**功能说明：**
配置Spring Security安全框架，包括安全配置类、认证配置、授权配置、安全过滤器配置、安全策略配置。

**示例：**
```bash
/setup-security basic 基础安全配置，包含登录认证、权限控制
```

## 八、重构命令

### 22. 重构代码结构
```bash
/refactor-code [重构范围] [优化目标]
```

**功能说明：**
重构代码结构，包括代码结构优化、设计模式应用、性能优化、代码质量提升、架构改进。

**示例：**
```bash
/refactor-code UserService 优化事务管理和异常处理
```

**AI响应示例：**
```
已完成用户服务结构分析，根据02-coding-standards/coding-standards.mdc制定重构方案

**计划：**
- 重构事务管理逻辑
- 重构异常处理机制
- 重构日志记录方式
- 重构代码结构组织
- 重构性能优化点

我将开始重构UserService。
```

### 23. 重构命名规范
```bash
/refactor-naming [文件类型] [命名规则]
```

**功能说明：**
重构命名规范，包括类名重构、方法名重构、变量名重构、包名重构、常量名重构。

**示例：**
```bash
/refactor-naming controller 统一API路径和参数命名
```

**AI响应示例：**
```
已完成控制器命名规范分析，根据02-coding-standards/naming-standards.mdc制定重构方案

**计划：**
- 重构控制器类名
- 重构API路径命名
- 重构方法参数命名
- 重构响应对象命名
- 统一命名风格

我将开始重构控制器命名规范。
```

## 九、问题修复命令

### 24. 修复性能问题
```bash
/fix-performance [问题模块] [性能瓶颈]
```

**功能说明：**
修复性能问题，包括性能问题分析、性能优化方案、代码重构实现、性能测试验证、性能监控配置。

**示例：**
```bash
/fix-performance UserQuery N+1查询问题
```

**AI响应示例：**
```
已完成用户查询性能问题分析，根据02-coding-standards/coding-standards.mdc制定修复方案

**计划：**
- 修复N+1查询问题
- 优化查询语句
- 配置查询缓存
- 优化数据加载策略
- 配置性能监控

我将开始修复用户查询性能问题。
```

### 25. 修复并发问题
```bash
/fix-concurrency [问题场景] [并发类型]
```

**功能说明：**
修复并发问题，包括并发问题分析、并发控制方案、线程安全实现、并发测试验证、并发监控配置。

**示例：**
```bash
/fix-concurrency OrderCreate 订单创建并发冲突
```

**AI响应示例：**
```
已完成订单创建并发问题分析，根据02-coding-standards/coding-standards.mdc制定修复方案

**计划：**
- 修复并发冲突问题
- 配置锁机制
- 优化事务管理
- 配置并发控制
- 配置并发监控

我将开始修复订单创建并发问题。
```

## 十、工具命令

### 26. 代码格式化
```bash
/format-code [代码范围]
```

**参数：**
- `all`: 格式化所有代码
- `current`: 格式化当前文件
- `module`: 格式化指定模块

**功能说明：**
格式化代码，包括代码格式化、导入语句整理、代码风格统一、注释格式规范、代码布局优化。

**示例：**
```bash
/format-code UserController
```

**AI响应示例：**
```
已完成UserController代码格式化，根据02-coding-standards/code-style-standards.mdc格式化代码

**计划：**
- 格式化代码缩进
- 整理导入语句
- 统一代码风格
- 规范注释格式
- 优化代码布局

我将开始格式化UserController代码。
```

### 27. 代码检查
```bash
/check-code [检查范围] [检查类型]
```

**参数：**
- `syntax`: 语法检查
- `style`: 代码风格检查
- `security`: 安全检查
- `performance`: 性能检查

**功能说明：**
检查代码质量，包括语法错误检查、代码风格检查、安全检查、性能问题检查、代码质量报告。

**示例：**
```bash
/check-code UserService security
```

**AI响应示例：**
```
已完成UserService安全检查，根据02-coding-standards/coding-standards.mdc检查安全问题

**计划：**
- 检查SQL注入问题
- 检查XSS攻击问题
- 检查敏感信息泄露
- 检查权限控制问题
- 生成安全检查报告

我将开始检查UserService安全问题。
```

## 命令使用说明

### 1. 基本用法
- 命令以 `/` 开头，后跟命令名称
- 参数用空格分隔
- 参数可以用引号包围包含空格的描述

### 2. 参数规则
- `[必选参数]`: 必须提供的参数
- `[可选参数]`: 可选的参数，用方括号表示
- `参数1|参数2`: 多个选项中的一个

### 3. 命令组合
- 可以连续使用多个命令
- 命令之间用换行分隔
- AI会自动处理命令依赖关系

### 4. 错误处理
- 如果命令参数不正确，AI会提示正确的用法
- 如果命令不支持，AI会建议替代方案
- 复杂命令会自动分解为多个步骤

## 示例场景

### 场景1：快速创建用户管理模块
```
/create-module User 用户管理模块
/create-entity User 用户实体，包含ID、用户名、邮箱、密码、状态
/create-controller User 用户管理API
/create-service User 用户业务逻辑
/create-mapper User 用户数据访问
/create-test UserService all
```

### 场景2：修复现有问题
```
/fix-performance UserQuery N+1查询问题
/fix-concurrency OrderCreate 订单创建并发冲突
/refactor-code UserService 优化事务管理
```

### 场景3：配置项目环境
```
/setup-database mysql 主从数据库配置
/create-config redis Redis缓存配置
/setup-exception business
```

### 场景4：完整模块开发流程
```
/create-module Payment 支付管理模块
/create-entity Payment 支付实体，包含订单ID、支付方式、金额、状态、时间
/create-controller Payment 支付管理API
/create-service Payment 支付业务逻辑
/create-mapper Payment 支付数据访问
/create-test PaymentService all
```

## 命令使用技巧

### 1. 参数优化
- 使用具体的业务描述，AI能更好地理解需求
- 包含关键功能点，帮助AI生成更准确的代码
- 指定技术细节，如数据库类型、缓存策略等

### 2. 命令组合
- 可以连续使用多个相关命令
- AI会自动处理命令之间的依赖关系
- 复杂任务可以分解为多个简单命令

### 3. 错误处理
- 如果命令参数不正确，AI会提示正确的用法
- 如果命令不支持，AI会建议替代方案
- 复杂命令会自动分解为多个步骤

### 4. 进度跟踪
- AI会显示命令执行进度和状态
- 可以随时询问当前进度
- 支持命令执行的中断和恢复

## 注意事项

1. **命令优先级**: 如果命令与普通文本冲突，以 `/` 开头的会被识别为命令
2. **参数验证**: AI会自动验证命令参数的有效性
3. **依赖处理**: AI会自动处理命令之间的依赖关系
4. **错误恢复**: 如果某个命令执行失败，AI会提供修复建议
5. **进度跟踪**: AI会显示命令执行进度和状态

## 扩展性

- 可以根据需要添加新的命令
- 支持命令别名和快捷方式
- 支持自定义命令组合
- 支持命令模板和预设

## 详细命令文档

每个命令的详细文档位于 `.cursor/commands/` 目录中，包含：
- 详细的命令格式和参数说明
- 完整的生成内容和功能描述
- 编码规范遵循说明
- 使用示例和注意事项
- 技术实现细节