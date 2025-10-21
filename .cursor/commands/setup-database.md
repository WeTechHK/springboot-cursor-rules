# /setup-datasource 命令

## 命令格式
```bash
/setup-datasource [数据库类型] [配置参数]
```

## 参数说明
- `[数据库类型]`: 数据库类型，支持以下选项：
  - `mysql`: MySQL数据库
  - `postgresql`: PostgreSQL数据库
  - `h2`: H2内存数据库
  - `oracle`: Oracle数据库
- `[配置参数]`: 配置参数描述，如连接池配置、读写分离等

## 功能说明
配置数据源，包括：
- 数据源配置类
- 连接池配置
- 事务管理配置
- 多数据源配置
- 读写分离配置

## 生成内容

### 1. 数据源配置类 (DataSourceConfig)
- 使用`@Configuration`注解标记
- 数据源Bean配置
- 连接池配置
- 事务管理配置

### 2. 数据源配置
- 主数据源配置
- 从数据源配置（如需要）
- 连接池参数配置
- 数据库连接参数配置

### 3. 连接池配置
- HikariCP连接池配置
- 连接池大小配置
- 连接超时配置
- 连接验证配置

### 4. 事务管理配置
- 事务管理器配置
- 事务隔离级别配置
- 事务传播行为配置
- 事务回滚配置

### 5. 多数据源配置
- 主从数据源配置
- 读写分离配置
- 数据源路由配置
- 数据源监控配置

## 编码规范遵循

本命令严格遵循以下编码规范文件：
- **主要规范**：`03-code-file-convertions/spring-boot-configuration.mdc`

**详细规范**：请参考上述规范文件获取完整要求。

## 使用示例

### 1. 配置MySQL主从数据库
```bash
/setup-datasource mysql 主从数据库配置，包含读写分离
```

### 2. 配置PostgreSQL数据库
```bash
/setup-datasource postgresql PostgreSQL数据库配置，包含连接池、事务管理
```

### 3. 配置H2测试数据库
```bash
/setup-datasource h2 H2内存数据库配置，用于测试环境
```

## 数据库类型配置

### 1. mysql - MySQL数据库
- MySQL驱动配置
- MySQL连接参数
- MySQL连接池配置
- MySQL事务配置

### 2. postgresql - PostgreSQL数据库
- PostgreSQL驱动配置
- PostgreSQL连接参数
- PostgreSQL连接池配置
- PostgreSQL事务配置

### 3. h2 - H2内存数据库
- H2驱动配置
- H2内存数据库配置
- H2连接池配置
- H2事务配置

### 4. oracle - Oracle数据库
- Oracle驱动配置
- Oracle连接参数
- Oracle连接池配置
- Oracle事务配置

## 数据源特性
1. **高性能**: 使用HikariCP连接池
2. **可扩展**: 支持多数据源配置
3. **可监控**: 数据源监控和告警
4. **可配置**: 灵活的配置参数
5. **可维护**: 清晰的配置结构

## 技术实现
- **连接池**: 使用HikariCP连接池
- **事务**: 使用Spring事务管理
- **配置**: 使用Spring Boot配置
- **监控**: 集成数据源监控
- **路由**: 支持数据源路由

## 注意事项
1. 会根据数据库类型生成相应的配置
2. 自动配置连接池和事务管理
3. 包含完整的数据源配置
4. 遵循项目的编码规范和配置规范
5. 生成的代码可以直接运行和测试
