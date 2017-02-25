package com.sandbox.chapter4.propertyeditors;

import java.beans.PropertyEditorSupport;

/**
 * @author Andrii Sysoiev
 */
public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] split = text.split("\\s");
        setValue(new Name(split[0], split[1]));
    }
}
