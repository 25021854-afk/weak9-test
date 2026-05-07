package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void testFactorial() {
        assertEquals(0, App.factorial(5));
        // sửa 120 thành 0 để gây lỗi
        assertEquals(1, App.factorial(0));
    }
}