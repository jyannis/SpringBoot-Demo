# SpringBoot @Scheduled 定时任务demo
@interface Scheduled详解：

//定时表达式
>String cron() default "";

//时区
>String zone() default "";

//上一次执行开始时间点之后延迟一段时间再执行
>long fixedDelay() default -1;

//上一次执行完毕时间点之后延迟一段时间再执行
>long fixedRate() default -1;

//初始化后隔多久开始执行
>long initialDelay() default -1;
