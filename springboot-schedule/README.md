# SpringBoot @Scheduled ��ʱ����demo

@interface Scheduled��⣺
>String cron() default "";//��ʱ���ʽ
>String zone() default "";//ʱ��
>long fixedDelay() default -1;//��һ�ε�����ɺ��ӳٶ೤ʱ����ִ�и÷���
>long fixedRate() default -1;//ÿ�����ִ��һ��
>long initialDelay() default -1;//��ʼ�������ÿ�ʼִ��