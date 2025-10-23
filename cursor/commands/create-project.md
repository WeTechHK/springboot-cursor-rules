# /create-project 命令

## 命令格式
```bash
/create-project [项目名称] [描述]
```

## 参数说明
- `[项目名称]`: 项目名称，用于生成项目目录和包名
- `[描述]`: 项目功能描述，用于生成项目文档和README

## 功能说明
创建新的Spring Boot项目，包括：
- 项目目录结构初始化
- 基础配置文件生成
- 依赖管理配置
- 项目文档生成
- 基础代码模板

## 生成内容
1. **项目结构**
   - 标准的Spring Boot项目目录结构
   - 符合规范的分层架构
   - 标准的包命名结构

2. **配置文件**
   - `build.gradle` - Gradle构建配置
   - `application.yml` - 主配置文件
   - `application-dev.yml` - 开发环境配置
   - `application-test.yml` - 测试环境配置
   - `application-prod.yml` - 生产环境配置

3. **基础代码**
   - `Application.java` - 主启动类
   - `GlobalExceptionHandler.java` - 全局异常处理
   - `CommonResponse.java` - 统一响应包装类
   - `CommonPageResponse.java` - 分页响应包装类

4. **项目文档**
   - `README.md` - 项目说明文档
   - `.gitignore` - Git忽略文件配置

## 使用示例

### 1. 创建学生管理系统
```bash
/create-project student-management 学生管理系统，包含用户管理、课程管理、成绩管理
```

### 2. 创建电商系统
```bash
/create-project ecommerce-system 电商系统，包含商品管理、订单管理、支付管理
```

### 3. 创建博客系统
```bash
/create-project blog-system 博客系统，包含文章管理、评论管理、用户管理
```

## 项目特性
1. **标准化结构**: 遵循Spring Boot最佳实践
2. **分层架构**: Controller、Service、Mapper分层设计
3. **配置管理**: 多环境配置支持
4. **异常处理**: 全局异常处理机制
5. **统一响应**: 标准化API响应格式
6. **代码规范**: 符合项目编码规范

## 技术栈
- Spring Boot 3.x
- MyBatis (注解模式)
- MySQL
- Gradle
- JUnit 5
- Lombok
- Hutool

## 注意事项
1. 项目名称会转换为包名，自动处理命名规范
2. 会自动创建基础的目录结构和配置文件
3. 生成的项目可以直接运行和开发
4. 遵循项目的编码规范和架构设计
