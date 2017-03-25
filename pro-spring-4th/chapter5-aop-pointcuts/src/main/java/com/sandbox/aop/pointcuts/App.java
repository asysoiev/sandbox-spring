package com.sandbox.aop.pointcuts;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.StaticMethodMatcher;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import java.lang.reflect.Method;

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

        //region Control flow point cut
        System.out.println("Test Control flow pointcut");
        Pointcut flowPointCut = new ControlFlowPointcut(App.class, "testFlow");
        advisor = new DefaultPointcutAdvisor(flowPointCut, new SimpleAdvice());
        pf = new ProxyFactory();
        pf.setTarget(new BeanOne());
        pf.addAdvisor(advisor);
        beanOne = (BeanOne) pf.getProxy();
        System.out.println("Direct call:");
        beanOne.foo();
        System.out.println("Indirect call:");
        testFlow(beanOne);
        //endregion

        //region Composable Pointcut
        System.out.println("Test compose advisor");
        ComposeBean target = new ComposeBean();
        ComposablePointcut composablePointcut = new ComposablePointcut(ClassFilter.TRUE, new StaticMethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return method.getName().startsWith("get");
            }
        });

        pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(new DefaultPointcutAdvisor(composablePointcut, new SimpleBeforeAdvice()));

        System.out.println("Only getters");
        ComposeBean composeBean = (ComposeBean) pf.getProxy();
        composeBean.getName();
        composeBean.setName("Andrii Sysoiev");
        composeBean.getAge();

        composablePointcut.union(new StaticMethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return method.getName().startsWith("set");
            }
        });

        pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(new DefaultPointcutAdvisor(composablePointcut, new SimpleBeforeAdvice()));

        System.out.println("Getters and setters");
        composeBean = (ComposeBean) pf.getProxy();
        composeBean.getName();
        composeBean.setName("Andrii Sysoiev");
        composeBean.getAge();

        composablePointcut.intersection(new StaticMethodMatcher() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
                return method.getName().equals("getAge");
            }
        });

        pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(new DefaultPointcutAdvisor(composablePointcut, new SimpleBeforeAdvice()));

        System.out.println("Only getAge");
        composeBean = (ComposeBean) pf.getProxy();
        composeBean.getName();
        composeBean.setName("Andrii Sysoiev");
        composeBean.getAge();

        //endregion
    }

    private static void testFlow(BeanOne bean) {
        bean.foo();
    }

}
