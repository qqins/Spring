package edu.cqupt.eini.chapter13.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Hello World
 * @date: 2018/8/25 17:21
 */
public class DateConverter implements Converter<String, Date> {
    private String dataPattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat(dataPattern);
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效的日期格式，请使用这种格式：" + dataPattern);
        }
    }
}
