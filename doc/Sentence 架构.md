[TOC]

# 编写者

| 编写者 | 版本号 | 编写/修订时间 | 说明 |
| ------ | ------ | ------------- | ---- |
| xiaofeng | v1.0   | 2021-01-26    | 创建 |



# 前言

本文档是对Sentence 平台整体架构设计和开发流程总体说明，但不包括各种开发框架和组件技术讲解说明。同时希望开发团队可以通过本文档从宏观的角度去理解DB SUPER SERVICE 平台的架构模式和架构设计原则。

# 架构本质



# 架构设计原则

架构的本质是高内聚低耦合，在解决

SRP：单一职责原则

OCP：开闭原则

LSP：里氏替换原则

ISP：接口隔离原则

DIP：依赖反转原则

LOP：迪米特法则(最少知识原则)



# 应用分层--重点

> 重点说明：希望每个开发人员能够彻底理解领域分层规范概念。在软件开发中，其实设计比代码要来得重要的多，我们对架构和代码的追求就是尽可能的优雅、整洁、高可用、高内聚低耦合、可扩展性强，所以我们微服务架构和代码要尽量遵从上面的六大设计原则。:handshake:

## 阿里巴巴规范-参考

1、【推荐】图中默认上层依赖于下层，箭头关系表示可直接依赖，如：开放接口层可以依赖于Web层，也可以直接依赖于Service层，依此类推：

