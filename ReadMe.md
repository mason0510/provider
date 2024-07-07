java.lang.NoClassDefFoundError: com/google/common/collect/Maps
升级下最新版本的 Dubbo，之前 Nacos 提供了 guava 的shade，但是高版本移除了。以前的 NacosRegistry 依赖了 guava 的api


[Dubbo 2.5.8] Telnet failed with 'java.lang.ClassNotFoundException: org.apache.commons.lang3.StringUtils'
We have add dubbo.application.qos.enable=true/false as a switch for qos, and commons-lang3 is still not transitive.
我的就是因为缺少commons-lang3-3.1.jar这个包报错的，

依赖
<dependency>
     <groupId>com.alibaba.cloud</groupId>
      <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
      <version>2.2.5.RELEASE</version>
</dependency>
<!--dubbo依赖版本-->
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>2.7.7</version>
</dependency>
<!--这个依赖很必要不然就会报标题的错误-->
<dependency>
     <groupId>com.alibaba.spring</groupId>
     <artifactId>spring-context-support</artifactId>
     <version>1.0.9</version>
</dependency>
<!--自己的公共Api依赖-->
<dependency>
       <groupId>com.record</groupId>
       <artifactId>record-public-api</artifactId>
</dependency>


apache dubbo 也存在此问题，应该是 nacos的包版本太高， dubbo包的版本太低造成的，如果把nacos的版本降低到 2.6.7 以下，【0.0.1，2.67】
可以正常启动


https://nacos.io/zh-cn/docs/quick-start-spring-boot.html

https://github.com/apache/dubbo/issues/4657
apache版本的dubbo有无数个bug, 代码质量非常差，建议大家不要升级到2.7以上，现在的开发人员质量太差了


https://blog.csdn.net/u012527870/article/details/81843504
<dependency>
<groupId>com.alibaba.boot</groupId>
<artifactId>dubbo-spring-boot-starter</artifactId>
<version>0.2.0</version>
<exclusions>
<exclusion>
<groupId>org.springframework</groupId>
<artifactId>spring-context</artifactId>
</exclusion>
</exclusions>
</dependency>

https://cn.dubbo.apache.org/zh-cn/overview/mannual/java-sdk/quick-start/spring-boot/
