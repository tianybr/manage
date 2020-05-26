package com.mall.common.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author bryin
 * @create 2020-05-23 17:44
 */
public class LevelUtils {
    public final static String SEPARATOR = ".";
    public final static String ROOT = "0";
    public static String calculateLevel(String parentLevel,Integer parentId){

        if(StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else{
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }
}
