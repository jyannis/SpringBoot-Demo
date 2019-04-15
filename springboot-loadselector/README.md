# 基于ImportSelector的Enable模块装配
创建@EnableMyConfigSelector注解，使用@Import导入MyConfigSelector配置

在启动类Application上使用@EnableMyConfigSelector即可装载配置

启动时会出现"------->bean&nbsp;初始化"字样

***
***
***
**使用场景**：
***
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目导入第三方包时，一般无法直接扫描到第三方包的@Component等配置，

需要使用@Enable*装载

相比不使用Selector的手动装配方式更为灵活，可以实现不同条件下的不同装配