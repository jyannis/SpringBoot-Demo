package undestiny.springboot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class HttpRequestAspect {
 
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 环绕通知：
     *   环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     *   环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("print()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();//使切点方法执行
            logger.info("环绕通知接收到返回值：" + obj);
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


    /*@Pointcut注解表示表示横切点，哪些方法需要被横切*/
    /*pointcut expression表达式*/
    @Pointcut("execution(public * undestiny.springboot.*.*(..))")
    /*切点签名*/
    public void print() {
    }
 
    /*@Before注解表示在具体的方法之前执行*/
    @Before("print()")
    public void before(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
 
    /*@After注解表示在方法执行之后执行*/
    @After("print()")
    public void after() {
        logger.info("后置切面after……");
    }
 
    /*@AfterReturning注解用于获取方法的返回值*/
    @AfterReturning(pointcut = "print()", returning = "object")
    public void getAfterReturn(Object object) {
        logger.info("本次接口耗时={}ms", System.currentTimeMillis() - startTime.get());
        logger.info("afterReturning={}", object.toString());
    }


}