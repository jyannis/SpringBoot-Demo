# SpringBoot @Scheduled 定时任务demo

@interface Scheduled详解：
>String cron() default "";//定时表达式
>String zone() default "";//时区
>long fixedDelay() default -1;//第一次调用完成后，延迟多长时间再执行该方法
>long fixedRate() default -1;//每隔多久执行一次
>long initialDelay() default -1;//初始化后隔多久开始执行