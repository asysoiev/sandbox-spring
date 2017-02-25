package com.sandbox.chapter4.lifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) {
        GenericXmlApplicationContext appContext = new GenericXmlApplicationContext();
        appContext.load("classpath:META-INF/spring/app-context-xml.xml");
        appContext.refresh();

        System.out.println("Handle by init method from configuration file");
        SimpleBean simpleBeanWithInitMethod1 = getBean("simpleBeanWithInitMethod1", appContext);
        SimpleBean simpleBeanWithInitMethod2 = getBean("simpleBeanWithInitMethod2", appContext);
        SimpleBean simpleBeanWithInitMethod3 = getBean("simpleBeanWithInitMethod3", appContext);

        System.out.println("Handle by InitializingBean interface");
        SimpleBean simpleBeanWithInterface1 = getBean("simpleBeanWithInterface1", appContext);
        SimpleBean simpleBeanWithInterface2 = getBean("simpleBeanWithInterface2", appContext);
        SimpleBean simpleBeanWithInterface3 = getBean("simpleBeanWithInterface3", appContext);

        System.out.println("Handle by Annotation(JCR250)");
        SimpleBean simpleBeanWithAnnotation1 = getBean("simpleBeanWithAnnotation1", appContext);
        SimpleBean simpleBeanWithAnnotation2 = getBean("simpleBeanWithAnnotation2", appContext);
        SimpleBean simpleBeanWithAnnotation3 = getBean("simpleBeanWithAnnotation3", appContext);

        System.out.println("Destroy context");
        appContext.destroy();
        System.out.println("Context was destroyed");

    }

    private static SimpleBean getBean(String beanName, ApplicationContext appContext) {
        try {
            SimpleBean bean = (SimpleBean) appContext.getBean(beanName);
            System.out.println(bean.getInfo());
            return bean;
        } catch (BeanCreationException e) {
            System.out.println("An error occured in bean configuration: " + e.getMessage());
            return null;
        }
    }

}
