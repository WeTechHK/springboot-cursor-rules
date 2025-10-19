# Spring Boot Cursor Rules

[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub stars](https://img.shields.io/github/stars/WeTechHK/srpingboot-cursor-rules.svg)](https://github.com/WeTechHK/srpingboot-cursor-rules/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/WeTechHK/srpingboot-cursor-rules.svg)](https://github.com/WeTechHK/srpingboot-cursor-rules/network)

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
提供参考模板文件，主要用于 AI 学习和参考，开发者无需手动复制使用。

## 🚀 使用方法

### 配置步骤

#### 1. 项目配置
```bash
# 1. 克隆或下载项目到本地
git clone git@github.com:WeTechHK/srpingboot-cursor-rules.git
cd srpingboot-cursor-rules

# 2. 在你的 Spring Boot 项目根目录创建 .cursor/rules 目录
mkdir -p /path/to/your/springboot-project/.cursor/rules

# 3. 将 .cursorrules 文件复制到 .cursor/rules 目录
cp .cursorrules /path/to/your/springboot-project/.cursor/rules/

# 4. 将详细规范文件复制到 .cursor/rules 目录（可选，用于 AI 深度参考）
cp 01-代码规范.md /path/to/your/springboot-project/.cursor/rules/
cp 02-Spring-Boot规范.md /path/to/your/springboot-project/.cursor/rules/
cp 03-API设计规范.md /path/to/your/springboot-project/.cursor/rules/
cp 04-代码质量规范.md /path/to/your/springboot-project/.cursor/rules/
```

#### 2. 开启 Auto Attached
```bash
# 在 Cursor 中配置
# 1. 在 Cursor 中打开你的 Spring Boot 项目
# 2. 打开 Cursor Settings（设置）
# 3. 找到 Rules 设置
# 4. 开启 "Auto Attached" 选项
# 5. Cursor 会自动读取 .cursor/rules 目录下的规则文件
```

### 使用步骤

#### 开发者使用
1. **AI 辅助开发**：与 Cursor AI 对话，描述你的需求
   - AI 会参考 `.cursorrules` 文件中的指导原则来生成代码
   - 无需手动复制模板或编写代码，AI 会根据项目规范处理细节

2. **智能代码生成示例**：
   ```bash
   # 在 Cursor 中与 AI 对话
   开发者："创建一个用户管理的 Controller，包含增删改查功能"
   # AI 会参考 .cursorrules 文件中的规范，生成符合项目标准的代码
   ```

3. **引用详细规范**：需要更详细的规范时，可以引导 AI 查看 `.md` 文件

#### Cursor AI 工作机制
1. **自动读取规则**：开启 Auto Attached 后，Cursor 会自动读取 `.cursor/rules` 目录下的规则文件
2. **提供上下文**：规则文件为 AI 提供项目特定的上下文和指导原则
3. **智能代码生成**：AI 参考规则文件中的指导原则来生成代码
4. **访问其他文件**：AI 可以访问 `.cursor/rules` 目录下的所有 `.md` 文件

#### 团队使用
1. **统一规范文件**：所有团队成员将规则文件放在 `.cursor/rules` 目录下
2. **开启 Auto Attached**：每个团队成员都需要开启 Auto Attached 选项
3. **一致的代码风格**：AI 参考相同的指导原则，确保团队代码风格一致

## 🤖 AI 使用示例

### 基本使用流程
1. **描述需求**：在 Cursor 中与 AI 对话，描述你想要实现的功能
2. **AI 参考规则**：AI 会参考 `.cursorrules` 文件中的指导原则
3. **生成代码**：AI 根据指导原则生成符合项目规范的代码
4. **迭代优化**：根据需要继续与 AI 对话，优化生成的代码

### 示例对话
```
开发者：创建一个用户管理的 Controller，包含增删改查功能
AI：我会参考 .cursorrules 文件中的指导原则为您创建用户管理 Controller...

开发者：这个 Service 层的异常处理是否符合规范？
AI：让我检查一下异常处理部分...

开发者：请参考 @01-代码规范.md 中的异常处理规范，重新生成这个 Service
AI：好的，我会参考 01-代码规范.md 中的详细异常处理规范来重新生成代码...
```

### 优势
- ✅ **零学习成本**：无需记忆复杂的规范细节
- ✅ **AI 辅助开发**：AI 参考 `.cursorrules` 文件中的指导原则来生成代码
- ✅ **智能代码生成**：AI 根据项目规范自动生成符合标准的代码
- ✅ **团队一致性**：通过共享 `.cursorrules` 文件，确保团队代码风格统一

## 📚 如何使用详细规范文件

### 规范文件的作用
- **`.cursorrules`**：为 AI 提供项目特定的上下文和指导原则
- **`.md` 文件**：详细的规范文档，用于特定场景的深度参考

### 使用方式
1. **放置文件**：将所有规则文件放在 `.cursor/rules` 目录下
2. **开启 Auto Attached**：在 Cursor 设置中开启 Auto Attached 选项
3. **自动读取**：Cursor 会自动读取 `.cursor/rules` 目录下的所有规则文件
4. **主动引用**：通过 `@文件名` 的方式，可以引导 AI 参考特定的 `.md` 文件

### 引导 AI 使用详细规范的示例
```
# 使用 @ 符号引用特定规范文件
开发者：请参考 @02-Spring-Boot规范.md 中的事务管理规范，优化这个 Service 方法
开发者：根据 @03-API设计规范.md 重新设计这个 REST API
开发者：按照 @04-代码质量规范.md 中的性能优化规范，优化这个查询方法
```

### 规范文件选择指南
- **代码结构问题** → 参考 `01-代码规范.md`
- **Spring Boot 特性** → 参考 `02-Spring-Boot规范.md`
- **API 设计问题** → 参考 `03-API设计规范.md`
- **代码质量问题** → 参考 `04-代码质量规范.md`

### 重要说明
- **文件位置**：所有规则文件必须放在 `.cursor/rules` 目录下
- **开启 Auto Attached**：必须在 Cursor 设置中开启 Auto Attached 选项
- **自动读取**：开启后，Cursor 会自动读取 `.cursor/rules` 目录下的所有文件
- **版本控制**：建议将 `.cursor/rules` 目录加入 Git 版本控制，方便团队共享

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

## 📄 许可证

本项目采用 [Apache License 2.0](LICENSE)。

## 🔗 相关链接

- **GitHub 仓库**：[WeTechHK/srpingboot-cursor-rules](https://github.com/WeTechHK/srpingboot-cursor-rules)
- **问题反馈**：[Issues](https://github.com/WeTechHK/srpingboot-cursor-rules/issues)
- **功能请求**：[Feature Requests](https://github.com/WeTechHK/srpingboot-cursor-rules/issues/new?template=feature_request.md)

---

**版本**：v3.0.0  
**最后更新**：2024年1月
