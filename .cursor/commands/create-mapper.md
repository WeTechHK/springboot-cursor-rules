# /create-mapper 命令

## 命令格式
```bash
/create-mapper [一段描述性的话]
```

## 功能说明
创建MyBatis Mapper接口，包括SQL注解、参数映射、结果映射和数据库操作。

## AI分析流程

### 1. 智能描述解析
- **提取关键信息**：从用户描述中提取实体名称、数据操作、查询需求
- **识别操作类型**：判断是CRUD操作、复杂查询、批量操作等
- **推断SQL复杂度**：评估SQL的复杂度和实现难度

### 2. 智能文档发现
- **自动扫描**：扫描项目根目录下的`docs/`目录中的数据库文档、SQL文档、Mapper设计文档
- **内容匹配**：基于描述内容匹配相关数据库文档
- **信息提取**：从文档中提取表结构、字段定义、查询需求等
- **文件显示**：在AI响应中显示找到的相关设计文件名，便于用户确认

### 3. 基于项目结构的智能推断
- **项目分析**：分析现有项目的Mapper设计风格、SQL规范
- **表结构识别**：识别相关表结构和字段规范
- **规范推断**：推断项目的Mapper设计规范

### 4. Mapper规则匹配
- **规范匹配**：根据需求匹配对应的Mapper编码规范
- **设计模式**：应用MyBatis设计模式和最佳实践
- **代码生成**：生成符合项目规范的Mapper代码

### 5. 主动询问机制
- **操作补全**：识别缺失或模糊的数据操作需求，主动询问用户
- **SQL确认**：确认SQL语句和查询条件
- **多轮对话**：支持多轮对话，逐步完善Mapper设计

## 使用示例

### 1. 简单描述
```bash
/create-mapper 用户数据访问
```

### 2. 详细描述
```bash
/create-mapper 用户数据访问，包含用户CRUD操作、条件查询、分页查询
```

### 3. 业务场景描述
```bash
/create-mapper 订单数据访问，包含订单创建、状态更新、条件查询、统计查询
```

### 4. 技术需求描述
```bash
/create-mapper 商品数据访问，包含商品CRUD、库存管理、分类查询、搜索功能
```

## AI交互示例

### 示例1：简单描述
```bash
# 用户输入
/create-mapper 用户数据访问

# AI响应
AI: 已解析您的描述"用户数据访问"，并发现以下相关文档：

**发现的设计文档：**
- `docs/database-design.md` - 数据库设计文档
- `docs/user-table-schema.md` - 用户表结构文档
- `docs/mapper-design.md` - Mapper接口设计文档

基于这些文档，UserMapper将包含以下数据访问方法：

**推断的基础方法：**
- insert(UserEntity user) - 插入用户
- updateById(UserEntity user) - 根据ID更新用户
- deleteById(Long id) - 根据ID删除用户
- selectById(Long id) - 根据ID查询用户
- selectList() - 查询用户列表

**需要确认的信息：**
基于您的描述，我将智能判断是否需要确认信息：

- **如果描述完整**：直接开始生成Mapper接口
- **如果缺少数据操作**：询问具体的CRUD操作需求
- **如果缺少查询条件**：询问具体的查询条件和过滤规则
- **如果缺少复杂查询**：询问是否需要复杂查询和关联查询
- **如果描述模糊**：询问关键数据访问细节

**当前状态：** 基于您的描述，我将智能推断数据操作和查询需求，如有疑问会主动询问。
```

