package com.sandbox.spring.chapter3.methodinjection.lookup;

/**
 * Uses Method Injection to obtain an instance of the MyHelper class.
 *
 * @author Andrii Sysoiev
 */
public abstract class AbstractLookupDemoBean implements DemoBean {

    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();
    }
}
