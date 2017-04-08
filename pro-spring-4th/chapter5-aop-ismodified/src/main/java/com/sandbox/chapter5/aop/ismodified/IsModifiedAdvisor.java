package com.sandbox.chapter5.aop.ismodified;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @author Andrii Sysoiev
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
    public IsModifiedAdvisor() {
        super(new IsModifiedInterceptor());
    }
}
