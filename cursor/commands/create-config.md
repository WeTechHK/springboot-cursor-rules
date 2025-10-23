# /create-config 命令

## 命令格式
```bash
/create-config [配置类型] [配置描述]
```

## 参数说明
- `[配置类型]`: 配置类型，支持以下选项：
  - `database`: 数据库配置
  - `redis`: Redis配置  
  - `security`: 安全配置
  - `logging`: 日志配置
  - `custom`: 自定义配置
  - `full`: 完整项目配置
- `[配置描述]`: 配置的详细描述

## 功能说明
根据指定的配置类型和描述，自动生成符合Spring Boot规范的配置文件，包括：
- application.yml 主配置文件
- application-dev.yml 开发环境配置
- application-test.yml 测试环境配置  
- application-prod.yml 生产环境配置
- 自定义配置类（如需要）

## 配置规范
遵循 `.cursor/rules/03-code-file-convertions/spring-boot-configuration.mdc` 规范：
- 使用 YAML 格式，支持层次结构
- 按功能模块分组配置
- 使用环境变量覆盖敏感配置
- 提供合理的默认值
- 使用 Spring Profiles 切换环境
- 使用连接池配置数据库
- 配置合适的连接池参数
- 设置事务隔离级别
- 配置 ORM 相关参数
- 使用日志配置文件
- 按级别和包名配置日志输出
- 设置日志文件滚动策略
- 配置不同环境的日志级别

## 使用示例

### 1. 创建数据库配置
```bash
/create-config database MySQL数据库配置，包含连接池、事务管理
```

### 2. 创建Redis配置
```bash
/create-config redis Redis缓存配置，包含连接池、序列化配置
```

### 3. 创建安全配置
```bash
/create-config security Spring Security配置，包含JWT认证、权限控制
```

### 4. 创建日志配置
```bash
/create-config logging 日志配置，包含分级输出、文件滚动、性能监控
```

### 5. 创建完整项目配置
```bash
/create-config full 完整项目配置，包含数据库、Redis、安全、日志等所有配置
```

## 生成内容
根据配置类型，命令会生成以下文件：

### 数据库配置 (database)
- `src/main/resources/application.yml` - 主配置文件
- `src/main/resources/application-dev.yml` - 开发环境配置
- `src/main/resources/application-test.yml` - 测试环境配置
- `src/main/resources/application-prod.yml` - 生产环境配置
- `src/main/java/com/example/app/config/DatabaseConfig.java` - 数据库配置类

### Redis配置 (redis)
- 在现有配置文件中添加Redis相关配置
- `src/main/java/com/example/app/config/RedisConfig.java` - Redis配置类

### 安全配置 (security)
- 在现有配置文件中添加安全相关配置
- `src/main/java/com/example/app/config/SecurityConfig.java` - 安全配置类

### 日志配置 (logging)
- 在现有配置文件中添加日志相关配置
- `src/main/resources/logback-spring.xml` - 日志配置文件

### 完整项目配置 (full)
- 生成所有上述配置文件和配置类
- 包含完整的项目配置结构

## 配置特点
1. **环境隔离**: 支持dev、test、prod多环境配置
2. **安全性**: 敏感信息使用环境变量配置
3. **性能优化**: 合理的连接池和缓存配置
4. **可维护性**: 清晰的配置结构和注释
5. **标准化**: 遵循Spring Boot最佳实践

## 注意事项
1. 命令会自动检测现有配置文件，避免重复生成
2. 会保留现有配置，仅添加缺失的配置项
3. 生成前会询问是否覆盖现有配置
4. 支持增量配置，可以多次执行添加不同配置类型

## 扩展性
- 支持自定义配置模板
- 支持配置验证和检查
- 支持配置文档生成
- 支持配置热更新
