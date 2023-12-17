package ma.enset.aop.aspects;

import ma.enset.aop.metier.Compte;
import ma.enset.aop.metier.IMetierBanqueImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PatchRetraitAspect {
     @Pointcut("execution(* ma.enset.aop.metier.IMetierBanqueImpl.retirer(..))")
    public void MyPointcut() {}
    @Around("MyPointcut()")
    public Object aroundRetirer(ProceedingJoinPoint pjp, JoinPoint jp) throws Throwable {
        IMetierBanqueImpl metier = (IMetierBanqueImpl) jp.getTarget();
        double montant = (double) jp.getArgs()[1];
        Compte c = metier.consulterCompte((long) jp.getArgs()[0]);
        if (c.getSolde() < montant)
            throw new RuntimeException("Solde insuffisant");
        return pjp.proceed();
    }
}
