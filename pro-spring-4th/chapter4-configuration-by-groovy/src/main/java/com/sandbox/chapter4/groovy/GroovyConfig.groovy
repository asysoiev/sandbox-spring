package com.sandbox.chapter4.groovy

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericXmlApplicationContext

def ctx = new GenericXmlApplicationContext();
def reader = new GroovyBeanDefinitionReader(ctx);

reader.beans {
    contact(Contact, firstName: "Andrii", lastName: "Sysoiev", age: 27)
}
ctx.refresh()

println ctx.getBean("contact")

