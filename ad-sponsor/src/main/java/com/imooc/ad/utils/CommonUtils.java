package com.imooc.ad.utils;

import com.imooc.ad.exception.AdException;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

public class CommonUtils {

    private static String[] parsePatterns={
            "yyyy-MM-dd","yyyy/MM/dd","yyyy.MM.dd"
//            接受的string格式
    };
    public static String md5(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }
//    add new function to covert string 2 date
//    use api
public static Date parseStringDate(String dateString) throws AdException {
        try {
            return DateUtils.parseDate(dateString,parsePatterns);
        }catch (Exception e){
            throw  new AdException(e.getMessage());
        }
}
}
