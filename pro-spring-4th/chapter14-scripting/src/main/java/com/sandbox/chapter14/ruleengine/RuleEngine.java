package com.sandbox.chapter14.ruleengine;

/**
 * Created by andrii on 24.09.17.
 */
public interface RuleEngine {
    void run(Rule rule, Object object);
}
