package com.sandbox.chapter5.aop.aspectj;

public aspect MessageWrapper {

    private String prefix;
    private String sufix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSufix() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix = sufix;
    }

    pointcut doWriting():
            execution(* com.sandbox.chapter5.aop.aspectj.MessageWriter.writeMessage());

    before(): doWriting(){
        System.out.println(prefix);
    }

    after(): doWriting(){
        System.out.println(sufix);
    }
}