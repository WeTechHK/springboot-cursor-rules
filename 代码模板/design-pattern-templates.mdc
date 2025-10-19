# 设计模式代码模板

## 概述

本文件提供了 Spring Boot 项目中常用设计模式的代码模板，可以直接复制使用或作为参考。

## 创建型模式模板

### 1. 工厂模式模板

#### 简单工厂模板
```java
// 产品接口
public interface Product {
    void doSomething();
    ProductType getType();
}

// 具体产品
@Component
public class ConcreteProductA implements Product {
    
    @Override
    public void doSomething() {
        // 具体实现
    }
    
    @Override
    public ProductType getType() {
        return ProductType.TYPE_A;
    }
}

// 工厂类
@Component
@RequiredArgsConstructor
public class ProductFactory {
    
    private final Map<ProductType, Product> products;
    
    public ProductFactory(List<Product> productList) {
        this.products = productList.stream()
            .collect(Collectors.toMap(
                Product::getType,
                Function.identity()
            ));
    }
    
    public Product createProduct(ProductType type) {
        Product product = products.get(type);
        if (product == null) {
            throw new IllegalArgumentException("不支持的产品类型: " + type);
        }
        return product;
    }
}
```

#### 抽象工厂模板
```java
// 抽象工厂接口
public interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// 具体工厂实现
@Component
@ConditionalOnProperty(name = "factory.type", havingValue = "production")
public class ProductionFactory implements AbstractFactory {
    
    @Override
    public ProductA createProductA() {
        return new ProductionProductA();
    }
    
    @Override
    public ProductB createProductB() {
        return new ProductionProductB();
    }
}

@Component
@ConditionalOnProperty(name = "factory.type", havingValue = "test")
public class TestFactory implements AbstractFactory {
    
    @Override
    public ProductA createProductA() {
        return new MockProductA();
    }
    
    @Override
    public ProductB createProductB() {
        return new MockProductB();
    }
}
```

### 2. 建造者模式模板

#### Lombok 建造者模板
```java
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComplexObject {
    private String field1;
    private String field2;
    private Integer field3;
    private Boolean field4;
    private LocalDateTime field5;
    
    // 自定义建造者方法
    public static ComplexObjectBuilder builder() {
        return new ComplexObjectBuilder()
            .field4(true)
            .field5(LocalDateTime.now());
    }
    
    // 使用示例
    public static void main(String[] args) {
        ComplexObject obj = ComplexObject.builder()
            .field1("value1")
            .field2("value2")
            .field3(100)
            .build();
    }
}
```

#### 手动建造者模板
```java
public class QueryBuilder {
    private String table;
    private List<String> selectFields = new ArrayList<>();
    private List<String> whereConditions = new ArrayList<>();
    private List<String> orderByFields = new ArrayList<>();
    private Integer limit;
    private Integer offset;
    
    public static QueryBuilder table(String table) {
        return new QueryBuilder().setTable(table);
    }
    
    public QueryBuilder select(String... fields) {
        this.selectFields.addAll(Arrays.asList(fields));
        return this;
    }
    
    public QueryBuilder where(String condition) {
        this.whereConditions.add(condition);
        return this;
    }
    
    public QueryBuilder orderBy(String field) {
        this.orderByFields.add(field);
        return this;
    }
    
    public QueryBuilder limit(int limit) {
        this.limit = limit;
        return this;
    }
    
    public QueryBuilder offset(int offset) {
        this.offset = offset;
        return this;
    }
    
    public String build() {
        StringBuilder sql = new StringBuilder("SELECT ");
        
        if (selectFields.isEmpty()) {
            sql.append("*");
        } else {
            sql.append(String.join(", ", selectFields));
        }
        
        sql.append(" FROM ").append(table);
        
        if (!whereConditions.isEmpty()) {
            sql.append(" WHERE ").append(String.join(" AND ", whereConditions));
        }
        
        if (!orderByFields.isEmpty()) {
            sql.append(" ORDER BY ").append(String.join(", ", orderByFields));
        }
        
        if (limit != null) {
            sql.append(" LIMIT ").append(limit);
        }
        
        if (offset != null) {
            sql.append(" OFFSET ").append(offset);
        }
        
        return sql.toString();
    }
    
    private QueryBuilder setTable(String table) {
        this.table = table;
        return this;
    }
}
```

