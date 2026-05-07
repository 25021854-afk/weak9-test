/**
 * BÁO CÁO PHÂN TÍCH LỖI:
 * 1. Giá trị FAIL: 5.0 (thực tế "Yeu", mong đợi "Trung binh") và 6.5 (thực tế "Trung binh", mong đợi "Kha").
 * 2. Nguyên nhân: Logic sử dụng toán tử "<=" khiến các điểm mút biên rơi sai nhóm điểm.
 */
public class GradeClassifierTest {
    public static void main(String[] args) {
        System.out.println("=== Bat dau chay Test ===");
        
        // Kiểm tra các test case (EP & BVA)
        check("Yeu", GradeClassifier.classifyGrade(0.0));
        check("Yeu", GradeClassifier.classifyGrade(4.9));
        check("Trung binh", GradeClassifier.classifyGrade(5.0));
        check("Trung binh", GradeClassifier.classifyGrade(6.4));
        check("Kha", GradeClassifier.classifyGrade(6.5));
        check("Kha", GradeClassifier.classifyGrade(7.9));
        check("Gioi", GradeClassifier.classifyGrade(8.0));
        check("Gioi", GradeClassifier.classifyGrade(10.0));
        
        // Kiểm tra ngoại lệ
        checkException(-0.1);
        checkException(10.1);
        
        System.out.println("=== Tat ca test PASS ===");
    }

    private static void check(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new RuntimeException("FAIL: Mong doi " + expected + " nhung nhan " + actual);
        }
    }

    private static void checkException(double gpa) {
        try {
            GradeClassifier.classifyGrade(gpa);
            throw new RuntimeException("FAIL: Khong nem loi cho gpa = " + gpa);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Exception cho " + gpa + " - Message: " + e.getMessage());
            if (!e.getMessage().contains("GPA khong hop le")) {
                throw new RuntimeException("FAIL: Sai noi dung thong bao loi");
            }
        }
    }
}