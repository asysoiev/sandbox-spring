package com.sandbox.spring.chapter3.methodinjection.lookup;

/**
 * Uses Setter Injection to obtain an instance of the MyHelper class
 *
 * @author Andrii Sysoiev
 */
public class StandardLookupDemoBean implements DemoBean {

    private MyHelper myHelper;

    @Override
    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }

    @Override
    public void someOperation() {
        myHelper.doSomethingHelpful();
    }
}