### 示例2：详细描述
```bash
# 用户输入
/create-mapper 用户数据访问，包含用户CRUD操作、条件查询、分页查询

# AI响应
AI: 已解析您的详细描述，UserMapper将包含以下方法：

**发现的设计文档：**
- `docs/database-design.md` - 数据库设计文档
- `docs/user-table-schema.md` - 用户表结构文档
- `docs/mapper-design.md` - Mapper设计文档

**解析的方法：**
- insert(UserEntity user) - 插入用户
- updateById(UserEntity user) - 根据ID更新用户
- deleteById(Long id) - 根据ID删除用户
- selectById(Long id) - 根据ID查询用户
- selectByCondition(UserQuery query) - 条件查询
- selectPage(PageRequest pageRequest) - 分页查询
- countByCondition(UserQuery query) - 条件统计

**推断的SQL注解：**
- @Insert - 插入操作
- @Update - 更新操作
- @Delete - 删除操作
- @Select - 查询操作
- @Options(useGeneratedKeys = true) - 获取自增主键

**推断的数据库表：**
- 表名：t_users
- 主键：id
- 字段：username, email, password, status, create_time, update_time

**需要确认的信息：**
基于您的详细描述，我发现以下信息：

✅ **已明确**：用户数据操作、查询条件、分页查询
✅ **数据操作**：CRUD操作、条件查询、批量操作
✅ **技术规范**：MyBatis注解、分页查询、软删除

**执行决策：** 信息完整，直接开始生成用户Mapper接口
```

## 生成内容

### 1. Mapper接口
- 接口名以`Mapper`结尾
- 使用`@Mapper`注解标记
- 定义数据访问方法
- 完整的JavaDoc注释

### 2. SQL注解
- `@Insert` - 插入操作
- `@Update` - 更新操作
- `@Delete` - 删除操作
- `@Select` - 查询操作
- `@Options` - 选项配置

### 3. 参数映射
- `@Param` - 参数映射
- 支持多个参数
- 支持复杂对象参数
- 支持集合参数

### 4. 结果映射
- `@Results` - 结果映射
- `@Result` - 字段映射
- 支持复杂对象映射
- 支持关联查询映射

### 5. 动态SQL
- `<script>` - 动态SQL标签
- `<where>` - 条件标签
- `<if>` - 条件判断
- `<foreach>` - 循环标签

## 标准数据操作方法

### 1. 基础CRUD操作
- `insert({Entity} entity)` - 插入记录
- `updateById({Entity} entity)` - 根据ID更新
- `deleteById(Long id)` - 根据ID删除
- `selectById(Long id)` - 根据ID查询
- `selectList()` - 查询列表

### 2. 条件查询操作
- `selectByCondition({Query} query)` - 条件查询
- `countByCondition({Query} query)` - 条件统计
- `selectPage({PageRequest} pageRequest)` - 分页查询
- `selectByField(String field, Object value)` - 字段查询

### 3. 批量操作
- `insertBatch(List<{Entity}> entities)` - 批量插入
- `updateBatch(List<{Entity}> entities)` - 批量更新
- `deleteBatch(List<Long> ids)` - 批量删除

## Mapper特性
1. **注解模式**: 使用MyBatis注解，避免XML配置
2. **参数化查询**: 防止SQL注入攻击
3. **动态SQL**: 支持复杂的条件查询
4. **结果映射**: 支持复杂对象映射
5. **性能优化**: 支持批量操作和分页查询

## 技术实现
- **注解**: 使用MyBatis注解定义SQL
- **参数映射**: 使用@Param进行参数映射
- **结果映射**: 使用@Results进行结果映射
- **动态SQL**: 使用<script>标签进行动态SQL
- **事务**: 支持Spring事务管理

## 注意事项
1. AI会根据描述自动推断数据操作方法
2. 自动处理SQL语句和参数映射
3. 包含完整的动态SQL支持
4. 遵循项目的编码规范和数据库设计
5. 生成的代码可以直接运行和测试
6. 支持多轮对话完善需求
7. 支持文档引用和智能推断
8. 支持自然语言描述

## 最佳实践建议

### 1. 描述技巧
- **具体描述**: 提供详细的数据操作描述，AI能更好地理解需求
- **关键操作**: 包含核心数据操作，帮助AI生成准确代码
- **查询条件**: 指定查询条件和排序规则

### 2. 交互技巧
- **分步确认**: 先确认核心操作，再完善查询条件
- **及时反馈**: 对AI的推断及时提供反馈
- **迭代优化**: 基于生成结果进行迭代优化

### 3. 文档使用
- **数据库文档**: 在项目中维护数据库文档，AI会自动发现
- **SQL文档**: 维护SQL文档，AI会参考生成SQL语句
- **查询文档**: 维护查询文档，AI会参考生成查询方法