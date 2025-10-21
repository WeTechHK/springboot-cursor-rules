# /init-structure 命令

## 命令格式
```bash
/init-structure [项目类型]
```

## 参数说明
- `[项目类型]`: 项目类型，支持以下选项：
  - `basic`: 基础Spring Boot项目
  - `api`: RESTful API项目
  - `web`: Web应用项目（保留类型，暂不支持）
  - `microservice`: 微服务项目（保留类型，暂不支持）

## 功能说明
初始化现有项目的目录结构，根据项目类型创建相应的基础架构和配置文件。

## 项目类型说明

### 1. basic - 基础Spring Boot项目
- 基础的Spring Boot项目结构
- 标准的MVC分层架构
- 基础的配置文件和依赖

### 2. api - RESTful API项目
- RESTful API专用结构
- API文档配置（Swagger/OpenAPI）
- 统一的响应格式
- API版本控制

### 3. web - Web应用项目（保留类型）
- 包含Web相关的配置和依赖
- 静态资源目录结构
- 视图模板配置
- Web安全配置
- **注意：此类型暂不支持，将在后续版本中提供**

### 4. microservice - 微服务项目（保留类型）
- 微服务架构结构
- 服务注册与发现配置
- 配置中心集成
- 分布式追踪配置
- **注意：此类型暂不支持，将在后续版本中提供**

## 生成内容

### 基础结构
```
src/
├── main/
│   ├── java/
│   │   └── com/example/app/
│   │       ├── Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       │   └── impl/
│   │       ├── dao/
│   │       │   ├── entity/
│   │       │   └── mapper/
│   │       ├── dto/
│   │       ├── vo/
│   │       │   ├── request/
│   │       │   └── response/
│   │       ├── exception/
│   │       ├── task/
│   │       ├── util/
│   │       └── security/
│   └── resources/
│       ├── application.yml
│       ├── application-dev.yml
│       ├── application-test.yml
│       ├── application-prod.yml
│       ├── static/
│       └── templates/
└── test/
    ├── java/
    │   └── com/example/app/
    │       ├── controller/
    │       ├── service/
    │       └── mapper/
    └── resources/
        ├── application-test.yml
        └── test-data/
```

### 配置文件
- `build.gradle` - 构建配置
- `application.yml` - 主配置
- 环境特定配置文件
- 日志配置文件

### 基础代码模板
- 主启动类
- 全局异常处理
- 统一响应包装类
- 基础配置类

## 使用示例

### 1. 初始化基础项目
```bash
/init-structure basic
```

### 2. 初始化API项目
```bash
/init-structure api
```

### 3. 保留类型示例（暂不支持）
```bash
# 以下命令暂不支持，将在后续版本中提供
# /init-structure web
# /init-structure microservice
```

## 项目特性
1. **标准化**: 遵循Spring Boot最佳实践
2. **可扩展**: 支持后续功能扩展
3. **规范**: 符合项目编码规范
4. **完整**: 包含完整的项目结构

## 注意事项
1. 会检查现有目录结构，避免重复创建
2. 会保留现有文件，仅添加缺失的结构
3. 根据项目类型调整配置和依赖
4. 自动配置相应的开发工具和插件
5. 目前仅支持 `basic` 和 `api` 两种项目类型
6. `web` 和 `microservice` 类型作为保留类型，将在后续版本中提供支持
