package com.sandbox.chapter10.converters.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author Andrii Sysoiev
 */
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private DateTimeFormatter dateFormat;
    private String datePattern = DEFAULT_DATE_PATTERN;
    private Set<Formatter<?>> formatters = new HashSet<Formatter<?>>();

    public String getDatePattern() {
        return datePattern;
    }

    @Autowired(required = false)
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @PostConstruct
    public void init() {
        dateFormat = DateTimeFormatter.ofPattern(datePattern);
        formatters.add(getDateTimeFormatter());
        setFormatters(formatters);
    }

    private Formatter<LocalDate> getDateTimeFormatter() {
        return new Formatter<LocalDate>() {

            @Override
            public String print(LocalDate localDate, Locale locale) {
                System.out.println("Formatting datetime: " + localDate);
                return dateFormat.format(localDate);
            }

            @Override
            public LocalDate parse(String text, Locale locale) throws ParseException {
                System.out.println("Parsing date string: " + text);
                return LocalDate.parse(text, dateFormat);
            }
        };
    }

}
