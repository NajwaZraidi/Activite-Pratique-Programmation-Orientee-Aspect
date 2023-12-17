package ma.enset.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* ma.enset.aop.test.Application.main(..))")
    public void MyPointcut() {}


    /*@Before("MyPointcut()")
    public void beforeMain() {
        System.out.println("******************************");
        System.out.println("Before main with class syntax");
        System.out.println("******************************");
    }
    @After("MyPointcut()")
    public void afterMain() {
        System.out.println("*****************************");
        System.out.println("After main with class syntax");
        System.out.println("*****************************");
    }*/
    @Around("MyPointcut()")
    public void aroundMain(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("******************************");
        System.out.println("Before main with class syntax");
        System.out.println("******************************");
        pjp.proceed();
        System.out.println("******************************");
        System.out.println("After main with class syntax");
        System.out.println("******************************");
    }
}
