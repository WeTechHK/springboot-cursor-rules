# /create-util 命令

## 命令格式
```bash
/create-util [一段描述性的话]
```

## 功能说明
创建工具类，遵循Spring Boot最佳实践，包括静态方法设计、工具函数封装、性能优化和代码复用。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取工具类型、功能需求、使用场景
- **识别工具类型**：判断是字符串工具、日期工具、加密工具、文件工具等
- **推断功能复杂度**：评估工具功能的复杂度和实现难度

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的工具设计文档、工具规范文档
- **内容匹配**：基于描述内容匹配相关工具文档
- **信息提取**：从文档中提取工具方法、使用规范、性能要求等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的工具使用方式、工具规范
- **模块识别**：识别相关模块和工具依赖
- **规范推断**：推断项目的工具设计规范

### 4. 工具规则匹配
- **规范匹配**：根据需求匹配对应的工具编码规范
- **方法设计**：应用统一的工具方法设计规范
- **性能优化**：应用工具性能优化规范

### 5. 主动询问与确认
- **需求澄清**：对模糊描述进行主动询问
- **功能确认**：确认具体工具功能
- **方法确认**：确认工具方法设计
- **性能确认**：确认性能要求

## 使用示例

### 示例1：简单描述
```bash
# 用户输入
/create-util 字符串工具类

# AI响应
AI: 已解析您的描述"字符串工具类"，并发现以下相关文档：

**发现的设计文档：**
- `docs/utility-design.md` - 工具类设计文档
- `docs/string-utils-standards.md` - 字符串工具标准文档
- `docs/performance-standards.md` - 性能标准文档

基于这些文档，StringUtils将包含以下工具方法：

**工具方法规划：**
- 字符串验证方法（isEmpty、isBlank、isEmail、isPhone）
- 字符串处理方法（trim、substring、replace、format）
- 字符串转换方法（toUpperCase、toLowerCase、camelCase、snakeCase）
- 字符串加密方法（md5、sha256、base64）

**需要确认的细节：**
1. 字符串验证需要哪些方法？
2. 字符串处理需要哪些功能？
3. 字符串转换需要哪些格式？
4. 是否需要加密解密功能？

请提供详细信息，或者确认以上规划是否符合您的需求？
```

### 示例2：详细描述
```bash
# 用户输入
/create-util 日期时间工具类，包含日期格式化、日期计算、时区转换、工作日计算等功能

# AI响应
AI: 已解析您的详细描述，并发现以下相关文档：

**发现的设计文档：**
- `docs/date-utils-design.md` - 日期工具设计文档
- `docs/timezone-handling.md` - 时区处理文档
- `docs/business-date-calculations.md` - 业务日期计算文档

基于这些文档，DateUtils将包含以下工具方法：

**工具方法规划：**
1. **日期格式化方法**
   - formatDate() - 日期格式化
   - formatDateTime() - 日期时间格式化
   - parseDate() - 日期解析
   - parseDateTime() - 日期时间解析

2. **日期计算方法**
   - addDays() - 添加天数
   - addMonths() - 添加月数
   - addYears() - 添加年数
   - daysBetween() - 计算天数差

3. **时区转换方法**
   - convertTimezone() - 时区转换
   - getCurrentTimezone() - 获取当前时区
   - formatWithTimezone() - 带时区格式化

4. **工作日计算方法**
   - isWorkday() - 判断工作日
   - getWorkdaysBetween() - 计算工作日差
   - getNextWorkday() - 获取下一个工作日

**需要确认的信息：**
1. 日期格式化格式是否合适？
2. 日期计算方法是否完整？
3. 时区转换功能是否符合需求？
4. 工作日计算规则是否正确？

请确认以上信息是否正确，或者提供更多详细信息？
```

## 生成内容

### 1. 工具类
- `src/main/java/com/example/app/util/StringUtils.java` - 字符串工具类
- `src/main/java/com/example/app/util/DateUtils.java` - 日期工具类
- `src/main/java/com/example/app/util/EncryptUtils.java` - 加密工具类
- `src/main/java/com/example/app/util/FileUtils.java` - 文件工具类

### 2. 工具规范
遵循 `.cursor/rules/03-code-file-convertions/utility-class-conventions.mdc` 规范：
- 使用 `final` 类避免被继承
- 使用 `private` 构造器避免被实例化
- 使用 `static` 方法提供工具功能
- 提供完整的JavaDoc注释
- 使用 `@UtilityClass` 注解（Lombok）

### 3. 方法设计
- **单一职责**：每个方法只做一件事
- **无副作用**：方法不修改输入参数
- **线程安全**：方法支持并发调用
- **性能优化**：避免不必要的对象创建

## 技术特性

### 1. 工具方法
- 静态方法设计
- 参数验证
- 异常处理
- 性能优化

### 2. 代码复用
- 公共方法提取
- 工具类封装
- 模块化设计
- 依赖最小化

### 3. 测试支持
- 单元测试覆盖
- 边界条件测试
- 性能测试
- 集成测试

## 进一步阅读
- 工具类规范：`03-code-file-convertions/utility-class-conventions.mdc`
- 编码规范：`02-coding-standards/coding-standards.mdc`
- 命名规范：`02-coding-standards/naming-standards.mdc`
- 项目结构：`00-project-structure/project-structure.mdc`