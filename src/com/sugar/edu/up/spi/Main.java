package com.sugar.edu.up.spi;

/**
 * @Description todo
 * @Author sugar
 * @Date 2024/6/26 11:30 PM
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        LoggerService service=LoggerService.getService();
        service.info("Hello SPI");
        service.debug("Hello SPI");
    }
}
