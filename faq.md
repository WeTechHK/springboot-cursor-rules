# 常见问题解答 (FAQ)

## 1. 基础入门

### Q1: 什么是 Cursor Rules？
A: Cursor Rules 是一套为 AI 辅助编程设计的开发规范体系，旨在确保 AI 生成的代码符合项目标准，提高开发效率和代码质量。

### Q2: 为什么需要 Cursor Rules？
A: 在 AI 辅助编程时代，需要建立标准化的开发规范来确保：
- 代码一致性和可维护性
- AI 生成代码的质量
- 团队协作效率
- 知识传承和最佳实践固化

### Q3: 哪些项目适合使用 Cursor Rules？
A: 主要适用于：
- 基于 Spring Boot 的企业级应用
- Web 应用和 API 服务项目
- 微服务架构项目
- 需要 AI 辅助开发的项目

## 2. 配置与使用

### Q4: 如何在 Cursor 中加载这些规则？
A: 有几种方式：
1. **项目规则**：在项目根目录创建 `.cursor/rules` 目录，将所有 `.mdc` 文件复制到该目录
2. **开启 Auto Attached**：在 Cursor 设置中开启 "Auto Attached" 选项，Cursor 会自动读取 `.cursor/rules` 目录下的规则文件
3. **团队规则**：在团队共享的代码仓库中维护规则文件，统一复制到各项目的 `.cursor/rules` 目录

### Q5: 如何自定义规则？
A: 可以：
1. 修改现有规则文件
2. 添加项目特定的规则
3. 创建新的约定文件
4. 更新相关文档

### Q6: 规则文件太多，如何快速找到需要的？
A: 建议：
1. 先阅读 `00-project-structure/project-structure.mdc` 了解整体结构
2. 根据开发阶段选择相关章节：
   - 编码实践 → `02-coding-standards/coding-standards.mdc`
   - API 设计 → `01-design-standards/api-design-standards.mdc`
   - 具体文件 → `03-code-file-convertions/` 目录
3. 使用 IDE 的搜索功能快速定位
4. 参考目录结构快速导航

## 3. AI 编程协作

### Q7: AI 生成的代码不符合规范怎么办？
A: 可以：
1. 使用 `02-coding-standards/coding-standards.mdc` 中的编码实践规范
2. 参考 `01-design-standards/design-pattern-standards.mdc` 中的设计原则
3. 使用 `03-code-file-convertions/` 中的具体文件约定进行检查
4. 提供正确的示例给 AI

### Q8: 如何确保 AI 生成完整的代码？
A: 在提示词中明确要求：
1. 包含所有必要的导入语句
2. 添加所有必要的注解
3. 包含完整的异常处理
4. 添加必要的日志记录
5. 使用统一的响应格式
6. 遵循项目的命名和代码风格规范

### Q18: 如何与 AI 更好地协作？
A: 参考项目规范：
1. 使用结构化的提示词
2. 提供足够的上下文信息
3. 明确输出格式要求
4. 使用 `.cursor/rules` 目录下的规则文件
5. 通过 `@文件名` 引用特定规范
6. 进行代码审查和迭代优化

### Q21: 如何调试 AI 生成的代码？
A: 建议：
1. 仔细阅读生成的代码
2. 添加调试日志
3. 使用断点调试
4. 检查异常堆栈
5. 参考 `03-code-file-convertions/` 中的具体文件约定
6. 使用 `02-coding-standards/coding-standards.mdc` 中的编码实践规范
7. 检查是否符合项目的命名和风格规范

## 4. 代码质量与安全

### Q9: 如何处理 AI 生成的代码中的安全问题？
A: 参考 `01-design-standards/design-pattern-standards.mdc`：
1. 验证所有外部输入
2. 使用参数化查询防止 SQL 注入
3. 对输出进行转义防止 XSS
4. 验证用户权限
5. 保护敏感信息

### Q10: AI 生成的代码性能不好怎么办？
A: 参考 `01-design-standards/design-pattern-standards.mdc`：
1. 避免 N+1 查询问题
2. 使用批量操作
3. 合理使用缓存
4. 优化 SQL 查询
5. 使用异步处理

