package com.sandbox.chapter10.converters.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Andrii Sysoiev
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private String datePattern = DEFAULT_DATE_PATTERN;
    private DateTimeFormatter formatter;

    public String getDatePattern() {
        return datePattern;
    }

    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    public void init() {
        formatter = DateTimeFormatter.ofPattern(datePattern);
    }

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, formatter);
    }
}
