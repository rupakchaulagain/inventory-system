package com.inventory.utils.commons;

import lombok.extern.slf4j.Slf4j;

import static com.inventory.logs.CommonLogConstant.ERROR_LOG;


@Slf4j
public class LogUtils {
    public static void logError(String name) {
        log.error(ERROR_LOG,name);
    }
}
