package com.example;

import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathServiceTest {

    @Test
    void testFilePathCrossPlatform() {
        PathService service = new PathService();
        
        String folder = "data";
        String filename = "config.json";
        
        // Kết quả từ code thực tế
        String actualResult = service.getProjectFilePath(folder, filename);
        
        // Kết quả mong đợi cũng phải được khởi tạo linh hoạt theo OS của máy chạy test
        String expectedResult = Paths.get(folder, filename).toString();
        
        assertEquals(expectedResult, actualResult, 
            "Đường dẫn phải phù hợp với định dạng của hệ điều hành hiện tại");
    }
}