# 项目说明

构建一个基于springcloud微服务架构、分布式、高并发、高可用的前后端分离的电商、支付平台的实践项目。

# 架构说明

![image.png](https://upload-images.jianshu.io/upload_images/5700335-dab38445194e6729.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 架构摘要
#### 服务鉴权
通过`JWT`的方式来加强服务之间调度的权限验证，保证内部服务的安全性。

#### 监控
利用Spring Boot Admin 来监控各个独立Service的运行状态；利用Hystrix Dashboard来实时查看接口的运行状态和调用频率等。

#### 负载均衡
将服务保留的rest进行代理和网关控制，除了平常经常使用的node.js、nginx外，Spring Cloud系列的zuul和ribbon，可以帮我们进行正常的网关管控和负载均衡。其中扩展和借鉴国外项目的扩展基于JWT的`Zuul限流插件`，方面进行限流。

#### 服务注册与调用
基于Nacos来实现的服务注册与调用，在Spring Cloud中使用Feign, 我们可以做到使用HTTP请求远程服务时能与调用本地方法一样的编码体验，开发者完全感知不到这是远程方法，更感知不到这是个HTTP请求。

#### 熔断机制
因为采取了服务的分布，为了避免服务之间的调用“雪崩”，采用了`Hystrix`的作为熔断器，避免了服务之间的“雪崩”。

## 业务架构

![](http://pt2oc0mjk.bkt.clouddn.com/maruko-mall%20%E5%BC%80%E6%BA%90%E7%94%B5%E5%95%86%E6%9E%B6%E6%9E%84%E5%B9%B3%E5%8F%B0.jpg)

## 技术栈

### 后端

| 框架                                                      | 说明                                     | 版本              |
| --------------------------------------------------------- | ---------------------------------------- | ----------------- |
| spring cloud 全家桶                                       | spring cloud 全家桶                      | Greenwich.RELEASE |
| spring boot                                               | 微服务应用                               | 2.1.2.RELEASE     |
| kafka\rabbitmq                                            | MQ中间件                                 | 待定              |
| [Nacos](https://nacos.io/zh-cn/index.html)                | 服务发现、服务配置、服务元数据及流量管理 | 1.0               |
| [Sentinel](https://github.com/alibaba/Sentinel)           | 服务保障、流量控制、熔断                 |                   |
| [ace](https://gitee.com/geek_qi/cloud-platform)           | 框架脚手架                               |                   |
| [Zookeeper](http://zookeeper.apache.org/)                 | 分布式协调服务                           | 3.4.9             |
| redis                                                     | 缓存                                     | 5.0               |
| [mongodb]()                                               | 数据库                                   | 4.0               |
| [XXL-Job](http://www.xuxueli.com/xxl-job/)                | 分布式调度平台                           | 2.0.1             |
| [Elasticsearch](https://www.elastic.co/cn/)               | 分布式搜索                               | 6.7.1             |
| [Seata](https://github.com/seata/seata)                   | 分布式事务中间件                         | 0.5.1             |
| [MySQL](https://www.mysql.com/cn/)                        | 数据库                                   | 5.7               |
| [MyBatis](http://www.mybatis.org/mybatis-3/zh/index.html) | 数据持久层框架                           | 3.5.1             |
| [MyBatis-Plus](https://mp.baomidou.com/)                  | Mybatis 增强工具包                       | 3.1.1             |
| [Druid](https://github.com/alibaba/druid)                 | JDBC 连接池、监控组件                    | 1.1.16            |
| mycat                                                     | 数据库中间件                             | 待定              |
| [Leaf](https://github.com/Meituan-Dianping/Leaf)          | 基于美团的分布式 ID                      |                   |

### 前端

前端和后台管理系统界面使用VUE技术

| 框架                                                         | 说明       | 版本 |
| ------------------------------------------------------------ | ---------- | ---- |
| [Vue+Vuex+iView](https://github.com/xf717/Maruko-Mall-Vue)   | 前端PC商城 |      |
| vue-[element](https://github.com/PanJiaChen/vue-element-admin)-admin | 后台管理   |      |

## 近期计划

1.SSO 登录服务

2.短信服务

3.用户服务

4.补充框架整合


## License
Apache License Version 2.0