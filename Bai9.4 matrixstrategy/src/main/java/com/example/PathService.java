package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathService {
    /**
     * Phương thức nối folder và file name chuẩn hóa theo OS
     */
    public String getProjectFilePath(String folder, String file) {
        // Giải pháp đúng: java.nio.file.Paths tự động xử lý dấu phân cách
        Path path = Paths.get(folder, file);
        return path.toString();
    }
}