### Q16: 如何编写可维护的代码？
A: 参考 `01-design-standards/design-pattern-standards.mdc`：
1. 遵循 SOLID 原则（单一职责、开闭、依赖倒置、接口隔离、里氏替换）
2. 应用 DRY 原则（不要重复自己）
3. 遵循 KISS 原则（保持简单）
4. 合理分层架构
5. 使用设计模式

### Q17: 如何提高代码质量？
A: 参考 `01-design-standards/design-pattern-standards.mdc`：
1. 编写完整的单元测试
2. 使用静态分析工具
3. 进行代码审查
4. 遵循编码规范
5. 持续重构

## 5. Spring Boot 技术问题

### Q11: 如何处理循环依赖问题？
A: 参考 `02-coding-standards/coding-standards.mdc`：
1. 重构设计，提取公共服务
2. 使用 `@Lazy` 注解
3. 使用 `ApplicationContext` 获取 Bean
4. 重新设计类之间的依赖关系
5. 统一使用 `@Autowired` 字段注入，避免构造器注入

### Q12: 事务不生效怎么办？
A: 参考 `02-coding-standards/coding-standards.mdc`：
1. 是否使用了 `@Transactional` 注解
2. 是否在同一个类中自调用
3. 是否捕获了异常导致回滚失效
4. 是否正确配置了事务管理器
5. 检查事务传播行为设置

### Q13: 如何优化数据库查询性能？
A: 参考 `01-design-standards/design-pattern-standards.mdc`：
1. 添加适当的索引
2. 使用批量查询避免 N+1 问题
3. 优化 SQL 语句
4. 使用连接池
5. 考虑读写分离

### Q19: 应用启动失败怎么办？
A: 参考 `00-project-structure/project-structure.mdc` 和 `02-coding-standards/coding-standards.mdc`：
1. 检查配置文件是否正确
2. 数据库连接是否正常
3. 依赖注入是否有问题（检查 `@Autowired` 字段注入）
4. 端口是否被占用
5. 查看日志中的错误信息
6. 检查 MyBatis 注解配置

### Q20: 性能问题如何排查？
A: 参考 `01-design-standards/design-pattern-standards.mdc`：
1. 查看应用日志
2. 使用性能分析工具
3. 检查数据库查询（避免 N+1 问题）
4. 分析内存使用情况
5. 监控系统资源
6. 检查缓存使用情况

## 6. API 设计与错误处理

### Q14: 如何处理异常？
A: 参考 `02-coding-standards/coding-standards.mdc` 和 `01-design-standards/error-code-standards.mdc`：
1. 使用全局异常处理器
2. 区分业务异常和系统异常
3. 返回用户友好的错误信息
4. 记录详细的错误日志
5. 使用统一的 13 位错误码体系

### Q15: 如何设计好的 API？
A: 参考 `01-design-standards/api-design-standards.mdc`：
1. 仅使用 GET 和 POST 方法
2. 使用统一的响应格式 `CommonResponse`
3. 添加完整的 API 文档
4. 进行参数验证
5. 使用 13 位错误码

### Q29: 如何设计 13 位错误码？
A: 参考 `01-design-standards/error-code-standards.mdc`：
1. 前 4 位：子系统编号
2. 第 5 位：错误类型（B-业务、T-技术、C-客户端、U-未知、S-成功）
3. 第 6-7 位：预留编码（推荐填 0）
4. 第 8-13 位：子系统内编码（6 位数字）
5. 示例：`1001B00000001`（用户模块业务错误 000001）

### Q30: 为什么只使用 GET 和 POST 方法？
A: 参考 `01-design-standards/api-design-standards.mdc`：
1. GET：用于简单查询，参数少且幂等
2. POST：用于所有修改操作（增删改）和复杂查询
3. 简化前端调用，减少 HTTP 方法选择困扰
4. 符合 RESTful 设计原则
5. 便于 API 网关统一处理

