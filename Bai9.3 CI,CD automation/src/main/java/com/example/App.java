package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static long factorial(int n) {
        logger.info("Đang tính giai thừa cho số: {}", n);
        if (n < 0) {
            logger.error("Số nhập vào không hợp lệ: {}", n);
            throw new IllegalArgumentException("Số phải >= 0");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Giai thừa của 5 là: " + factorial(5));
    }
}