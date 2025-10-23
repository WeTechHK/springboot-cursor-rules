# /create-config 命令

## 命令格式
```bash
/create-config [一段描述性的话]
```

## 功能说明
创建Spring Boot配置类，遵循Spring Boot最佳实践，包括外部化配置、环境配置、配置验证和配置管理。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取配置类型、配置需求、环境要求
- **识别配置类型**：判断是数据库配置、Redis配置、安全配置、日志配置等
- **推断配置复杂度**：评估配置的复杂度和实现难度

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的配置文档、环境配置文档
- **内容匹配**：基于描述内容匹配相关配置文档
- **信息提取**：从文档中提取配置规范、环境变量、配置项定义等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的配置风格、环境设置
- **模块识别**：识别相关模块和配置依赖
- **规范推断**：推断项目的配置管理规范

### 4. 配置规则匹配
- **规范匹配**：根据需求匹配对应的配置编码规范
- **环境适配**：适配开发、测试、生产环境配置
- **最佳实践**：应用Spring Boot配置最佳实践

### 5. 主动询问与确认
- **需求澄清**：对模糊描述进行主动询问
- **技术选型**：确认配置技术选型
- **环境确认**：确认目标环境配置
- **参数确认**：确认具体配置参数

## 使用示例

### 示例1：简单描述
```bash
# 用户输入
/create-config 数据库配置

# AI响应
AI: 已解析您的描述"数据库配置"，并发现以下相关文档：

**发现的设计文档：**
- `docs/database-config.md` - 数据库配置文档
- `docs/spring-boot-standards.md` - Spring Boot标准文档
- `docs/environment-config.md` - 环境配置文档

基于这些文档，DatabaseConfig将包含以下配置内容：

**配置项规划：**
- 数据源配置（HikariCP连接池）
- 数据库连接参数
- 事务管理配置
- 多环境配置支持

**需要确认的细节：**
1. 数据库类型？（MySQL、PostgreSQL等）
2. 连接池配置参数？
3. 是否需要读写分离？
4. 环境配置要求？

请提供详细信息，或者确认以上规划是否符合您的需求？
```

### 示例2：详细描述
```bash
# 用户输入
/create-config 完整项目配置，包含数据库、Redis、安全、日志等所有配置

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/complete-config.md` - 完整配置文档
- `docs/database-config.md` - 数据库配置文档
- `docs/redis-config.md` - Redis配置文档
- `docs/security-config.md` - 安全配置文档
- `docs/logging-config.md` - 日志配置文档

基于这些文档，将创建以下完整配置：

**配置模块规划：**
- 数据库配置（MySQL + HikariCP）
- Redis配置（连接池 + 序列化）
- 安全配置（JWT + 密码加密）
- 日志配置（Logback + 分级输出）
- 监控配置（Actuator + 健康检查）

**推断的配置文件：**
- application.yml - 主配置文件
- application-dev.yml - 开发环境配置
- application-test.yml - 测试环境配置
- application-prod.yml - 生产环境配置
- DatabaseConfig.java - 数据库配置类
- RedisConfig.java - Redis配置类
- SecurityConfig.java - 安全配置类

**需要确认的信息：**
基于您的描述，我将智能判断是否需要确认信息：

- **如果描述完整**：直接开始生成配置类
- **如果缺少连接信息**：询问具体的数据库和Redis连接参数
- **如果缺少安全配置**：询问具体的认证和授权配置
- **如果缺少日志配置**：询问具体的日志级别和输出配置
- **如果描述模糊**：询问关键配置细节

**当前状态：** 基于您的描述，我将智能推断配置参数和连接信息，如有疑问会主动询问。
```

## 生成内容

### 1. 配置文件
- `src/main/resources/application.yml` - 主配置文件
- `src/main/resources/application-dev.yml` - 开发环境配置
- `src/main/resources/application-test.yml` - 测试环境配置
- `src/main/resources/application-prod.yml` - 生产环境配置

### 2. 配置类
- `src/main/java/com/example/app/config/DatabaseConfig.java` - 数据库配置类
- `src/main/java/com/example/app/config/RedisConfig.java` - Redis配置类
- `src/main/java/com/example/app/config/SecurityConfig.java` - 安全配置类
- `src/main/java/com/example/app/config/LoggingConfig.java` - 日志配置类

### 3. 配置规范
遵循 `.cursor/rules/03-code-file-convertions/spring-boot-configuration.mdc` 规范：
- 使用 YAML 格式，支持层次结构
- 按功能模块分组配置
- 使用环境变量覆盖敏感配置
- 支持配置验证和类型安全
- 遵循Spring Boot配置最佳实践

## 技术特性

### 1. 外部化配置
- 支持多环境配置
- 环境变量覆盖
- 配置优先级管理
- 配置热更新支持

### 2. 配置验证
- 使用 `@ConfigurationProperties` 进行类型安全绑定
- 使用 `@Valid` 进行配置验证
- 提供配置错误提示

### 3. 配置管理
- 配置类自动装配
- 配置条件化加载
- 配置文档生成
- 配置监控支持

## 进一步阅读
- 配置规范：`03-code-file-convertions/spring-boot-configuration.mdc`
- 项目结构：`00-project-structure/project-structure.mdc`
- 技术栈：`00-project-structure/tech-stack.mdc`