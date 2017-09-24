package com.sandbox.chapter14.services;

import com.sandbox.chapter14.model.Contact;
import com.sandbox.chapter14.ruleengine.Rule;
import com.sandbox.chapter14.ruleengine.RuleEngine;
import com.sandbox.chapter14.ruleengine.RuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by andrii on 24.09.17.
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    private RuleFactory ruleFactory;
    @Autowired
    private RuleEngine ruleEngine;

    @Override
    public void applyRule(Contact contact) {
        Rule ageCategoryRule = ruleFactory.getAgeCategoryRule();
        ruleEngine.run(ageCategoryRule, contact);
    }
}