![](http://static.iocoder.cn/ef0d24cfaecdbe703ad646e09e697454)

1、开放接口层：可直接封装Service方法暴露成RPC接口；通过Web封装成http接口；进行网关安全控制、流量控制等。

2、终端显示层：各个端的模板渲染并执行显示的层。当前主要是velocity渲染，JS渲染，JSP渲染，移动端展示等。

3、Web层：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。

4、Service层：相对具体的业务逻辑服务层。

5、Manager层(和微服务的聚合层类似的)：通用业务处理层，它有如下特征：

​	1） 对第三方平台封装的层，预处理返回结果及转化异常信息；

​	2） 对Service层通用能力的下沉，如缓存方案、中间件通用处理；

​	3） 与DAO层交互，对多个DAO的组合复用。

DAO层：数据访问层，与底层MySQL、Oracle、Hbase等进行数据交互。

外部接口或第三方平台：包括其它部门RPC开放接口，基础平台，其它公司的HTTP接口。

2、【参考】（分层异常处理规约）在DAO层，产生的异常类型有很多，无法用细粒度的异常进行catch，使用catch(Exception e)方式，并throw new DAOException(e)，不需要打印日志，因为日志在Manager/Service层一定需要捕获并打印到日志文件中去，如果同台服务器再打日志，浪费性能和存储。在Service层出现异常时，必须记录出错日志到磁盘，尽可能带上参数信息，相当于保护案发现场。如果Manager层与Service同机部署，日志方式与DAO层处理一致，如果是单独部署，则采用与Service一致的处理方式。Web层绝不应该继续往上抛异常，因为已经处于顶层，如果意识到这个异常将导致页面无法正常渲染，那么就应该跳转到友好错误页面，加上用户容易理解的错误提示信息。开放接口层要将异常处理成错误码和错误信息方式返回。

3、【参考】分层领域模型规约：

- DO（Data Object）：与数据库表结构一一对应，通过DAO层向上传输数据源对象。
- DTO（Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象。
- BO（Business Object）：业务对象。由Service层输出的封装业务逻辑的对象。
- AO（Application Object）：应用对象。在Web层与Service层之间抽象的复用对象模型，极为贴近展示层，复用度不高。
- VO（View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。
- Query：数据查询对象，各层接收上层的查询请求。注意超过2个参数的查询封装，**禁止使用Map类来传输**。

## 关于微服务分层规范

看到阿里巴巴的规范之后，竟然有这么多 POJO ？！每个公司的业务复杂度不同，架构不同，所以 POJO 的选择实际会有不同。当然，原则上是 Service 不将 DO 数据库实体从 Service 暴露到 Controller ，避免后续数据库设计的变化，影响暴露出去的方法。

> 我们按照自下而上，来看看各层的选择。分层使用的是常规的贫血模型。

- 按照 Controller、Service、DAO 分成三层，去掉 Manager 层。
  - 大多数业务场景下，无需与第三方平台对接。
  - 当然，如果需要和第三方对接，还是会封装成 Client ，例如说 DataExaSdkClient和 第三方平台的对接。所以实际还是有“隐藏”的 Manager 层。
- DAO 层
  - 入参，使用 DO（Data Object）。
  - 出参，使用 DO（Data Object）。
- Service 层
  - 入参，使用 DTO（Data Transfer Object）。
    - 需要加上 [Bean Validation](https://www.ibm.com/developerworks/cn/java/j-lo-jsr303/index.html) 注解，从而校验参数。
    
    - 需要加上 [Swagger](https://github.com/springfox/springfox/tree/master/springfox-swagger2) API 注解，因为后续 Controller 很大可能性会使用到它，从而生成 API 文档。更细的原因，我们在 Controller 层一起讲。
    
    - ```java
      示例：AdminAddDTO 和 AdminUpdateDTO 。
      ```
  - 出参，使用 BO（Business Object）。
    - 本来考虑使用 DTO ，考虑到区分，所以使用了 BO 。当然，使用 DTO 的，问题不大。
    
    - 需要加上 [Swagger](https://github.com/springfox/springfox/tree/master/springfox-swagger2) API 注解，原因同 DTO 。
    
    - ```
      示例：AdminBO。
      ```
    
  
- Controller 层
  - 入参，使用 DTO（Data Transfer Object）。
    - 因为前后端分离之后，Controller 大多数情况下，基本是将 Service 进行封装，提供 API 接口。所以大多数情况，Service DTO 可以重用，所以就默许使用 Service DTO 。
    - 当然，如果 Service DTO 不够用的情况下，可以自己在创建下 Controller DTO 。
    - 所以，因为是这样的设定，我们就要求 Service DTO 上，增加 Swagger API 注解。
    - 
  - 出参，使用 VO（Value Object）。
    - 原因，也是同 Controller 入参。

## 分层领域规约优缺点

### 系统不分层领域存在问题

目前系统接口不统一且高耦合，一个DO实体除了作为数据库层的数据操作外同时又担任着前端API接口层请求参数实体和返回对象实体等。试想一下，如果数据库添加了一个时间字段，API接口层不需要该字段,那么使用[Swagger](https://github.com/springfox/springfox/tree/master/springfox-swagger2) API 文档中就会多出个时间字段，很显然给前端人员造成了困扰，增加了沟通成本。最好的方案就是分而治之。

### 如何解决

#### 方案一

1.优点：平台级统一管理

提升到平台级别，在公司中会有多个项目，可以统一的管理。

2.缺点: 可能需要手动去入接口

放弃[Swagger](https://github.com/springfox/springfox/tree/master/springfox-swagger2) API 在线接口文档，搭建一套在线接口文档，每个接口请求参数和返回对象属性手动添加说明。有何问题？很显然苦力活、效率低、维护成本高。但也能解决不分层且不给前端造成困扰。当然，应该也有开源的平台适合导入swagger API ,找个时间深入研究下。



#### 方案二

1. 每个POJO都有独立的职责及职责范围，我们基于单一职责的原则进行设计。

2. 通过多个POJO的设计，将业务功能解耦，同时层次感更强。

3. 灵活方便快速扩展，维护成本低。

4. 存在的问题：分层领域过细会造成相同属性的文件过多，那么文件如何进行复制？我们采用代码生成器 + [mapstruct](http://mapstruct.org/) 。

   代码生成器可以根据数据库表快速生成各种分层领域的类文件，避免程序员每个类都手动编写，提高开发效率，程序员只需在需要修改的文件中进行简单的调整修体改即可。

   [mapstruct](http://mapstruct.org/)  是一个对象复制框架，可以快速实现两个文件中相同属性COPY，比Spring 的 BeanUtils.copy更加灵活和高效。我们不能说它是最好用的，但是的确是（并且，效果还非常非常非常的高)。具体示例如下：

   ```java
   @Mapper
   public interface AdminConvert {
   
       AdminConvert INSTANCE = Mappers.getMapper(AdminConvert.class);
   
       @Mappings({})
       AdminInfoVO convert(AdminSecurityContext adminSecurityContext);
   
       @Mappings({})
       AdminVO convert(AdminBO adminBO);
   
       @Mappings({})
       List<AdminRoleVO> convert(List<RoleBO> roleList);
   
       @Mappings({})
       PageResult<AdminVO> convertAdminVOPage(PageResult<AdminBO> page);
   
       List<AdminVO.Role> convertAdminVORoleList(Collection<RoleBO> list);
   ```

# 数据库

## 数据库设计规范

后续整理套数据库设计规范

## 数据库迁移

​	在传统的开发模式中，数据库由专门的运维团队或者DBA来维护，要对数据库进行修改需要向DBA申请，告之迁移内容，最后由DBA负责数据库变更实施。

​	由于公司目前没有专业DBA和运维人员，所以数据库同步需要由开发人员完成。

​	在微服务场景下，数据库被包含在单个服务的边界之内，因此基于内聚性原则，数据库的变更最好也与项目代码一道维护在代码库中。
采用了Flyway作为数据库迁移工具，加入了Flyway依赖后，在src/main/resources/db/migration目录下创建迁移脚本文件即可：

```java
resources/
├── db
│   └── migration
│       ├── V1__init.sql
│       └── V2__create_product_table.sql
        
```

# 多环境构建

在软件的开发流程中，我们需要将软件部署到多个环境，经过多轮验证后才能最终上线。在不同的阶段中，软件的运行态可能是不一样的，比如，本地开发时可能将所依赖的第三方系统；持续集成构建时可能使用的是测试用的内存数据库等等。为此，推荐采用以下环境：

- dev：用于前端开发联调
- beta：集成测试环境
- test:   系统测试环境
- staging：类生产环境，用于功能验收
- prod：正式的生产环境

## Jenkins 多环境发布流程

> 说明：由于微服务服务之间相互依赖调用,如果某个服务宕掉，那么在没有熔断的情况下，为了避免分布式系统级联故障，所以每个服务发布持续集成从打包到最后的项目启动成功尽量控制在平均30秒左右。基于单一职责的设计原则，在构建部署的时候只做一件事，从GITLAB上拉取分支代码打包启动。对多环境打包配置文件采用的策略的是在项目中提前创建好上面的六个分支环境，发布打包过程中利用maven 插件对配置文件进行复制替换，才能达到快速发布启动。

### 项目中准备流程

<img src="http://xjf.375u.cn/%E9%A1%B9%E7%9B%AE%E7%86%9F%E6%82%89%E6%B5%81%E7%A8%8B%E5%9B%BE.png" alt="发布准备流程-项目" style="zoom: 33%;" />

### 构建部署(流程需要优化下,从权限等开始画原型)

<img src="http://xjf.375u.cn/%E5%8F%91%E5%B8%83%E6%B5%81%E7%A8%8B%20%282%29.png" alt="发布流程 (2)" style="zoom: 67%;" />



# GIT 工作流程

> 参考：http://blog.didispace.com/content/images/posts/gitflow-info-4.png
>
> ​			https://www.cnblogs.com/xirongliu/p/4584653.html

## 分支模型

有个很成熟的叫「Git Flow」的分支模型，它能够应对 99% 的场景，剩下的那 1% 留给几乎不存在的极度变态的场景。

需要注意的是，**它只是一个模型，而不是一个工具；你可以用工具去应用这个模型，也可以用最朴实的命令行。所以，重要的是理解概念，不要执着于实行的手段。**

简单说来，Git Flow 就是给原本普普通通的分支赋予了不同的「职责」：

- 产品分支：**master**   -------最为稳定功能最为完整的随时可发布的代码。
- 修复补丁分支前缀：hotfix/     -----修复线上代码的 bug。

- 开发分支：**develop**  ------永远是功能最新最全的分支。


- 功能分支前缀：feature/  -------某个功能点正在开发阶段。


- 发布版分支前缀：release/  -------发布定期要上线的功能。

看到上面的「master」和「develop」加粗了吧？代表它们是「主要分支」，其他的分支是基于它们派生出来的。**主要分支每种类型只能有一个，派生分支每个类型可以同时存在多个。**各类型分支之间的关系用一张图来体现就是：

![](https://upload-images.jianshu.io/upload_images/13374755-8c7cd61d6dfa9725.png?imageMogr2/auto-orient/strip|imageView2/2/w/614/format/webp)

## 工具选择

一直不喜欢「＊＊最好用」这种命题，主观性太强，不会有一个结论。对于工具的选择，我一直都是秉承「哪个能更好地解决问题就用哪个」这个原则。所以，只要不影响到团队，用什么工具都是可以接受的。但根据多数开发人员的素质情况来看，建议使用图形化工具，例如 SourceTree。如果想用命令行，可以啊！先在心里问下自己：「我 Git 牛逼不？会不会惹麻烦给别人？」

在团队中应用 Git Flow 时，推荐使用 SourceTree 与 GitLab 配合的形式：

1. 用 SourceTree 创建 feature 等分支以及本地的分支合并、删除；
2. 用 GitLab 做代码审核和远程的分支合并、删除。

SourceTree 和 GitLab 应该是相辅相成的存在，而不是互相取代。

## 事前准备

### SourceTree

下载安装 SourceTree 软件

### GitLab

在创建项目仓库后一定要把主要分支，也就是 master 和 develop 给保护起来。为它们设置权限，只有项目负责人可以进行推送和删除等操作。

## 开发流程

![](http://blog.didispace.com/content/images/posts/gitflow-info-1.png)

## 开发功能

在确定发布日期之后，将需要完成的内容细分一下分配出去，负责某个功能的开发人员利用 **SourceTree** 所提供的 Git Flow 工具创建一个对应的 feature 分支。如果是多人配合的话，创建分支并做一些初始化工作之后就推送创建远程分支；否则，直到功能开发完毕要合并进 develop 前，不要创建远程分支。功能开发完并自测之后，先切换到 develop 分支将最新的代码拉取下来，再切换回自己负责的 feature 分支把 develop 分支的代码合并进来。合并方式参照上文中的「合并」，如果有冲突则自己和配合的人一起解决。然后，到 GitLab 上的项目首页创建合并请求（merge request）。

后续补图

GITLAB上的请求合并

1、「来源分支」选择要被合并的 feature 分支且「目标分支」选择 develop 分支后点击「比较分支」按钮，在出现的表单中将处理人指派为项目负责人。

2、项目负责人在收到合并请求时，应该先做下代码审核看看有没有明显的严重的错误(最好是启动和功能验证一下)；有问题就找负责开发的人去修改，没有就接受请求并删除对应的 feature 分支。

3、在将某次发布的所需功能全部开发完成时，就可以交付测试了。

![](http://blog.didispace.com/content/images/posts/gitflow-info-3.png)



## 测试功能

负责测试的人创建一个 release 分支部署到测试环境进行测试；若发现了 bug，相应的开发人员就在 release 分支上或者基于 release 分支创建一个分支进行修复。

## 发布上线

当确保某次发布的功能可以发布时，负责发布的人将 release 分支合并进 master 和 develop 并打上 tag，然后打包发布到线上环境。

建议打 tag 时在信息中详细描述这次发布的内容，如：添加了哪些功能，修复了什么问题。

![](http://blog.didispace.com/content/images/posts/gitflow-info-4.png)

## 修复问题

当发现线上环境的代码有小问题或者做些文案修改时，相关开发人员就在本地创建 hotfix 分支进行修改，具体操作参考「开发功能」。

如果是相当严重的问题，可能就得回滚到上一个 tag 的版本了。

![](http://blog.didispace.com/content/images/posts/gitflow-info-5.png)

## 额外说明

这里所提到的事情，虽非必需，但知道之后却会如虎添翼。

### 分支命名

除了主要分支的名字是固定的之外，派生分支是需要自己命名的，这里就要有个命名规范了。强烈推荐用如下形式：

- feature——按照功能点（而不是需求）命名；
- release——用发布时间命名，可以加上适当的前缀；
- hotfix——GitLab 的 issue 编号或 bug 性质等。

另外还有 tag，用语义化的版本号命名。

### 发布日期

发布频率是影响开发人员与测试人员的新陈代谢和心情的重要因素之一，频繁无规律的发布会导致内分泌失调、情绪暴躁，致使爆粗口、砸电脑等状况出现。所以，确保一个固定的发布周期至关重要！

在有一波或几波需求来临之时，想挡掉是不太可能的，但可以在评审时将它（们）分期，在某个发布日之前只做一部分。这是必须要控制住的！不然任由着需求方说「这个今天一定要上」「那个明天急着用」的话，技术人员就等着进医院吧！

# 日志处理

在多节点部暑场景下，各个节点的日志是分散的，为此可以引入诸如ELK之类的工具将日志统一输出到ElasticSearch中。或者使用如Splunk和Graylog等。

# 统一异常处理

考虑如下几点：

- 向客户端提供统一的异常返回
- 异常信息中应该包含足够多的上下文信息，最好是结构化的数据以便于客户端解析
- 不同类型的异常应该包含唯一标识，以便客户端精确识别

# 自动化测试分类

> 通常一个项目中有成千上万的方法，以前一般的做法是写一些测试代码看输出结果，然后由自己来判断结果是否正确，使用JUnit的好处就是这个结果是否正确的判断是由JUnit来完成的。我们只要关注结果是否正确就可以了。测试框架可以帮助我们对编写的程序进行有目的性的测试，减少代码中的bug，使用断言机制直接将预期结果与实际结果对比，确保对结果的可预知性。

在当前的微服务和前后端分离的开发模式下，后端项目仅提供纯粹的业务API，而不包含UI逻辑，因此后端项目不会再包含诸如WebDriver的重量级端到端测试。同时，后端项目作为向外提供业务功能的独立运行单元，在API级别也应该有相应的测试。
此外，程序中有些框架性代码，要么是诸如Controller之类的技术性框架代码，要么是基于某种架构风格的代码（比如DDD实践中的ApplicationService），这些代码**一方面并不包含业务逻辑，一方面是很薄的一个抽象层（即实现相对简单），用单元测试来覆盖显得没有必要**，因此可以不为此编写单独的单元测试。
再者，程序中有些重要的组件性代码，比如访问数据库的Repository或者分布式锁，使用单元测试实际上“测不到点上”，而使用API测试又显得在分类逻辑上不合理，为此我们可以专门创建一种测试类型谓之组件测试。基于以上，我们可以对自动化测试做个分类：

- 单元测试：核心的领域模型，领域服务类、业务服务类等；目录：src/test/java
- 组件测试：不适合写单元测试但是又必须测试的类，比如Repository类，在有些项目中，这种类型测试也被称为集成测试； 目录：src/componentTest/java
- API测试: 模拟客户端测试各个API接口.  目录：src/apiTest/java

需要注意的是，这里的API测试更多强调的是对业务功能的测试，有些项目中可能还会存在契约测试和安全测试等，虽然从技术上讲都是对API的访问，但是这些测试都是单独的关注点，因此建议分开对待。

## IDEA配置测试模板

![](http://xjf.375u.cn/1576572291%281%29.png)

## spring boot 使用单元测试

```
#引入JAR
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

```

```
例子
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

	@Autowired
	private IUserService userService;

	@Test
	public void shouldGetUserPermissionLabels() {
		UserBO userBO = new UserBO();
		userBO.setAuthorityType(1);
		userBO.setCellphone("0592");
		userService.getUserPermissionLabels(userBO);
	}
}
```



# 微服务架构设计与实践

## 微服务架构拆分

### 拆分说明

微服务拆分方式：业务垂直拆分 + 功能水平拆分

只有通过这两种方式拆分够不够？这主要取决于业务功能，考虑一下某个功能的读写频率，如，用户注册(写)和登录查询(读)，在互联网项目中通常是读多写少，很显然写更加重要，为了服务不相互影响，可进行API的粒度拆分，将写和读拆成各自不同的服务。

垂直和拆分图

### 业务垂直拆分

APP -->网关层 --> 用户业务逻辑层-->用户数据访问层---> DB

### 功能水平拆分

APP -->网关层 -- > 业务逻辑层(用户业务逻辑、商品业务逻辑、交易业务逻辑层) -->数据访问层（用户数据访问、商品数据访问层、交易数据访问） -->DB

## 微服务架构本质

### 2个维度

按照业务垂直拆分和按照功能水平拆分，业务拆分比较难，需要熟悉整块业务。比如：用户模块，包括边界的梳理，哪些表要放在哪个库中等。

### 业务架构

所以本质上讲微服务架构就是业务架构。

### 组织架构

**这段举例需要在优化下。。。。。**

#### 举例一

一个公司的组织架构分为：产品部门、研发部门、财务部门，这是按职能部门划分，如果以产品交互为核心，要做好一个产品就必须要跨部门合作， 这样一有问题就容易扯皮。

如果微服务的拆分中把业务逻辑层和数据访问聚合在一个服务中是否类似于职能部门的划分？一个服务要接受前端API 层的服务调用，接受其它服务RPC的远程调用。如果RPC 服务接口挂了，导致服务器挂了，就会影响到API层 的接口调用。这也就是出现扯皮的作用。

#### 举例二

如果把公司的组织架构分为产品事业部、研发事业部，产品事业部下有：产品A组，PRD组，设计组等。研发事业部有：PM组，研发组，研发C组等。也就是中间多了层事业部。

如果微服务在多一层业务逻辑层聚合服务(相当于事业部)，那就可以在事业部内把产品做好。一个聚合服务(消费者)会调用多个提供者(各个小组)

**所以，最好的方式还是按照假设二的方式进行设计。**

## 微服务设计目的

- 项目快速迭代
- 项目持续交互

微服务架构最根本的哲学就是快速迭代、持续交付和降本增效，这就是架构第一性原理，如果没有办法达到这样的效果，那可能是架构的设计层面存在问题。

## 不适合微服务架构的场景

### 需求层面

项目变化频率特别慢，一年功能都不会变动一次,比如：OA、考勤系统、EPR、工单等不经常变动的系统。当然 ，如果考虑商业性的因素，那可另当别论。

### 性能层面

如果对性能极致苛刻的情况下，没有必要拆分微服务，因为微服务是多少会有长链路请求。一个复杂的功能要请求调用多个服务。从高可用设计原则层面分析，能不跨JVM 的就不要跨JVM。

### 数据一致性层面

CAP 定律

- AP模型 ：服务性能要求高，不追求一致性，保证数据最终一致性。比如：通过消息异步化，实现某些功能的最终一致性
- CP 模型 ：服务性能要求不一定高，但是要追求强一致性。CP模型在微服务中很难做到，正常也只有一两个接口实现CP模型吧，比如：金额交易。
- AC 模型：实际使用过程中AC模型 是不存在的。

过于追求 CP 模型强一致性，不适合微服务，微服务中都是AP 模型，最终一致性。

##  分布式设计与实践

待定

# 超级码场云平台架构设计

## 项目命名规范

项目名称：项目名 + "-" + 模块名 

`正例：sentence-auth`

`反例：sentence_auth/sentence-Auth`

模块命名：

`例子：system-service-api`

​			'system-service-app`

## 服务拆分说明

### 垂直拆分

​      服务垂直拆分方向：业务维度

​      数据库垂直拆分方向：分库

### 水平拆分

​	  服务水平拆分方向：功能维度

 	 数据库水平拆分方向：分表

​	常见微服务拆分有垂直拆分和水平拆分，垂直拆分通常是一个服务对应着一个数据库，水平拆分则将项目中所有的Controllert拆成一个服务、数据库DAO拆成服务、service拆成服务等。微服务的拆分并没有唯一标准的答案，而是需要根据公司业务、场景、团队技术水平、软硬件资源等各种因素综合考虑，毕竟IT界的那句至理名言不是说了么，**“不以实际业务场景出发考虑的架构都是耍流氓”**。

​	事实上大部分微服务还是垂直拆分的居多，当然，一个项目也是同时有垂直服务和水平服务，还是那句话，取决于业务的大小和复杂度(比如高并发、大数据、业务逻辑很复杂等需要考虑限流、数据库等因素)。

​	微服务项目结构不是一成不变，也不可能是完全教科书式一板一眼的结构，**严肃问题**：如果想玩技术可以自己利用空余时间把各种拆分法从0到1玩一遍。

​    无论微服务项目结构如何变化，只要（**理解**、**理解**、**理解**）两个概念即可：**消费者**和**提供者**，什么是消费者和提供者?他们规范是什么？技术这玩意是说不完的，所以这里就不拉开讲了，还请度娘一下，娘娘会告诉你的，如果没搞明白，那就唱首凉凉送给自己。:anguished:

​    以下列出两种不同的微服务拆分方案对比：

| 名称                       | 区别                                                         | 优点                                                         | 缺点                                                         | 适合项目场景                                                 |
| -------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 消费者和提供者在同一个服务 | 消费者和提供者在聚合在同一个服务中，通过maven 模块进行区分   | 减少服务器资源，减少对JVM的过渡消费()                        | 耦合高                                                       | 1. 适应95%以上的不同业务系统，大部分的系统都没有什么流量。服务也不多，服务器资源也不多。<br />2.遗留系统改造，在短时间内拆成微服务，如果把消费者拆成独立服务，那会增加改造风险，时间和功能上都会受影响。所以，还是以最粗粒度进行拆分。<br />当然，即时消费者和提供者放在同一个服务中，也要学会按照模块化的设计，将两者进行区分。 |
| 消费者和提供者独立服务     | 占服务器资源，需要多部暑几个消费者，通常拆分一个大模块为一个消费者--业务逻辑层 | 可扩展性更强，尤其在业务高速发展的过程中，能够快速进行横纵向扩展，达到降本增效的成果等。<br/>单一职责。 | 在项目规模不大的情况下有点过渡设计。<br />复杂的业务功能会造成链路请求过长。 | 如果业务较为复杂或者有点流量的业务系统可以按照这种方式进行拆分。<br /> |

## 超级码场架构图

### 业务架构图

参考概要设计架构图

### 技术架构图

![技术架构图](http://xjf.375u.cn/DataExa%20Sati%E5%BE%AE%E6%9C%8D%E5%8A%A1%E6%8A%80%E6%9C%AF%E6%9E%B6%E6%9E%84%E5%9B%BE%20%281%29.png)

## 架构升级优化说明

### 网关路由信息动态化

#### 优化背景

在本地开发中，服务的运行模式应和测试环境及生产环境一致，否则会影响到不同环境的发布调试。所以，开发环境的中的模式是用统一个注册中心，如果服务较多需要对注册中心做集群，而不是每个开发人员本地自行启动一个注册中心，本地启动只适合于小项目。

统一的注册中心，就会出现启动相同的服务会互载均衡，给DEBUG调试造成困难。所以，**解决方案是在网关路由中配置不同不服名称和请求路径，使每个服务都是唯一，网关路由的时候根据不同的path 路由到开发人员本地服务**。此种模式无论项目大小均适合。具体配置如下：

~~~
routes:
        # 系统基础服务
        - id: system-service-xiaofeng
          uri: lb://system-service-xiaofeng
          order: 8002
          predicates:
            - Path=/SystemServiceXiaofeng/api/system/**
          filters:
            - StripPrefix=3
        #系统基础服务 xiaofeng 本地服务有
        - id: system-service-huangjiaxi
          uri: lb://system-service-huangjiaxi
          order: 8003
          predicates:
            - Path=/SystemServiceHuangjiaxi/api/system/**
          filters:
            - StripPrefix=3
~~~

#### 优化方案

问题在于静态路由在人员和服务多的情况下，服务配置信息就会不断的增加，静态路由的弊端就是：

1.配置量信息大 

2.每次都要重启网关服务。

所以，决定将静态路由配置改成动态配置。在数据库创建路由信息表，通过页面可视化的模式进行服务信息动态管理。然后通过redis的订阅模式或SpringBoot 监听进行动态更新。

### 统一Restful API 风格

所有的API 风格都统一改成restful api 风格。

### 项目脚手架

添加成型项目脚手架，统一的maven模块包，统一的配置信息。开发人员在创建微服务的时候可以直接通过脚手架快速创建微服务项目，减少手动创建造成的各种问题，导致服务无法重启。比如：少添加JAR和配置等。

### API 接口 Response 统一风格

返回值统一的规范，包括提供者和消费者

### 代码规范优化

目前使用在此基础上需要添加CheakStyle、FindBug、PMD等插件，对代码统一换行，统一格式化等深度控制。

### 分布式技术推进落地执行

1. 添加分布式ID服务
2. 添加分布式锁
3. 添加分布式事务
4. 添加redis 主从
5. 添加redis 防击穿
6. 添加 日志采集
7. 添加MQ消息队列服务，消息幂等

### 框架依赖包配置优化

对每个服务JAR包应该进行大小的控制，控制在100以内。

### 添加发布心跳机制

添加每次发布后检测服务是否启动成功，虽然可以通过nacos 注册中心查看服务健康状态，但是不同的环境中有不同的权限控制，不是每个开发人员都能登录到NACOS中心，即使可以登录，整个流程效率低下。

### 服务注册添加多环境组

服务注册添加多环境组，而不是每次注册都在public 这个目录下，分本地组和开发组。

### 数据库和redis 监控

添加数据库连接池和慢查询等监控信息，使用阿里巴巴的开源连接池。添加redis 的监控信息。

# 超级码场项目管理

## 开发流程

<img src="http://xjf.375u.cn/%E9%A1%B9%E7%9B%AE%E7%86%9F%E6%82%89%E6%B5%81%E7%A8%8B%E5%9B%BE.png" alt="项目熟悉流程图" style="zoom: 33%;" />



## 项目结构

```

    
```

**

### 项目结构说明

待定

### 项目分层规范说明

还是基于上面说设计原则，一个项目不能只考虑实现功能而忽略掉设计层次，每个开发人员必须要清楚**代码要写在哪里，一个类文件多少行，一个方法最多传多少个参数等**。当然，这是代码风格规范，会通过自动化和插件去进行规范控制，这不是重点，重点的是些概念需要理解。



####  一些存在的问题

 三层架构风格是常见的架构风格，spring mvc 总得会，在这基础下需要熟悉每一层的职责，现在比较大的问题就是业务代码在这三层里随便堆，完全没有去考虑一些边界的问题，比如：controller 层写太多的业务代码，反而service层只写了一行调用DAO层的代码， 本末倒置啊。有什么问题？如果框架延伸扩展，比如，对业务功能进行单元测试，那不是每次都要通HTTP接口去进行测试？什么postman、swagger能上的都上，这样的开发模式测试效率太低了(这是直接给前端人员对接接口使用的,不是用来测试)，如果只想测试业务逻辑又不用想用HTTP进行测试，那应该如何去处理？开发阶段开发人员测试只能在单元测试里完成。

#### 解决方案

本质上还是规范，规范好每一层的职责即可，**controller只处理接口参数、验证返回给前端的数据，service层主要负责业务逻辑代码**。controller只负责调service层接口 ,**不要在controller层里写业务代码**。

正确示例：controller只负责调用方法和参数转换

```
/**
 * 继承写法
 * @author xiaofeng
 */
@RestController
public class UserRpcFacadeController implements IUserFacade {

	@Autowired
	private UserRpcFacadeService userRpcFacadeService;

	/**
	 * 由于继续了IUserFacade类, 所以URL地址也是继承IUserFacade 上接口的URL地址
	 */
	@IgnoreUserToken
	@IgnoreClientToken
	@Override
	public ObjectRestResponse<UserInfoDTO> validate(String username, String password) {
		// 一些参数的转换 和业务service 调用
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();
		final String ipAddress = SecurityUtils.getIpAddress(request);
		//其实不能把request和response带入到service层中去处理业务,破坏了各自的规则 add by xiaofeng
		return userRpcFacadeService.validate(username, password, ipAddress);
	}

	@IgnoreClientToken
	@Override
	public UserInfoDTO getLoginUser(String userId) {
		return userRpcFacadeService.getLoginUser(userId);
	}

	@Override
	public UserDTO getCurrentUser(String userId) {
		return userRpcFacadeService.getCurrentUser(userId);
	}

	@Override
	public PermissionLabelDTO getUserPermissionLabels(UserDTO user) {
		PermissionLabelDTO permissionLabelDTO = new PermissionLabelDTO();
						permissionLabelDTO.setObjects(userRpcFacadeService.getUserPermissionLabels(user));
		return permissionLabelDTO;
	}
}

```

错误示例：把业务逻辑实现写在controller中， 不易扩展

```
@RequestMapping(value = "/rest/s/user/power-get",method = RequestMethod.POST)
	public Result<UserInfoDTO> getLoginUser(){
		User loginUser = null;
		String userId = BaseContextHandler.getUserID();
		if ("".equals(userId) || null== userId) {
			throw new UserInvalidException("获取用户信息失败，请重新登录！");
		}
		final String key = SecurityConstants.USER_TOKEN_KEY + userId;
		String value = (String) redisUtil.get(key);
		try {
			loginUser = MapperUtils.json2pojo(value, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//设置头像信息
		String photoInfo = profilePhotoService.getPhotoInfo(loginUser.getId());
		loginUser.setAvatar(photoInfo);

		List<UserRole> userRoles=userRoleService.findByUserId(loginUser.getId());
		List<Long> roleIds=null;
		if(null!=userRoles){
			roleIds=userRoles.stream().map(l->l.getRoleId()).collect(Collectors.toList());
		}
		List<Menu> menuList=menuService.findMenusByRoleId(roleIds);
		//menuList做排序
		UserInfoDTO userInfo=new UserInfoDTO();
		ReflectObjectUtil.copyToTarget(loginUser, userInfo);
		List<MenusDTO> menusDTOS = UserConvert.INSTANCE.convertMenu(menuService.convert2Tree(menuList));
		userInfo.setMenus(menusDTOS);
		return RespResult.success(userInfo);
	}
```



## code formatter

见项目

代码格式化模版是为了后续统一的代码规范控制。

## IDEA常用插件安装

| 插件名称                       | 说明                            |      |
| ------------------------------ | ------------------------------- | ---- |
| .ignore                        |                                 |      |
| Alibaba Java Coding Guidelines | 阿里巴巴代码规约                |      |
| checkstyle-idea                |                                 |      |
| codeglance                     |                                 |      |
| codemaker                      |                                 |      |
| EclipseCodeFormatter           |                                 |      |
| FindBugs-IDEA                  |                                 |      |
| free mybatis plugin            | 快速查看mybatis 文件            |      |
| generateallsetter              | 一键调用一个对象的所有的set方法 |      |
| JUnitGenerator V2.0            | 单元测试相关                    |      |
| Key Promoter X                 | 快捷键提示                      |      |
| Lombok                         | 自动生成get、set                |      |
| Maven Helper                   |                                 |      |
| MyBatisCodeHelperPro           | mybatis 快捷工具                |      |
| PMDPlugin                      |                                 |      |
| POJO to JSON                   | 对象转JSON                      |      |
| Rainbow Brackets               |                                 |      |
| SonarLint                      | 代码质量管理                    |      |



## 启动顺序

在 IDEA 中，右键运行每个 `XXXApplication.java` 。例如说，`system-service` 项目是 SystemServiceApplication。

是否启动成功，请查看 IDEA 输出的日志。

具体的启动顺序，是：

- Auth服务
- 网关服务
- 基础管理服务(用户)
- 其它服务启动顺序依照相互依赖顺序

## 技术栈

### 后端

| 框架 | 说明 |  版本 |
| --- | --- | --- |
| [Spring Boot](https://spring.io/projects/spring-boot) | 应用开发框架 |  2.3. |
| [MySQL](https://www.mysql.com/cn/) | 数据库服务器 | 5.7 |
| [Druid](https://github.com/alibaba/druid) | JDBC 连接池、监控组件 | 1.1.16 |
| [MyBatis](http://www.mybatis.org/mybatis-3/zh/index.html) | 数据持久层框架 | 3.5.1 |
| [MyBatis-Plus](https://mp.baomidou.com/) | Mybatis 增强工具包 | 3.1.1 |
| [Redis](https://redis.io/) | key-value 数据库 | 5.0.5 |
| [Redisson](https://github.com/redisson/redisson) | Redis 客户端 | 待定 |
| [Elasticsearch](https://www.elastic.co/cn/) | 分布式搜索引擎 | 6.7.1 |
| [SpringCloud](https://spring.io/projects/spring-cloud#overview) | 分布式 RPC 服务框架 | Greenwich 2.1.4 |
| [RocketMQ](http://dubbo.apache.org/) | 消息中间件 | 4.3.2 |
| [Seata](https://github.com/seata/seata) | 分布式事务中间件 | 0.5.1 |
| [Zookeeper](http://zookeeper.apache.org/) | 分布式系统协调 | 3.4.9 作为注册中心 |
| [XXL-Job](http://www.xuxueli.com/xxl-job/) | 分布式任务调度平台 | 2.0.1 |
| [springfox-swagger2](https://github.com/springfox/springfox/tree/master/springfox-swagger2) | API 文档 | 2.9.2 |
| [swagger-bootstrap-ui](https://gitee.com/xiaoym/knife4j) | Swagger 增强 UI 实现 | 1.9.5 |
| [Nacos](https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html) | Nacos 帮助您更敏捷和容易地构建、交付和管理微服务平台 | 1.1.3 |
| [Sentinel](https://github.com/alibaba/Sentinel) | 流量控制、熔断降级 | 1.6.3 |
| [Flyway](https://flywaydb.org/documentation/) | 数据库同步 | 6.0.1 |
| [jmeter](https://jmeter.apache.org/) | 性能压力测试 | 5.1.1 |

### 监控链路跟踪

微服务场景下监控很重要，服务器的链路跟踪，问题的排查等，一般来说，监控会有三种方式：

* 1、Tracing ，采用 Apache SkyWalking
* 2、Logging ，采用 ELK   暂未搭建,让我想想看
* 3、Metrics ，采用 Prometheus

| 框架 | 说明 |  版本 |
| --- | --- | --- |
| [SkyWalking](http://skywalking.apache.org/) | 分布式应用追踪系统 | 6.0.0 |
| [Prometheus](https://prometheus.io/) | 服务监控体系 | 2.9.2 |
| [Alertmanager](https://prometheus.io/docs/alerting/alertmanager/) | 告警管理器 | 0.17.0 |
| [Grafana](https://grafana.com/) | 仪表盘和图形编辑器 | 0.17.0 |

## 运维

| 框架       | 说明                     |
| ---------- | ------------------------ |
| GitLab     | 代码管理平台             |
| Jenkins    | 持续集成                 |
| Docker     | 容器管理                 |
| Kubernetes | 容器编排                 |
| SonerQube  | 代码质量持续跟踪管理平台 |
| 代码生成器 | 统一代码生成器平台       |

# 最后的最后

一个高品质的产品是需要大家共同努力打造的，希望大家能够严格按照架构规范进行开发，我们不只是实现功能 ，还得赋予它具有高贵、优雅的灵魂。