## 结构型模式模板

### 1. 适配器模式模板

#### 第三方服务适配器模板
```java
// 目标接口
public interface ExternalService {
    Response processRequest(Request request);
    StatusResponse getStatus(String id);
    void cancel(String id);
}

// 第三方服务适配器
@Component
@RequiredArgsConstructor
@Slf4j
public class ThirdPartyServiceAdapter implements ExternalService {
    
    private final ThirdPartyClient thirdPartyClient;
    private final ThirdPartyProperties properties;
    
    @Override
    public Response processRequest(Request request) {
        try {
            ThirdPartyRequest thirdPartyRequest = convertToThirdPartyRequest(request);
            ThirdPartyResponse thirdPartyResponse = thirdPartyClient.process(thirdPartyRequest);
            return convertFromThirdPartyResponse(thirdPartyResponse);
        } catch (Exception e) {
            log.error("第三方服务调用失败", e);
            throw new ExternalServiceException("第三方服务调用失败", e);
        }
    }
    
    @Override
    public StatusResponse getStatus(String id) {
        try {
            ThirdPartyStatusResponse statusResponse = thirdPartyClient.getStatus(id);
            return convertStatusResponse(statusResponse);
        } catch (Exception e) {
            log.error("获取状态失败: id={}", id, e);
            throw new ExternalServiceException("获取状态失败", e);
        }
    }
    
    @Override
    public void cancel(String id) {
        try {
            thirdPartyClient.cancel(id);
        } catch (Exception e) {
            log.error("取消操作失败: id={}", id, e);
            throw new ExternalServiceException("取消操作失败", e);
        }
    }
    
    private ThirdPartyRequest convertToThirdPartyRequest(Request request) {
        // 转换逻辑
        return ThirdPartyRequest.builder()
            .id(request.getId())
            .data(request.getData())
            .build();
    }
    
    private Response convertFromThirdPartyResponse(ThirdPartyResponse response) {
        // 转换逻辑
        return Response.builder()
            .id(response.getId())
            .status(mapStatus(response.getStatus()))
            .build();
    }
    
    private Status mapStatus(String thirdPartyStatus) {
        return switch (thirdPartyStatus) {
            case "SUCCESS" -> Status.SUCCESS;
            case "FAILED" -> Status.FAILED;
            case "PENDING" -> Status.PENDING;
            default -> Status.UNKNOWN;
        };
    }
}
```

### 2. 装饰器模式模板

#### AOP 装饰器模板
```java
// 基础服务
@Service
@RequiredArgsConstructor
public class BaseService {
    
    private final Repository repository;
    
    public Entity getEntityById(Long id) {
        return repository.findById(id);
    }
    
    public Entity createEntity(CreateRequest request) {
        Entity entity = buildEntity(request);
        return repository.save(entity);
    }
}

// 装饰器切面
@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class ServiceDecorator {
    
    private final CacheService cacheService;
    private final MeterRegistry meterRegistry;
    private final SecurityService securityService;
    
    @Around("execution(* com.{company}.{project}.service.BaseService.getEntityById(..))")
    public Object aroundGetEntityById(ProceedingJoinPoint joinPoint) throws Throwable {
        Long id = (Long) joinPoint.getArgs()[0];
        
        // 缓存装饰
        Entity cachedEntity = cacheService.get("entity:" + id, Entity.class);
        if (cachedEntity != null) {
            return cachedEntity;
        }
        
        // 性能监控装饰
        Timer.Sample sample = Timer.start(meterRegistry);
        try {
            Entity entity = (Entity) joinPoint.proceed();
            cacheService.put("entity:" + id, entity);
            return entity;
        } finally {
            sample.stop(Timer.builder("service.duration")
                .tag("method", "getEntityById")
                .register(meterRegistry));
        }
    }
    
    @Before("execution(* com.{company}.{project}.service.BaseService.createEntity(..))")
    public void beforeCreateEntity(JoinPoint joinPoint) {
        // 权限检查装饰
        securityService.checkPermission("CREATE_ENTITY");
    }
    
    @AfterReturning(pointcut = "execution(* com.{company}.{project}.service.BaseService.createEntity(..))", 
                   returning = "result")
    public void afterCreateEntity(JoinPoint joinPoint, Object result) {
        if (result instanceof Entity entity) {
            // 审计日志装饰
            log.info("实体创建成功: id={}", entity.getId());
        }
    }
}
```

