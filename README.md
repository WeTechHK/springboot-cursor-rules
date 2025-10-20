# Spring Boot Cursor Rules

[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![GitHub stars](https://img.shields.io/github/stars/WeTechHK/srpingboot-cursor-rules.svg)](https://github.com/WeTechHK/srpingboot-cursor-rules/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/WeTechHK/srpingboot-cursor-rules.svg)](https://github.com/WeTechHK/srpingboot-cursor-rules/network)

> **项目说明**：这是一个通用、实用的 Spring Boot 开发规范体系，专为 Cursor AI 和团队开发设计。遵循 80/20 原则，只保留最核心、最常用、最标准的开发规范。

## 核心特性

###  专为 AI 设计
- 针对 Cursor AI 优化的规范体系
- AI 可自动读取并应用规则
- 减少手动编码，提高开发效率

###  分层组织
- **00-project-structure**：项目结构和技术栈
- **01-design-standards**：API 设计、错误码、设计模式、表结构设计
- **02-coding-standards**：编码实践、代码风格、命名规范
- **03-code-file-convertions**：具体代码文件约定


## 快速开始

### 1. 安装配置

克隆项目到本地
```bash
git clone git@github.com:WeTechHK/srpingboot-cursor-rules.git
```

进入项目目录
```bash
cd srpingboot-cursor-rules
```

在你的 Spring Boot 项目中创建规则目录
```bash
mkdir -p /path/to/your/springboot-project/.cursor/rules
```

复制所有规则文件（保持目录结构）
```bash
rsync -av --include '*/' --include '*.mdc' --exclude '*' \
  00-project-structure 01-design-standards 02-coding-standards 03-code-file-convertions \
  /path/to/your/springboot-project/.cursor/rules/
```

### 2. 启用 Cursor AI

1. 在 Cursor 中打开你的 Spring Boot 项目
2. 打开 Cursor Settings（设置）
3. 找到 Rules 设置
4. 开启 "Auto Attached" 选项
5. Cursor 会自动读取 `.cursor/rules` 目录下的规则文件

### 3. 开始使用

```bash
# 在 Cursor 中与 AI 对话
开发者："创建一个用户管理的 Controller，包含增删改查功能"
AI：我会参考 .cursor/rules 文件中的指导原则为您创建用户管理 Controller...

开发者："请参考 @02-coding-standards/coding-standards.mdc 的异常处理规范，重新生成这个 Service"
AI：好的，我会参考编码实践规范来生成代码...
```

## 常见问题

遇到问题？查看 [FAQ.md](FAQ.md) 获取详细解答，包括：
-  基础入门问题
-  配置与使用问题  
-  AI 编程协作问题
-  代码质量与安全问题
-  Spring Boot 技术问题
-  API 设计与错误处理
-  数据持久化与表结构设计
-  团队协作问题

## 许可证

本项目采用 [Apache License 2.0](LICENSE)。

## 相关链接

- **GitHub 仓库**：[WeTechHK/srpingboot-cursor-rules](https://github.com/WeTechHK/srpingboot-cursor-rules)
- **问题反馈**：[Issues](https://github.com/WeTechHK/srpingboot-cursor-rules/issues)
- **功能请求**：[Feature Requests](https://github.com/WeTechHK/srpingboot-cursor-rules/issues/new?template=feature_request.md)


