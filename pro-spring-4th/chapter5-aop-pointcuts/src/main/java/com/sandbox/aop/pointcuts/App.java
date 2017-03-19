package com.sandbox.aop.pointcuts;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        //region Static and Dynamic pointcuts
        BeanOne beanOne = new BeanOne();
        BeanTwo beanTwo = new BeanTwo();

        Pointcut pc = new StaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(beanOne);
        BeanOne proxy1 = (BeanOne) pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(new DynamicPointCut(), advice));
        pf.setTarget(beanTwo);
        BeanTwo proxy2 = (BeanTwo) pf.getProxy();

        proxy1.foo();
        proxy1.bar();
        proxy2.foo(1);
        proxy2.foo(10);
        proxy2.foo(100);
        proxy2.bar();
        proxy2.bar();
        proxy2.bar();
        //endregion

        //region Method name pointcut
        NameMatchMethodPointcut nmp = new NameMatchMethodPointcut();
        nmp.addMethodName("foo");
        nmp.addMethodName("bar");
        pf.addAdvisor(new DefaultPointcutAdvisor(nmp, advice));
        pf.setTarget(new NameBean());
        NameBean proxyNB = (NameBean) pf.getProxy();
        proxyNB.foo();
        proxyNB.foo(999);
        proxyNB.bar();
        proxyNB.yap();
        //endregion

        //region RegExp pointcut
        JdkRegexpMethodPointcut rmp = new JdkRegexpMethodPointcut();
        rmp.setPattern(".*foo.*");
        pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(rmp, advice));
        pf.setTarget(new RegExpBean());
        RegExpBean rgBean = (RegExpBean) pf.getProxy();
        rgBean.foo1();
        rgBean.foo2();
        rgBean.bar();
        //endregion

        //region AspectJExpression pointcut
        System.out.println("AspectJExpression example");
        AspectJExpressionPointcut ajp = new AspectJExpressionPointcut();
        ajp.setExpression("(execution(* foo*(..)))");
        pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(ajp, advice));
        pf.setTarget(new RegExpBean());
        RegExpBean proxyRegJ = (RegExpBean) pf.getProxy();
        proxyRegJ.foo1();
        proxyRegJ.foo2();
        proxyRegJ.bar();
        //endregion

        //region Annotation pointcut
        System.out.println("Annotation example");
        AnnotationMatchingPointcut amp = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
        pf = new ProxyFactory();
        pf.addAdvisor(new DefaultPointcutAdvisor(amp, advice));
        pf.setTarget(new BeanOne());
        BeanOne abo = (BeanOne) pf.getProxy();

        abo.foo();
        abo.bar();
        //endregion
    }

}