### 3. 代理模式模板

#### 动态代理模板
```java
// 代理接口
public interface Service {
    String process(String input);
    void cleanup();
}

// 代理实现
@Component
@RequiredArgsConstructor
public class ServiceProxy implements InvocationHandler {
    
    private final Service target;
    private final MeterRegistry meterRegistry;
    
    public static Service createProxy(Service target, MeterRegistry meterRegistry) {
        return (Service) Proxy.newProxyInstance(
            Service.class.getClassLoader(),
            new Class[]{Service.class},
            new ServiceProxy(target, meterRegistry)
        );
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置处理
        log.info("调用方法: {}", method.getName());
        
        // 性能监控
        Timer.Sample sample = Timer.start(meterRegistry);
        try {
            Object result = method.invoke(target, args);
            return result;
        } catch (Exception e) {
            log.error("方法调用失败: {}", method.getName(), e);
            throw e;
        } finally {
            sample.stop(Timer.builder("service.method.duration")
                .tag("method", method.getName())
                .register(meterRegistry));
        }
    }
}
```

## 行为型模式模板

### 1. 策略模式模板

#### 策略接口和实现模板
```java
// 策略接口
public interface Strategy {
    Result execute(Input input);
    StrategyType getType();
}

// 具体策略实现
@Component
public class StrategyA implements Strategy {
    
    @Override
    public Result execute(Input input) {
        // 策略A的具体实现
        return Result.builder()
            .success(true)
            .data("Strategy A result")
            .build();
    }
    
    @Override
    public StrategyType getType() {
        return StrategyType.TYPE_A;
    }
}

@Component
public class StrategyB implements Strategy {
    
    @Override
    public Result execute(Input input) {
        // 策略B的具体实现
        return Result.builder()
            .success(true)
            .data("Strategy B result")
            .build();
    }
    
    @Override
    public StrategyType getType() {
        return StrategyType.TYPE_B;
    }
}

// 策略上下文
@Service
@RequiredArgsConstructor
public class StrategyContext {
    
    private final Map<StrategyType, Strategy> strategies;
    
    public StrategyContext(List<Strategy> strategyList) {
        this.strategies = strategyList.stream()
            .collect(Collectors.toMap(
                Strategy::getType,
                Function.identity()
            ));
    }
    
    public Result executeStrategy(StrategyType type, Input input) {
        Strategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("不支持的策略类型: " + type);
        }
        
        return strategy.execute(input);
    }
}
```

### 2. 观察者模式模板

#### Spring 事件模板
```java
// 事件定义
public class CustomEvent extends ApplicationEvent {
    private final Object data;
    private final String eventType;
    
    public CustomEvent(Object source, Object data, String eventType) {
        super(source);
        this.data = data;
        this.eventType = eventType;
    }
    
    public Object getData() {
        return data;
    }
    
    public String getEventType() {
        return eventType;
    }
}

// 事件发布者
@Service
@RequiredArgsConstructor
public class EventPublisher {
    
    private final ApplicationEventPublisher eventPublisher;
    
    public void publishCustomEvent(Object data, String eventType) {
        CustomEvent event = new CustomEvent(this, data, eventType);
        eventPublisher.publishEvent(event);
    }
}

// 事件监听器
@Component
@RequiredArgsConstructor
@Slf4j
public class EventListener {
    
    @EventListener
    @Async
    public void handleCustomEvent(CustomEvent event) {
        log.info("处理自定义事件: type={}, data={}", 
            event.getEventType(), event.getData());
        
        // 异步处理事件
        processEvent(event);
    }
    
    @EventListener
    @Async
    @Order(1)
    public void handleCustomEventWithOrder(CustomEvent event) {
        log.info("优先处理事件: type={}", event.getEventType());
    }
    
    private void processEvent(CustomEvent event) {
        // 具体的事件处理逻辑
    }
}
```

