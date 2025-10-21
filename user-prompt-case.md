# Spring Boot Cursor Rules 典型对话场景

基于当前规则体系，以下是11个典型对话场景，按开发阶段和内容类型进行分类：

## 一、新内容开发场景

### 1. 新项目开发场景

**开发者**："创建一个学生管理系统的 Spring Boot 项目，包含用户管理、课程管理、成绩管理等模块"

**AI**：我会根据 `.cursor/rules/00-project-structure/project-structure.mdc` 和 `tech-stack.mdc` 中的项目结构规范，为您创建完整的 Spring Boot 项目结构，包括主启动类、配置类、Controller层、Service层、Mapper层、实体类等，并配置必要的依赖和功能模块。

---

### 2. 新模块/新功能开发场景

**开发者**："在现有项目中新增课程管理模块，包含课程信息管理、课程安排、选课等功能"

**AI**：我会根据 `.cursor/rules/03-code-file-convertions/` 中的各类规范，为您生成完整的课程管理模块，包括 CourseController、CourseService、CourseMapper、CourseEntity、相关的 Request/Response 对象，确保遵循现有的项目架构和编码规范。

---

### 3. 独立的新的代码文件开发场景

**开发者**："创建课程服务层，包含课程的增删改查、课程状态管理、课程统计等功能"

**AI**：我会根据 `.cursor/rules/03-code-file-convertions/service-interface-conventions.mdc` 和 `service-impl-conventions.mdc` 中的服务层规范，为您生成 CourseService 接口及 CourseServiceImpl 实现类，确保使用 @Service 注解、@Autowired 依赖注入、@Transactional 事务管理，并通过 DTO 进行数据传递。

---

### 4. 单元测试开发场景

**开发者**："为课程管理模块编写完整的单元测试，包含正常流程和异常情况的测试用例"

**AI**：我会根据 `.cursor/rules/02-coding-standards/unit-testing-standards.mdc` 中的测试规范，为您生成 CourseServiceTest、CourseControllerTest、CourseMapperTest 等测试类，确保使用 AAA 模式、@MockBean 模拟依赖、AssertJ 进行流畅断言，并达到核心业务逻辑 ≥ 80% 的覆盖率目标。

---

### 5. 数据访问层开发场景

**开发者**："创建课程实体的 MyBatis Mapper 接口，包含基本的 CRUD 操作和复杂查询"

**AI**：我会根据 `.cursor/rules/03-code-file-convertions/mapper-interface-conventions.mdc` 中的 Mapper 规范，为您生成 CourseMapper 接口，确保使用 @Mapper 注解、基于注解的 SQL 配置（@Select、@Insert、@Update、@Delete）、@Param 参数映射，并遵循表名 t_ 前缀规范。

---

### 6. 异常处理设计场景

**开发者**："创建课程相关的业务异常类，并配置全局异常处理器"

**AI**：我会根据 `.cursor/rules/03-code-file-convertions/exception-class-conventions.mdc` 和 `global-exception-handler-conventions.mdc` 中的异常处理规范，为您生成 CourseNotFoundException、CourseStatusException 等业务异常类，确保包含13位错误码字段，并更新 GlobalExceptionHandler 统一处理异常，遵循 `01-design-standards/error-code-standards.mdc` 中的错误码设计规范。

---

## 二、存量内容维护场景

### 7. 重构整个项目场景

**开发者**："重构整个学生管理系统，统一代码风格，优化架构设计，提升代码质量"

**AI**：我会根据 `.cursor/rules/02-coding-standards/code-style-standards.mdc`、`coding-standards.mdc` 和 `naming-standards.mdc` 中的编码规范，系统性地重构项目代码，包括统一命名规范、优化代码结构、改进异常处理、完善日志记录，确保整个项目符合最新的编码标准。

---

### 8. 新增模块场景

**开发者**："在现有学生管理系统中新增成绩管理模块，与现有的用户管理和课程管理模块集成"

**AI**：我会根据现有的项目架构和 `.cursor/rules/03-code-file-convertions/` 中的规范，为您生成成绩管理模块的完整代码，确保与现有模块的接口和数据模型保持一致，遵循项目的统一架构模式。

---

### 9. 重构某个模块场景

**开发者**："重构课程管理模块，优化性能，改进代码结构，增加新的业务功能"

**AI**：我会根据 `.cursor/rules/02-coding-standards/coding-standards.mdc` 中的编码实践规范，重构课程管理模块的现有代码，包括优化数据库查询、改进事务管理、增强异常处理、完善日志记录，并确保新功能与现有功能的无缝集成。

---

### 10. 修改某个代码文件场景

**开发者**："修改课程服务层的查询方法，增加新的查询条件和排序功能"

**AI**：我会根据 `.cursor/rules/03-code-file-convertions/service-impl-conventions.mdc` 中的服务实现规范，修改现有的 CourseServiceImpl 类，确保新增功能符合现有的编码规范，包括参数校验、异常处理、日志记录和事务管理，并保持代码的向后兼容性。

---

### 11. 某个模块或功能的bug修复场景

**开发者**："修复课程管理模块中的并发选课问题，确保数据一致性"

**AI**：我会根据 `.cursor/rules/02-coding-standards/coding-standards.mdc` 中的事务和数据库规范，分析现有的课程管理代码，识别并发问题，提供基于 @Transactional 和数据库锁机制的解决方案，确保修复后的代码符合项目的编码标准和性能要求。

---

## 使用说明

这些对话场景按开发阶段和内容类型进行了系统分类，展示了AI如何根据项目规则自动生成符合标准的代码：

### 新内容开发场景（场景1-6）
- **新项目开发**：从零开始创建完整的Spring Boot项目
- **新模块/新功能开发**：在现有项目中添加新的业务模块
- **独立的新的代码文件开发**：创建特定的代码文件（如服务层、控制器等）
- **单元测试开发**：为新功能编写完整的测试用例
- **数据访问层开发**：创建MyBatis Mapper接口
- **异常处理设计**：设计业务异常和全局异常处理

### 存量内容维护场景（场景7-11）
- **重构整个项目**：系统性优化现有项目的代码质量和架构
- **新增模块**：在现有架构基础上添加新模块
- **重构某个模块**：优化特定模块的代码结构和性能
- **修改某个代码文件**：在现有文件中添加或修改功能
- **Bug修复**：修复现有功能中的问题

### 规则映射
每个场景都明确对应特定的规则文件，确保生成的代码遵循项目的编码规范、设计模式和最佳实践。开发者可以直接使用这些场景作为与AI对话的模板，AI会自动应用相应的规则文件来生成高质量的代码。