### Q32: 如何处理分页查询？
A: 参考 `03-code-file-convertions/common-page-request-class-conventions.mdc` 和 `03-code-file-convertions/common-page-response-class-conventions.mdc`：
1. 使用 `CommonPageRequest` 作为分页请求参数
2. 使用 `CommonPageResponse` 作为分页响应
3. 包含 `total`、`pageNumber`、`pageSize`、`list` 字段
4. 复杂分页查询使用 POST 方法
5. 简单分页查询可以使用 GET 方法

## 7. 数据持久化与表结构设计

### Q28: 如何使用 MyBatis 注解模式？
A: 参考 `03-code-file-convertions/mapper-interface-conventions.mdc`：
1. 使用 `@Mapper` 注解标记接口
2. 使用 `@Insert`、`@Update`、`@Delete`、`@Select` 注解定义 SQL
3. 避免使用 XML 配置文件
4. 不使用 MyBatis Plus 的 `BaseMapper`
5. 复杂查询可以使用 `@Select` 注解

### Q29: MySQL 表结构设计规范是什么？
A: 参考 `01-design-standards/table-design-standards.mdc`：
1. 表名以 `t_` 开头，使用小写字母和下划线
2. 主键使用 `id BIGINT AUTO_INCREMENT`
3. 必须包含 `create_time` 和 `update_time` 审计字段
4. 不使用外键约束，在应用层维护数据一致性
5. 为查询字段和关联字段添加索引

### Q30: 实体类与数据库表的映射规范是什么？
A: 参考 `03-code-file-convertions/entity-class-conventions.mdc`：
1. 实体类名以 `Entity` 结尾
2. 自增主键使用 `Long` 类型
3. 时间字段使用 `Timestamp` 类型
4. 金额字段使用 `BigDecimal` 类型
5. 必须使用 `@Data`、`@NoArgsConstructor`、`@AllArgsConstructor`、`@Builder` 注解

### Q31: 如何正确使用 @Autowired 字段注入？
A: 参考 `02-coding-standards/coding-standards.mdc`：
1. 统一使用 `@Autowired` 字段注入
2. 禁止使用构造器注入（除非明确说明）
3. 避免循环依赖问题
4. 保持代码简洁性
5. 符合项目统一规范

## 8. 团队协作

### Q22: 如何让团队统一使用这些规范？
A: 建议：
1. 组织团队培训
2. 在代码审查中强制执行
3. 使用自动化工具检查
4. 定期更新和优化规范
5. 建立反馈机制
6. 将 `.cursor/rules` 目录加入版本控制

### Q23: 如何处理规范冲突？
A: 建议：
1. 组织团队讨论
2. 参考行业最佳实践
3. 考虑项目实际情况
4. 记录决策过程
5. 更新相关文档

### Q24: 如何保持规范的时效性？
A: 建议：
1. 定期回顾和更新
2. 关注技术发展趋势
3. 收集团队反馈
4. 参考开源项目实践
5. 持续改进
6. 及时更新 `.mdc` 规则文件

## 9. 其他问题

### Q25: 这些规范适用于其他技术栈吗？
A: 部分适用：
- 通用规范（命名、代码风格等）可以借鉴
- 特定技术栈的规范需要调整
- 建议根据实际技术栈定制
- Spring Boot 相关规范需要适配其他框架

### Q26: 如何贡献到项目中？
A: 参考项目贡献指南：
1. Fork 项目仓库
2. 创建功能分支
3. 提交变更
4. 发起 Pull Request
5. 确保文档与代码同步更新

### Q27: 遇到问题如何获得帮助？
A: 可以通过以下方式：
1. 查看相关文档
2. 搜索常见问题
3. 在项目仓库中提交 Issue
4. 参与社区讨论
5. 联系维护团队

---

## 问题反馈

如果您遇到本文档未涵盖的问题，请：

1. 首先搜索现有问题
2. 查看相关文档章节
3. 在项目仓库中提交 Issue
4. 提供详细的问题描述和复现步骤