### 3. 命令模式模板

#### 命令接口和实现模板
```java
// 命令接口
public interface Command {
    void execute();
    void undo();
    boolean canUndo();
}

// 具体命令实现
@Component
public class CreateEntityCommand implements Command {
    
    private final Repository repository;
    private final Entity entity;
    private boolean executed = false;
    
    public CreateEntityCommand(Repository repository, Entity entity) {
        this.repository = repository;
        this.entity = entity;
    }
    
    @Override
    public void execute() {
        if (!executed) {
            repository.save(entity);
            executed = true;
            log.info("执行创建实体命令: id={}", entity.getId());
        }
    }
    
    @Override
    public void undo() {
        if (executed) {
            repository.deleteById(entity.getId());
            executed = false;
            log.info("撤销创建实体命令: id={}", entity.getId());
        }
    }
    
    @Override
    public boolean canUndo() {
        return executed;
    }
}

// 命令调用者
@Service
@RequiredArgsConstructor
@Slf4j
public class CommandInvoker {
    
    private final Stack<Command> commandHistory = new Stack<>();
    
    public void executeCommand(Command command) {
        try {
            command.execute();
            commandHistory.push(command);
            log.info("命令执行成功");
        } catch (Exception e) {
            log.error("命令执行失败", e);
            throw new CommandExecutionException("命令执行失败", e);
        }
    }
    
    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            if (lastCommand.canUndo()) {
                lastCommand.undo();
                log.info("命令撤销成功");
            } else {
                log.warn("命令无法撤销");
                commandHistory.push(lastCommand);
            }
        } else {
            log.warn("没有可撤销的命令");
        }
    }
}
```

### 4. 模板方法模式模板

#### 抽象模板类模板
```java
// 抽象模板类
public abstract class DataProcessor<T, R> {
    
    public final R process(T data) {
        validateInput(data);
        T processedData = preProcess(data);
        R result = doProcess(processedData);
        R finalResult = postProcess(result);
        logResult(finalResult);
        return finalResult;
    }
    
    protected void validateInput(T data) {
        if (data == null) {
            throw new IllegalArgumentException("输入数据不能为空");
        }
    }
    
    protected T preProcess(T data) {
        log.info("开始预处理数据");
        return data;
    }
    
    protected abstract R doProcess(T data);
    
    protected R postProcess(R result) {
        log.info("开始后处理结果");
        return result;
    }
    
    protected void logResult(R result) {
        log.info("数据处理完成");
    }
}

// 具体实现类
@Component
public class UserDataProcessor extends DataProcessor<UserEntity, UserResponse> {
    
    @Override
    protected UserResponse doProcess(UserEntity user) {
        log.info("处理用户数据: userId={}", user.getId());
        
        UserResponse response = UserResponse.builder()
            .id(user.getId())
            .username(user.getUsername())
            .email(user.getEmail())
            .status(user.getStatus())
            .createTime(user.getCreateTime())
            .build();
        
        // 数据验证
        if (response.getEmail() == null || !response.getEmail().contains("@")) {
            throw new DataValidationException("邮箱格式不正确");
        }
        
        return response;
    }
    
    @Override
    protected UserResponse postProcess(UserResponse result) {
        // 添加额外的处理逻辑
        result.setDisplayName(result.getUsername().toUpperCase());
        return result;
    }
}
```

## Spring 特有模式模板

### 1. 依赖注入模板

```java
// 服务接口
public interface Service {
    String process(String input);
}

// 服务实现
@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceImpl implements Service {
    
    private final Repository repository;
    private final CacheService cacheService;
    private final NotificationService notificationService;
    
    @Override
    @Transactional
    public String process(String input) {
        // 业务逻辑
        String result = repository.findByInput(input);
        
        // 缓存结果
        cacheService.put("result:" + input, result);
        
        // 发送通知
        notificationService.notify("处理完成: " + input);
        
        return result;
    }
}
```

