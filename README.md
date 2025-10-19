# Spring Boot Cursor Rules

> **项目说明**：这是一个精简、实用的 Spring Boot 开发规范体系，专为 Cursor AI 和团队开发设计。遵循 80/20 原则，只保留最核心、最常用的开发规范。

## 📁 文件结构

```
cursor-rules/
├── .cursorrules                    # 核心规则（AI主要参考）
├── 01-代码规范.md                  # 代码规范（命名、结构、风格、编码规范）
├── 02-Spring-Boot规范.md           # Spring Boot开发规范
├── 03-API设计规范.md               # API设计规范
├── 04-代码质量规范.md              # 代码质量和最佳实践
├── 代码模板/                       # 代码模板
├── 00-introduction.md              # 项目介绍
├── 模块选择指南.md                 # 模块选择指南
├── faq.md                          # 常见问题
└── changelog.md                    # 版本历史
```

## 📋 核心文件内容

### `.cursorrules` - 核心规则
Cursor AI 的主要参考文件，包含项目概述、技术栈、开发原则、代码生成规则等。

### `01-代码规范.md` - 代码规范
- 代码结构规范（包结构、类组织、分层架构）
- 命名规范（包命名、类命名、方法命名、变量命名）
- 代码风格规范（格式化、注释、导入语句、代码布局）
- 编码规范（异常处理、日志记录、性能优化、安全编码）
- 质量规范（代码审查、测试要求、文档规范）

### `02-Spring-Boot规范.md` - Spring Boot规范
Spring Boot 开发规范，包含注解使用、依赖注入、配置管理、异常处理、事务管理等。

### `03-API设计规范.md` - API设计规范
API 接口设计规范，包含 RESTful 设计原则、URL 设计、HTTP 方法使用、状态码规范等。

### `04-代码质量规范.md` - 代码质量规范
代码质量和最佳实践，包含设计原则、代码组织、质量检查、性能优化、安全编码等。

### `代码模板/` - 代码模板
提供常用的代码模板，包括 Controller、Service、Entity、DTO 等模板文件。

## 🚀 使用方法

### 配置步骤

#### 1. 项目配置
```bash
# 1. 克隆或下载项目到本地
git clone <repository-url>
cd springboot-cursor-rules

# 2. 将 .cursorrules 文件复制到你的 Spring Boot 项目根目录
cp .cursorrules /path/to/your/springboot-project/

# 3. 将代码模板复制到项目中使用
cp -r 代码模板/ /path/to/your/springboot-project/templates/
```

#### 2. IDE 配置
```bash
# 配置 Cursor AI
# 1. 确保 .cursorrules 文件在项目根目录
# 2. 重启 Cursor IDE
# 3. 在 Cursor 中打开项目，AI 会自动识别规则

# 配置其他 IDE（可选）
# 1. 导入代码格式化规则
# 2. 配置代码检查工具（Checkstyle、SpotBugs）
# 3. 设置代码模板
```

### 使用步骤

#### 开发者使用
1. **阅读规范文件**：根据开发任务选择对应的规范文件
   - 新项目：先阅读 `01-代码规范.md`
   - Spring Boot 开发：参考 `02-Spring-Boot规范.md`
   - API 设计：参考 `03-API设计规范.md`
   - 代码质量：参考 `04-代码质量规范.md`

2. **使用代码模板**：
   ```bash
   # 复制模板到项目
   cp 代码模板/controller-template.java src/main/java/com/example/controller/
   cp 代码模板/service-impl-template.java src/main/java/com/example/service/impl/
   ```

3. **遵循检查清单**：使用文件中的检查清单确保代码质量

#### Cursor AI 使用
1. **AI 自动识别**：Cursor 会自动读取 `.cursorrules` 文件
2. **详细规范**：需要详细规范时，参考对应的 `.md` 文件
3. **代码生成**：AI 会根据规范生成符合标准的代码
4. **代码审查**：AI 会按照规范检查生成的代码

#### 团队使用
1. **统一配置**：所有团队成员使用相同的配置文件
2. **代码审查**：使用检查清单进行代码审查
3. **持续改进**：根据项目需要更新规范

## 🤝 贡献指南

### 如何贡献
1. **发现问题**：在 `faq.md` 中查看是否已有解答
2. **提出建议**：通过 Issue 或 PR 提出改进建议
3. **提交代码**：遵循现有的代码风格和规范
4. **更新文档**：确保文档与代码同步更新

### 贡献流程
1. Fork 项目
2. 创建功能分支
3. 提交更改
4. 创建 Pull Request
5. 等待代码审查

---

**版本**：v3.0.0  
**最后更新**：2024年1月
