# /create-mapper 命令

## 命令格式
```bash
/create-mapper [实体名称] [查询需求]
```

## 参数说明
- `[实体名称]`: 实体名称，用于生成Mapper接口名
- `[查询需求]`: 查询功能描述，用于生成相应的查询方法

## 功能说明
创建MyBatis数据访问层代码，包括：
- Mapper接口定义
- 基础CRUD操作方法
- 复杂查询方法
- 参数映射和结果映射
- 动态SQL支持

## 生成内容

### 1. Mapper接口
- 接口名以`Mapper`结尾
- 使用`@Mapper`注解标记
- 继承基础Mapper接口（如需要）
- 定义数据访问方法

### 2. 基础CRUD操作
- `insert()` - 插入记录
- `updateById()` - 根据ID更新
- `deleteById()` - 根据ID删除
- `selectById()` - 根据ID查询
- `selectList()` - 列表查询

### 3. 复杂查询方法
- 根据查询需求生成相应方法
- 条件查询和分页查询
- 关联查询和聚合查询
- 动态SQL查询

### 4. SQL注解
- 使用`@Insert`、`@Update`、`@Delete`、`@Select`注解
- 参数映射使用`@Param`注解
- 结果映射使用`@Results`注解
- 支持动态SQL和条件查询

### 5. 参数处理
- 单个参数直接传递
- 多个参数使用`@Param`注解
- 复杂对象参数映射
- 分页参数处理

## 编码规范遵循

本命令严格遵循以下编码规范文件：
- **主要规范**：`03-code-file-convertions/mapper-interface-conventions.mdc`
- **相关规范**：`01-design-standards/table-design-standards.mdc`

**详细规范**：请参考上述规范文件获取完整要求。

## 使用示例

### 1. 创建用户基础CRUD
```bash
/create-mapper User 用户基础CRUD和复杂查询
```

### 2. 创建订单查询Mapper
```bash
/create-mapper Order 订单查询，包含条件查询、分页查询、关联查询
```

### 3. 创建商品数据访问
```bash
/create-mapper Product 商品数据访问，包含商品信息、库存查询、分类查询
```

## 标准查询方法

### 1. 基础CRUD
- `insert{TEntity}()` - 插入实体
- `update{TEntity}ById()` - 根据ID更新
- `delete{TEntity}ById()` - 根据ID删除
- `select{TEntity}ById()` - 根据ID查询
- `select{TEntity}List()` - 列表查询

### 2. 条件查询
- `select{TEntity}sByCondition()` - 条件查询
- `select{TEntity}sByPage()` - 分页查询
- `count{TEntity}s()` - 统计查询

### 3. 复杂查询
- `select{TEntity}sWithJoin()` - 关联查询
- `select{TEntity}sByDynamic()` - 动态查询
- `select{TEntity}sByCustom()` - 自定义查询

## 数据访问特性
1. **注解模式**: 使用MyBatis注解模式
2. **动态SQL**: 支持动态SQL和条件查询
3. **参数映射**: 完整的参数映射和结果映射
4. **性能优化**: 合理的SQL设计和索引使用
5. **可维护**: 清晰的代码结构和注释

## 技术实现
- **注解**: 使用MyBatis注解模式
- **SQL**: 支持动态SQL和复杂查询
- **映射**: 参数映射和结果映射
- **缓存**: 支持二级缓存配置
- **事务**: 与Spring事务管理集成

## 注意事项
1. 会根据查询需求生成相应的查询方法
2. 自动处理参数映射和结果映射
3. 包含完整的SQL注解和注释
4. 遵循项目的编码规范和数据库设计
5. 生成的代码可以直接运行和测试