### 2. 配置模式模板

```java
// 配置类
@Configuration
@EnableConfigurationProperties({AppProperties.class, DatabaseProperties.class})
public class ApplicationConfig {
    
    @Bean
    @ConditionalOnProperty(name = "app.cache.enabled", havingValue = "true", matchIfMissing = true)
    public CacheManager cacheManager(AppProperties appProperties) {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
            .maximumSize(appProperties.getCache().getMaximumSize())
            .expireAfterWrite(appProperties.getCache().getExpireAfterWrite())
            .recordStats());
        return cacheManager;
    }
    
    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

// 配置属性
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
    
    private Database database = new Database();
    private Cache cache = new Cache();
    private Security security = new Security();
    
    @Data
    public static class Database {
        private String url;
        private String username;
        private String password;
        private int maxPoolSize = 20;
        private int minPoolSize = 5;
        private Duration connectionTimeout = Duration.ofSeconds(30);
    }
    
    @Data
    public static class Cache {
        private boolean enabled = true;
        private long maximumSize = 1000;
        private Duration expireAfterWrite = Duration.ofMinutes(30);
    }
    
    @Data
    public static class Security {
        private String secretKey;
        private Duration tokenExpiration = Duration.ofHours(24);
        private boolean enableCors = true;
    }
}
```

## 测试模板

### 1. 单元测试模板

```java
@ExtendWith(MockitoExtension.class)
class StrategyContextTest {
    
    @Mock
    private Strategy strategyA;
    
    @Mock
    private Strategy strategyB;
    
    private StrategyContext strategyContext;
    
    @BeforeEach
    void setUp() {
        when(strategyA.getType()).thenReturn(StrategyType.TYPE_A);
        when(strategyB.getType()).thenReturn(StrategyType.TYPE_B);
        
        strategyContext = new StrategyContext(Arrays.asList(strategyA, strategyB));
    }
    
    @Test
    @DisplayName("应该执行正确的策略")
    void shouldExecuteCorrectStrategy() {
        // Given
        Input input = new Input("test");
        Result expectedResult = new Result("success");
        when(strategyA.execute(input)).thenReturn(expectedResult);
        
        // When
        Result result = strategyContext.executeStrategy(StrategyType.TYPE_A, input);
        
        // Then
        assertThat(result).isEqualTo(expectedResult);
        verify(strategyA).execute(input);
        verify(strategyB, never()).execute(any());
    }
    
    @Test
    @DisplayName("应该抛出异常当策略不存在时")
    void shouldThrowExceptionWhenStrategyNotFound() {
        // When & Then
        assertThatThrownBy(() -> strategyContext.executeStrategy(StrategyType.UNKNOWN, new Input("test")))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("不支持的策略类型: UNKNOWN");
    }
}
```

### 2. 集成测试模板

```java
@SpringBootTest
@TestPropertySource(properties = {
    "app.cache.enabled=true",
    "app.database.url=jdbc:h2:mem:testdb"
})
class DesignPatternIntegrationTest {
    
    @Autowired
    private StrategyContext strategyContext;
    
    @Autowired
    private CommandInvoker commandInvoker;
    
    @Test
    @DisplayName("策略模式集成测试")
    void testStrategyPattern() {
        // Given
        Input input = new Input("integration test");
        
        // When
        Result result = strategyContext.executeStrategy(StrategyType.TYPE_A, input);
        
        // Then
        assertThat(result).isNotNull();
        assertThat(result.isSuccess()).isTrue();
    }
    
    @Test
    @DisplayName("命令模式集成测试")
    void testCommandPattern() {
        // Given
        Entity entity = new Entity("test");
        Command command = new CreateEntityCommand(null, entity);
        
        // When & Then
        assertThatCode(() -> commandInvoker.executeCommand(command))
            .doesNotThrowAnyException();
    }
}
```

---

*最后更新时间：2024年1月*
*版本：v2.0.0*
