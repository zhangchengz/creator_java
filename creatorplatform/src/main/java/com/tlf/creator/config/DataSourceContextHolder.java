package com.tlf.creator.config;

import java.util.ArrayList;
import java.util.List;

public class DataSourceContextHolder {

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "creator";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static List<Object> dataSourceKeys = new ArrayList<>();

    // 设置数据源名
    public static void setDB(String dbType) {
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }

    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }
}