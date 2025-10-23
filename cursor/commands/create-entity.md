# /create-entity 命令

## 命令格式
```bash
/create-entity [实体名称] [字段描述]
```

## 参数说明
- `[实体名称]`: 实体名称，用于生成实体类名
- `[字段描述]`: 字段描述，用于生成相应的实体字段

## 功能说明
创建MyBatis实体类，包括：
- 实体类定义
- 字段映射和注解
- 数据校验注解
- 序列化配置
- 数据库表映射

## 生成内容

### 1. 实体类 (Entity)
- 类名以`Entity`结尾
- 使用Lombok注解简化代码
- 包含所有必要的字段
- 完整的JavaDoc注释

### 2. 字段定义
- 根据字段描述生成相应字段
- 基础字段（ID、创建时间、更新时间）
- 业务字段（根据描述生成）
- 状态字段和枚举字段

### 3. Lombok注解
- `@Data` - 自动生成getter/setter方法
- `@NoArgsConstructor` - 无参构造器
- `@AllArgsConstructor` - 全参构造器
- `@Builder` - 建造者模式支持

### 4. 数据校验注解
- `@NotNull` - 非空校验
- `@NotBlank` - 非空白校验
- `@Size` - 长度校验
- `@Email` - 邮箱格式校验
- `@Pattern` - 正则表达式校验

### 5. 数据库映射
- `@Table` - 数据库表映射
- `@Column` - 字段映射
- `@Id` - 主键标识
- `@GeneratedValue` - 主键生成策略

## 编码规范遵循

本命令严格遵循以下编码规范文件：
- **主要规范**：`03-code-file-convertions/entity-class-conventions.mdc`
- **相关规范**：`01-design-standards/table-design-standards.mdc`

**详细规范**：请参考上述规范文件获取完整要求。

## 使用示例

### 1. 创建商品实体
```bash
/create-entity Product 商品实体，包含名称、价格、库存、分类
```

### 2. 创建用户实体
```bash
/create-entity User 用户实体，包含ID、用户名、邮箱、密码、状态
```

### 3. 创建订单实体
```bash
/create-entity Order 订单实体，包含订单号、用户ID、金额、状态、创建时间
```

## 标准字段类型

### 1. 基础字段
- `id` - 主键ID (Long类型)
- `createTime` - 创建时间 (Timestamp类型)
- `updateTime` - 更新时间 (Timestamp类型)
- `isDeleted` - 是否删除 (Boolean类型)

### 2. 业务字段
- 字符串字段 - 使用String类型
- 数值字段 - 使用Integer、Long、BigDecimal类型
- 日期字段 - 使用Timestamp类型
- 布尔字段 - 使用Boolean类型，is前缀命名

### 3. 状态字段
- 状态字段 - 使用String或枚举类型
- 金额字段 - 使用BigDecimal类型
- 枚举字段 - 使用枚举类型

## 实体类特性
1. **简化代码**: 使用Lombok注解简化代码
2. **数据校验**: 完整的字段校验注解
3. **序列化**: 支持JSON序列化和反序列化
4. **数据库映射**: 完整的数据库表映射
5. **可维护**: 清晰的代码结构和注释

## 技术实现
- **注解**: 使用Lombok、JPA、Validation注解
- **序列化**: 支持Jackson序列化配置
- **校验**: 使用Bean Validation进行数据校验
- **映射**: 数据库表字段映射
- **构建**: 支持Builder模式构建对象

## 注意事项
1. 会根据字段描述生成相应的实体字段
2. 自动处理数据库表名和字段映射
3. 包含完整的数据校验注解
4. 遵循项目的编码规范和数据库设计
5. 生成的代码可以直接运行和测试
