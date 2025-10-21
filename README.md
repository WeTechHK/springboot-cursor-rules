# Spring Boot Cursor Rules

[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub stars](https://img.shields.io/github/stars/WeTechHK/springboot-cursor-rules.svg)](https://github.com/WeTechHK/springboot-cursor-rules/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/WeTechHK/springboot-cursor-rules.svg)](https://github.com/WeTechHK/springboot-cursor-rules/network)

> **项目说明**：这是一个专为Cursor AI设计的Spring Boot开发规范体系，包含27个AI交互命令和完整的编码规范，让AI能够自动生成符合企业级标准的Spring Boot代码。

## 核心特性

### 专为AI设计
- **27个预定义命令**：覆盖从项目创建到代码优化的完整开发流程
- **智能代码生成**：AI自动应用规范，生成符合企业级标准的代码
- **零学习成本**：通过简单命令即可获得高质量代码

### 两项核心内容

#### 1. AI交互命令系统（27个命令）
- **项目管理**：创建项目、初始化结构
- **模块开发**：创建完整业务模块
- **代码生成**：控制器、服务、实体、DTO、工具类等
- **测试支持**：单元测试、集成测试
- **配置管理**：数据库、安全、异常处理
- **代码优化**：重构、性能修复、代码检查

#### 2. 编码规范体系（25个规范文件）
- **项目结构**：标准化的Spring Boot项目组织
- **设计标准**：API设计、错误码、表结构设计
- **编码实践**：代码风格、命名规范、最佳实践
- **文件约定**：具体代码文件的编写标准

## 快速开始

### 1. 安装配置

#### 步骤1：克隆项目
```bash
git clone https://github.com/WeTechHK/springboot-cursor-rules.git
cd springboot-cursor-rules
```

#### 步骤2：复制到你的项目
```bash
# 只需将 .cursor 整个目录复制到你的 Spring Boot 项目根目录
cp -r .cursor /path/to/your/project/
```

#### 步骤3：启用Cursor AI
1. 在Cursor中打开你的Spring Boot项目
2. 打开设置（Settings）
3. 找到"Rules"选项
4. 开启"Auto Attached"
5. Cursor会自动加载`.cursor/rules`和`.cursor/commands`目录

### 2. 开始使用

#### 方式一：AI交互命令（推荐）

**命令格式：** `/命令名 [参数1] [参数2] ...`

**3分钟快速体验：**

```bash
# 1. 创建用户管理模块（完整模块）
/create-module User 用户管理模块，包含注册、登录、权限管理

# 2. 创建商品实体
/create-entity Product 商品实体，包含ID、名称、价格、库存、分类、状态

# 3. 创建订单控制器
/create-controller Order 订单管理API，包含创建、查询、支付、取消

# 4. 配置全局异常处理
/setup-exception business
```

**常用命令速查：**

| 功能分类 | 命令示例 | 说明 |
|---------|---------|------|
| **项目管理** | `/create-project ecommerce 电商系统` | 创建完整项目结构 |
| **模块开发** | `/create-module User 用户管理` | 创建完整业务模块 |
| **代码生成** | `/create-controller User 用户API` | 创建控制器、服务、实体等 |
| **测试** | `/create-test UserService all` | 创建单元测试和集成测试 |
| **配置** | `/setup-exception business` | 配置异常处理、数据库等 |
| **优化** | `/fix-performance UserQuery N+1查询` | 性能优化、代码重构 |

#### 方式二：传统AI对话

```bash
# 新项目开发场景
开发者："创建一个学生管理系统的Spring Boot项目，包含用户管理、课程管理、成绩管理等模块"
AI：已完成需求分析，根据00-project-structure/project-structure.mdc和tech-stack.mdc创建完整的Spring Boot项目结构

计划：
- 开发主启动类
- 开发配置类
- 开发Controller层
- 开发Service层
- 开发Mapper层
- 开发实体类

请确认：是否需要集成Spring Security和Redis缓存？

# 新模块开发场景
开发者："在现有项目中新增课程管理模块，包含课程信息管理、课程安排、选课等功能"
AI：已完成模块分析，根据03-code-file-convertions/中的各类规范生成完整的课程管理模块

计划：
- 开发CourseController
- 开发CourseService接口和实现
- 开发CourseMapper
- 开发CourseEntity
- 开发Request/Response对象

我将开始开发课程管理模块。

# 重构场景
开发者："重构课程管理模块，优化性能，改进代码结构，增加新的业务功能"
AI：已完成模块分析，根据02-coding-standards/coding-standards.mdc制定课程管理模块重构方案

计划：
- 重构代码结构
- 优化性能问题
- 重构异常处理
- 重构日志记录
- 增加新功能

我将开始重构课程管理模块。
```

### 3. 完整文档

- **[COMMAND-REFERENCE.md](COMMAND-REFERENCE.md)** - 27个AI交互命令详细说明
- **[FAQ.md](FAQ.md)** - 常见问题解答（35个问题）
- **[USER-PROMPT-CASE.md](USER-PROMPT-CASE.md)** - 11个典型AI对话使用场景
- **[AI-PROMPT.mdc](.cursor/rules/AI-PROMPT.mdc)** - AI交互规则和角色定位

### 4. 命令分类统计

| 分类 | 命令数量 | 说明 |
|------|---------|------|
| **项目管理** | 2个 | 创建项目、初始化结构 |
| **模块开发** | 1个 | 创建完整业务模块 |
| **代码生成** | 9个 | 控制器、服务、实体、DTO、任务、工具、常量、枚举 |
| **请求响应** | 2个 | 请求对象、响应对象 |
| **异常处理** | 2个 | 业务异常、全局异常处理 |
| **测试** | 2个 | 单元测试、集成测试 |
| **配置** | 3个 | 配置文件、数据库、安全 |
| **重构** | 2个 | 代码结构、命名规范 |
| **问题修复** | 2个 | 性能问题、并发问题 |
| **工具** | 2个 | 代码格式化、代码检查 |
| **总计** | **27个** | **完整覆盖Spring Boot开发流程** |

### 5. 规范文件统计

| 分类 | 文件数量 | 说明 |
|------|---------|------|
| **项目结构** | 2个 | 项目组织、技术栈 |
| **设计标准** | 4个 | API设计、错误码、设计模式、表结构 |
| **编码套路** | 7个 | 编码实践、代码风格、命名规范等 |
| **文件约定** | 12个 | 具体代码文件的编写标准 |
| **AI交互** | 1个 | AI角色定位和交互规则 |
| **总计** | **26个** | **完整的企业级开发规范** |

## 典型使用场景

### 场景1：新项目开发
```bash
# AI交互命令方式
/create-project student-management 学生管理系统，包含用户管理、课程管理、成绩管理

# 传统对话方式
开发者："创建一个学生管理系统的Spring Boot项目，包含用户管理、课程管理、成绩管理等模块"
AI：已完成需求分析，根据规范创建完整的Spring Boot项目结构...
```

### 场景2：新模块开发
```bash
# AI交互命令方式
/create-module Course 课程管理模块，包含课程信息管理、课程安排、选课功能

# 传统对话方式
开发者："在现有项目中新增课程管理模块，包含课程信息管理、课程安排、选课等功能"
AI：已完成模块分析，根据规范生成完整的课程管理模块...
```

### 场景3：代码文件开发
```bash
# AI交互命令方式
/create-service Course 课程服务层，包含增删改查、状态管理、统计功能

# 传统对话方式
开发者："创建课程服务层，包含课程的增删改查、课程状态管理、课程统计等功能"
AI：已完成服务层设计，根据规范生成CourseService...
```

### 场景4：问题修复与重构
```bash
# AI交互命令方式
/fix-performance CourseQuery N+1查询问题
/refactor-code CourseService 优化事务管理和异常处理

# 传统对话方式
开发者："重构课程管理模块，优化性能，改进代码结构，增加新的业务功能"
AI：已完成模块分析，根据编码规范制定重构方案...
```

## 最佳实践

### 命令使用技巧
- **具体描述**：使用详细的业务描述，AI能更好地理解需求
- **关键功能**：包含核心功能点，帮助AI生成准确代码
- **技术细节**：指定数据库类型、缓存策略等技术要求

### 开发流程建议
1. **项目初始化**：使用`/create-project`创建项目结构
2. **模块开发**：使用`/create-module`创建完整业务模块
3. **代码生成**：使用具体命令生成控制器、服务、实体等
4. **测试编写**：使用测试命令创建单元测试和集成测试
5. **问题修复**：使用优化命令修复性能和并发问题

## 技术栈支持

- **Spring Boot 3.x**
- **MyBatis（注解模式）**
- **MySQL**
- **RESTful API**
- **JUnit 5 + Mockito**
- **Spring Security**
- **Redis（可选）**

## 贡献指南

1. Fork 项目仓库
2. 创建功能分支
3. 提交变更
4. 发起 Pull Request
5. 确保文档与代码同步更新

## 许可证

本项目采用 [Apache License 2.0](LICENSE) 开源协议。

## 相关链接

- **GitHub 仓库**：[WeTechHK/springboot-cursor-rules](https://github.com/WeTechHK/springboot-cursor-rules)
- **问题反馈**：[Issues](https://github.com/WeTechHK/springboot-cursor-rules/issues)
- **功能请求**：[Feature Requests](https://github.com/WeTechHK/springboot-cursor-rules/issues/new?template=feature_request.md)

---

**让AI成为你的Spring Boot开发助手，提升开发效率，保证代码质量！**