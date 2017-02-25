package com.sandbox.chapter4.propertyeditors;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Andrii Sysoiev
 */
public class CustomPropertyRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

        registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));

        registry.registerCustomEditor(Name.class, new NamePropertyEditor());
    }
}
