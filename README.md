# Spring Boot Cursor Rules

[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub stars](https://img.shields.io/github/stars/WeTechHK/springboot-cursor-rules.svg)](https://github.com/WeTechHK/springboot-cursor-rules/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/WeTechHK/springboot-cursor-rules.svg)](https://github.com/WeTechHK/springboot-cursor-rules/network)

## 项目简介

这是一个专为Cursor AI设计的Spring Boot开发规范体系，包含27个AI交互命令和37个编码规范文件，让AI能够自动生成符合企业级标准的Spring Boot代码。

通过自然语言沟通或简单命令，AI就能理解你的需求并生成高质量的Spring Boot代码，包括项目结构、业务模块、测试代码等完整的企业级应用。

## 核心特性

### 自然语言优先
- **零学习成本**：直接与AI对话描述需求，无需学习复杂命令
- **智能理解**：AI能理解业务场景，自动生成对应的技术实现
- **完整覆盖**：从项目创建到代码优化，覆盖Spring Boot开发全流程

### 企业级标准
- **规范一致**：37个规范文件确保代码质量和一致性
- **最佳实践**：基于Spring Boot最佳实践，生成可维护、可扩展的代码
- **分层架构**：支持完整的MVC分层架构和微服务架构

### 智能代码生成
- **自动应用规范**：AI自动应用编码规范，确保代码质量
- **批量生成**：一次对话可生成完整的业务模块
- **测试覆盖**：自动生成单元测试和集成测试代码

## 快速开始

### 1. 安装配置

```bash
# 克隆项目
git clone https://github.com/WeTechHK/springboot-cursor-rules.git
cd springboot-cursor-rules

# 复制到你的项目
mkdir -p /path/to/your/project/.cursor
cp -r cursor/* /path/to/your/project/.cursor/
```

### 2. 开始使用

#### 自然语言沟通（推荐）

直接与AI对话，描述你的需求：

```bash
# 创建新项目
"创建一个学生管理系统的Spring Boot项目，包含用户管理、课程管理、成绩管理等模块"

# 开发新模块
"在现有项目中新增课程管理模块，包含课程信息管理、课程安排、选课等功能"

# 创建具体功能
"创建课程服务层，包含课程的增删改查、课程状态管理、课程统计等功能"

# 重构优化
"重构课程管理模块，优化性能，改进代码结构，增加新的业务功能"
```

#### AI交互命令（高级用户）

```bash
# 项目管理
/create-project ecommerce 电商系统
/init-structure api

# 模块开发
/create-module User 用户管理

# 代码生成
/create-controller User 用户API
/create-service User 用户服务
/create-entity User 用户实体

# 测试配置
/create-test UserService all
/setup-exception business
```

## 贡献指南

我们欢迎社区贡献！请按以下步骤参与：

1. **Fork 项目**：点击右上角的 Fork 按钮
2. **创建分支**：`git checkout -b feature/your-feature-name`
3. **提交变更**：`git commit -m 'Add some feature'`
4. **推送分支**：`git push origin feature/your-feature-name`
5. **创建PR**：在GitHub上创建Pull Request

### 贡献类型

- **新功能**：添加新的AI交互命令或规范文件
- **文档改进**：完善文档说明和示例
- **Bug修复**：修复现有功能的问题
- **代码优化**：改进代码质量和性能

### 开发规范

- 遵循现有的代码风格和命名规范
- 添加必要的测试用例
- 更新相关文档
- 确保所有测试通过