# 工程简介
### springboot 整合 springfox 3.0.0，内部实现是 swagger3，生成 REST API。  
swagger 地址：http://127.0.0.1:9090/swagger-ui/index.html  

knife4j 相关依赖：knife4j-spring-boot-starter，是为了提供一个类似普通管理后台的前端 UI，来替代 swagger 原生的前端页面，内部包含了 springfox-boot-starter 3.x 相关依赖，外部无需再引用，避免版本冲突。  
knife4j 地址：http://localhost:9090/doc.html#/  

swagger 可以配合 Apifox 使用，将生成的 api 导入 Apifox。在 swagger 的页面上有 api doc 地址：http://127.0.0.1:9090/v3/api-docs，在 Apifox 中使用 URL 导入即可。  
# 延伸阅读
### 1.引入依赖

```xml
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>
```
或者  

```xml
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <version>3.0.3</version>
        </dependency>
```

### 2.Swagger 配置类 SwaggerConfiguration
使用注解  
```java
@Configuration
@EnableOpenApi
public class SwaggerConfiguration implements WebMvcConfigurer {
    
}
```

### 3.在 controller 类、方法及实体类 VO 上标注 @Apixxx 注解

### 4.springfox swagger security 相关（todo） 

### 重要注解
@Api  
标记一个类是 swagger resource，默认情况下 swagger 只会包含有 @Api 注解的类；  
value 属性：有关 resource 的简短描述；  

@ApiOperation  
标记一个 swagger operation，swagger operation = HTTP method + path;  
value 属性：有关 operation 的简短描述；  

@ApiModel  
标记 swagger operation 中用到的实体类；  

@ApiModelProperty  
用于标注 @ApiModel 实体类中的属性；  
name 属性：字段名；  
value 属性：字段描述；  
dataType 属性：字段类型；  
required 属性：在 swagger UI 上显示红色的 "required"，并不能代替 @RequestParam 中的 required 属性；  
position 属性：在 swagger UI 上显示的字段先后次序；  
example 属性：字段值举例；  

@ApiParam  
只可以用于 JAX-RS 1.x/2.x annotations 标注的方法，表示 request param 类型的参数，JAX-RS 即 Java API for RESTful Web Services，比如：@GET, @POST 等标注的方法；  

@ApiImplicitParam  
必须配合 @ApiImplicitParams 使用，也是标注在方法上，表示 request param，与 @ApiParam 的不同是，@ApiImplicitParam 还可以用于 servlet 等 non-JAX-RS 方法上；  

@ApiImplicitParams  

@ApiIgnore  
标注在类、方法、参数上，使被标注对象不显示在 swagger UI 上。  