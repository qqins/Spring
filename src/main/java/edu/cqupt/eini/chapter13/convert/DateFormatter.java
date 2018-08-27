package edu.cqupt.eini.chapter13.convert;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author: Hello World
 * @date: 2018/8/25 17:57
 */
public class DateFormatter implements Formatter<Date> {
    private String datePattern = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat simpleDateFormat;

    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        simpleDateFormat = new SimpleDateFormat(datePattern);
        return simpleDateFormat.parse(s);
    }

    @Override
    public String print(Date date, Locale locale) {
        return new SimpleDateFormat().format(date);
    }
}
